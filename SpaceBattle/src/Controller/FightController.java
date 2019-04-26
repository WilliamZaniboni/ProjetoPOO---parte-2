/********************************************************************************
 *   Programação Orientada à Objetos - 2019                                     *
 *   Universidade de São Paulo                                                  *
 *   Instituto de Ciências Matemáticas e Computação                             *
 *                                                                              *
 *   Trabalho 1 - Desenvolvimento de um jogo com interface gráfica              *
 *   Autores:                                                                   *
 *       João Matheus Siqueira Souza - NUSP: 10309100  (jmssouza)               *
 *       William Zaniboni Silva      - NUSP: 10309159  (WilliamZaniboni)        *
 *   SpaceBattle v1.0                                                           *
 *                                                                              *
 ********************************************************************************/
/* Essa  classe faz o controle do combate entre os rebeldes e o impérion dentro
 * do jogo. Como se trata  da versão 1.0, não faremos o uso de threads ou outras
 * técnicas para fazer o controle das interações entre os combatentes. Para esse
 * problema, desenvolvemos a abordagem de ciclos. A cada ciclo que se passa, são
 * analisados o campo de ataque de cada ícone no jogo, seu nível de vida e o ní-
 * vel de dano gerado nos ícones dentro do campo de ataque de cada um. Ao final,
 * os combatentes com nível de vida menor ou igual a zero são excluídos do jogo.*/

package Controller;

import Mathematics.BasicLinearAlgebra;
import Model.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class FightController implements Observer {
    //"TIME" CONTROL ===================================================================================================
        private int cycle = 0;


    //ICONS CONTROL ====================================================================================================
        private int rebels_number = 0;
        private int empire_number = 0;
        private ArrayList <SpaceIcon> rebels = new ArrayList();
        private ArrayList <SpaceIcon> empire = new ArrayList();
        private Battlefield battlefield;


    //CONSTRUCTOR ======================================================================================================
        public FightController(Battlefield battlefield) {
            this.battlefield = battlefield;
        }


    //METHODS ==========================================================================================================

        //Getters e Setters --------------------------------------------------------------------------------------------
            public int getRebels_number() {
                return rebels_number;
            }

            public int getEmpire_number() {
                return empire_number;
            }

            public ArrayList<SpaceIcon> getRebels() {
                return rebels;
            }

            public ArrayList<SpaceIcon> getEmpire() {
                return empire;
            }
        //Inserção de um novo SpaceIcon --------------------------------------------------------------------------------
            public boolean insertNewSpaceTower(int x, int y){
                if(battlefield.getMoveMatrix()[x][y] == 0){
                    rebels.add(new RebelSpaceTower(x, y));
                    rebels_number ++;
                    battlefield.setMoveMatrixField(x, y, 1);
                    battlefield.setOccupiedMatrix(x,y,1);
                    System.out.println("SpaceTower criada em: " + x + ", " + y);
                    return true;
                }
                else{
                    return false;
                }

            }

            public boolean insertNewStarship(int x, int y){
                if(battlefield.getMoveMatrix()[x][y] == 0){
                    rebels.add(new RebelStarship(x, y));
                    rebels_number ++;
                    battlefield.setMoveMatrixField(x, y, 1);
                    battlefield.setOccupiedMatrix(x,y,2);
                    System.out.println("Starshiṕ criada em: " + x + ", " + y);
                    return true;
                }
                else{
                    return false;
                }

            }

            public boolean insertNewStarbomb(int x, int y){
                if(battlefield.getMoveMatrix()[x][y] == 0){
                    rebels.add(new RebelStarbomb(x, y));
                    rebels_number ++;
                    battlefield.setMoveMatrixField(x, y, 1);
                    battlefield.setOccupiedMatrix(x,y,3);
                    System.out.println("Starbomb criada em: " + x + ", " + y);
                    return true;
                }
                else{
                    return false;
                }

            }

            public boolean insertNewEmpireShip(int y){
                if(battlefield.getMoveMatrix()[Constants.BATTLEFIELD_X_DIM][y] == 0){
                    empire.add(new EmpireShip(y));
                    empire_number ++;
                    battlefield.setMoveMatrixField(Constants.BATTLEFIELD_X_DIM, y, 2);
                    return true;
                }
                else{
                    return false;
                }
            }
         
           
            // retorna o objeto que ocupa determinado quadrante
            public int getMatrixpreenchida(int x, int y){
                return battlefield.getOccupiedMatrix(x, y);
            }
            
            
            
            

        //Métodos de operação durante um ciclo -------------------------------------------------------------------------
            public void moveEmpireShips(){
                for(int i = 0; i < empire_number; i++){
                    empire.get(i).Move(battlefield);
                }
            }

            public boolean isAlive(SpaceIcon fighter ,int[][] attackMatrix){
                fighter.setLife_value(fighter.getLife_value()-attackMatrix[fighter.getX()][fighter.getY()]);
                return fighter.getLife_value() >= 0;
            }

            public void cycle_interaction(){
                //Monta a matriz de ataque do ciclo --------------------------------------------------------------------
                    battlefield.zeroAttackMatrix();
                    BasicLinearAlgebra calculator = new BasicLinearAlgebra();
                    for(int i = 0; i < rebels_number; i++){
                        battlefield.setAttackMatrix(calculator.sumMatrix(battlefield.getAttackMatrix(), rebels.get(i).Attack(battlefield.getMoveMatrix())));
                    }
                    for(int i = 0; i < empire_number; i++){
                        battlefield.setAttackMatrix(calculator.sumMatrix(battlefield.getAttackMatrix(), empire.get(i).Attack(battlefield.getMoveMatrix())));
                    }
                //Atualiza dados de vida dos SpaceIcons e já os retira os ícones mortos --------------------------------
                //Rebels  ..............................................................................................
                    int flag_for_death = 0;
                    int[] flag_for_rebel_death = new int[rebels_number];
                    for(int i = 0; i < rebels_number; i++){
                        if(isAlive(rebels.get(i), battlefield.getAttackMatrix()) == false){  //Manteve-se formato sem simplificação para facilitar entendimento
                            flag_for_rebel_death[flag_for_death] = i;
                            flag_for_death++;
                        }
                    }
                    for(int i = 0; i < flag_for_death; i++){
                        battlefield.setMoveMatrixField(rebels.get(flag_for_rebel_death[i]).getX(), rebels.get(flag_for_rebel_death[i]).getY(), 0);
                        rebels.remove(flag_for_rebel_death[i]);
                        rebels_number--;
                    }
                //Empire ...............................................................................................
                    flag_for_death = 0;
                    int[] flag_for_empire_death = new int [empire_number];
                    for(int i = 0; i < empire_number; i++){
                        if(isAlive(empire.get(i), battlefield.getAttackMatrix()) == false){
                            flag_for_empire_death[flag_for_death] = i;
                            flag_for_death++;
                        }
                    }
                    for(int i = 0; i < flag_for_death; i++){
                        battlefield.setMoveMatrixField(empire.get(flag_for_empire_death[i]).getX(), empire.get(flag_for_empire_death[i]).getY(), 0);
                        rebels.remove(flag_for_empire_death[i]);
                        empire_number--;
                    }
            }

            public void cycle_routine(){
                this.moveEmpireShips();
                this.cycle_interaction();
                this.cycle++;
            }

        //Atualiza os dados do FightController com base em update do EnvironmentController -----------------------------
            @Override
            public void update(Observable o, Object arg) {
                EnvironmentController controller = (EnvironmentController) arg;
                if(controller.getUpdating_mode() == 0){
                    boolean isPossible;
                    if(controller.getFlag_for_rebel_choice() != 0){
                        if(controller.getFlag_for_rebel_choice() == 1){
                            isPossible = this.insertNewSpaceTower(controller.getLast_x_quad(), controller.getLast_y_quad());
                            controller.setFlag_for_rebel_choice(0);
                            controller.setLast_x_quad(0);
                            controller.setLast_y_quad(0);
                        }
                        else if(controller.getFlag_for_rebel_choice() == 2){
                            isPossible = this.insertNewStarship(controller.getLast_x_quad(), controller.getLast_y_quad());
                            controller.setFlag_for_rebel_choice(0);
                            controller.setLast_x_quad(0);
                            controller.setLast_y_quad(0);
                        }
                        else if(controller.getFlag_for_rebel_choice() == 3){
                            isPossible = this.insertNewStarbomb(controller.getLast_x_quad(), controller.getLast_y_quad());
                            controller.setFlag_for_rebel_choice(0);
                            controller.setLast_x_quad(0);
                            controller.setLast_y_quad(0);
                        }

                    }
                }
                else if (controller.getUpdating_mode() == 1){
                    this.cycle_routine();
                }
                else if (controller.getUpdating_mode() == 2 ){

                }
                else{

                }
            }


}
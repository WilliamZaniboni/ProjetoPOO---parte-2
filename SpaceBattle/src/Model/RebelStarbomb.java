package Model;

public class RebelStarbomb extends SpaceIcon{
    public RebelStarbomb(int x_position, int y_position){
        super(x_position, y_position, Constants.STARBOMB_LIFE);
    }

    @Override
    public void Move(Battlefield battlefield){
        //Os rebeldes não se movem, o jogador os dispõem de acordo com sua estratégia de ataque e esses se mantém fixos.
    }

    @Override
    public int[][] Attack(int[][] moveMatrix){
        int [][] rebel_starbomb_attack_matrix;

        rebel_starbomb_attack_matrix = new int[Constants.BATTLEFIELD_X_DIM][Constants.BATTLEFIELD_Y_DIM];

        //Primeira coluna
        if(moveMatrix[this.getX()+1][this.getY()] == 2){
            rebel_starbomb_attack_matrix[this.getX()+1][this.getY()] = Constants.STARSHIP_ATTACK;
        }
        //Segunda coluna
        if(moveMatrix[this.getX()+2][this.getY()] == 2){
            rebel_starbomb_attack_matrix[this.getX()+2][this.getY()] = Constants.STARSHIP_ATTACK;
        }
        if(moveMatrix[this.getX()+2][this.getY()-1] == 2){
            rebel_starbomb_attack_matrix[this.getX()+2][this.getY()-1] = Constants.STARSHIP_ATTACK;
        }
        if(moveMatrix[this.getX()+2][this.getY()+1] == 2){
            rebel_starbomb_attack_matrix[this.getX()+2][this.getY()+1] = Constants.STARSHIP_ATTACK;
        }
        //Terceira coluna
        if(moveMatrix[this.getX()+3][this.getY()] == 2){
            rebel_starbomb_attack_matrix[this.getX()+3][this.getY()] = Constants.STARSHIP_ATTACK;
        }
        if(moveMatrix[this.getX()+3][this.getY()-1] == 2){
            rebel_starbomb_attack_matrix[this.getX()+3][this.getY()-1] = Constants.STARSHIP_ATTACK;
        }
        if(moveMatrix[this.getX()+3][this.getY()-2] == 2){
            rebel_starbomb_attack_matrix[this.getX()+3][this.getY()-2] = Constants.STARSHIP_ATTACK;
        }
        if(moveMatrix[this.getX()+3][this.getY()+1] == 2){
            rebel_starbomb_attack_matrix[this.getX()+3][this.getY()+1] = Constants.STARSHIP_ATTACK;
        }
        if(moveMatrix[this.getX()+3][this.getY()-1] == 2){
            rebel_starbomb_attack_matrix[this.getX()+3][this.getY()+2] = Constants.STARSHIP_ATTACK;
        }

        return rebel_starbomb_attack_matrix;
    }

}

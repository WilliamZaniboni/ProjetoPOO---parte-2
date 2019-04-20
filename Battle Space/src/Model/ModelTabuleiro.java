/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author jbatista
 * ESTA CLASSE contem o MODELO DE DADOS da sua aplicação !!!!!
 * COloque nela APENAS os dados: acesso a um banco de dados, queries de SQL, suas pecas de xadrez, 
 * etc..
 */
public class ModelTabuleiro implements Observer{

    private final ArrayList<Peca> pecasPretas;
    private final ArrayList<Peca> pecasBrancas;

    public ModelTabuleiro()  {
        this.pecasPretas = new ArrayList<Peca>();
        this.pecasBrancas  = new ArrayList<Peca>();
        
        init();
    }
    
    private void init() {
        
        //inicializa time branco
        
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,0,6));
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,1,6));
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,2,6));
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,3,6));
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,4,6));
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,5,6));
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,6,6));
        pecasBrancas.add(new Peao(Peca.Cor.BRANCO,7,6));
        
        //inicializa time preto
        
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,0,1));
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,1,1));
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,2,1));
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,3,1));
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,4,1));
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,5,1));
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,6,1));
        pecasBrancas.add(new Peao(Peca.Cor.PRETO,7,1));
    }
    
    public Peca findPeca(int x, int y) {
        Peca peca = null;
        
        //desenha pecas Brancas
        for(Peca p : pecasBrancas){
            if(p.inSquare(x,y)){
                return p;
            }
        }
        
        //desenha pecas pretas
        for(Peca p : pecasPretas){
            if(p.inSquare(x,y)){
                return p;
            }
        }
        
        return peca;
    }
    
    public void draw(Graphics2D g){
        //desenha pecas Brancas
        for(Peca p : pecasBrancas){
           // p.draw(g);
        }
        
        //desenha pecas pretas
        for(Peca p : pecasPretas){
           // p.draw(g);
        }
    }
    
    
    @Override
    public void update(Observable o, Object arg) {
        draw((Graphics2D) arg);
    }
    
}

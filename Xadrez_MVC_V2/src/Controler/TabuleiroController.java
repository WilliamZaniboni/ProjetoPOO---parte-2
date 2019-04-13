/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.ModelTabuleiro;
import View.Tabuleiro;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 *
 * @author felipelageduarte
 */
public class TabuleiroController implements  MouseListener, MouseMotionListener{

  private Tabuleiro view;
  private ModelTabuleiro model;
  
    public void addView (Tabuleiro view){
        this.view = view;
    }
    
    public void addModel (ModelTabuleiro model){
        this.model = model;
    }
    
    /*
      USe este metodo para iniciar o seu VIEW... neste caso, antes de motra-lo
    na tela, o posicionamos no centro dela....
    */
    public void runTabuleiro() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - view.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - view.getHeight()) / 2);
        view.setLocation(x, y);
        
        view.setVisible(true);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
       int x = e.getX();//pega as coordenadas do mouse
        int y = e.getY();
        int teste1 = (x - 327)/54;
        int teste2 = (y - 94)/54;
        
        if(x<327){
            
            view.getClickLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
            
        }else if(x>1135){
            view.getClickLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
     
        }
        else if(y<94){
            view.getClickLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
        }
        else if(y>526){
            view.getClickLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
        }
        else{
            view.getClickLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: ["+teste1+","+teste2+"]");
        }
        
    
        
       
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();//pega as coordenadas do mouse
        int y = e.getY();
        
        int teste1 = (x - 327)/54;
        int teste2 = (y - 94)/54;
        
        if(x<327){
            
            view.getCoordenadaLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
            
        }else if(x>1135){
             view.getCoordenadaLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
     
        }
        else if(y<94){
             view.getCoordenadaLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
        }
        else if(y>526){
             view.getCoordenadaLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: [null]");
        }
        else{
            view.getCoordenadaLabel().setText("x:"+x+"  y:"+y+"   -   Quadrante: ["+teste1+","+teste2+"]");
        }
        
        

        view.getMouseCoord().setLocation(x, y);
        view.repaint();
    }

}

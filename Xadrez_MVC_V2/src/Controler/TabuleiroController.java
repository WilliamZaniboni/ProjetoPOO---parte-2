/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.ModelTabuleiro;
import View.Tabuleiro;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


/**
 *
 * @author felipelageduarte
 */
public class TabuleiroController implements  MouseListener, MouseMotionListener, ActionListener{

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
        
        
      //torna invisivel as labels de atributo depois de um clique no tabuleiro  
        
      view.getjLabel4().setVisible(false);
      view.getjLabel5().setVisible(false);
      view.getjLabel6().setVisible(false);
      
      
      view.setClickButton1(false);
      view.setClickButton2(false);
      view.setClickButton3(false);
      
      
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
       //verifica de onde veio o evento pressionar botão e torna visivel os atributos da nave escolhida
      if(ae.getSource() == view.getbutton_nave1()){
           view.getjLabel5().setVisible(true);
           view.setClickButton1(true);
      }
      
       if(ae.getSource() == view.getbutton_nave2()){
           view.getjLabel6().setVisible(true);
           view.setClickButton2(true);
      }
       
       if(ae.getSource() == view.getbutton_nave3()){
           view.getjLabel4().setVisible(true);
           view.setClickButton3(true);
      }
      
      
    }

    
    
    
    

}

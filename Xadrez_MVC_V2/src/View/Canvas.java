/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Peca;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class Canvas extends JPanel{
    
    private ArrayList<Observer> observers;
    protected final static String imgPath = "img/cima.jpg";
    protected static BufferedImage pecasImg = null;    

    public Canvas() {
        super();
        observers = new ArrayList<Observer>();
    }
    
    public void registerObserver(Observer ob){
        this.observers.add(ob);
    }
    
    
    private void drawBoard(Graphics2D g){
        
        
        if(pecasImg == null){
            try {
                pecasImg = ImageIO.read(new File(imgPath));
            } catch (IOException ex) {
                Logger.getLogger(Peca.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        g.drawImage(pecasImg, 0, 0, 1292, 553, null);
        
       
    }
    
    
    
    @Override //sobrescrita do metodo paintComponent da classe JPanel
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //desenhaTabuleiro(g);
        Graphics2D g2 = (Graphics2D)g;
        this.drawBoard(g2);
        // Depois de desenhar o tabuleiro, desenha o resto.
        // temos 2 observers registrados: o Tabuleiro 
        for(Observer ob : observers){
            ob.update(null, g2);
        }
    }
    
}

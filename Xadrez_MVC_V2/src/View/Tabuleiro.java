/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * tabuleiro.java
 *
 * Created on 03/03/2011, 18:28:20
 */
package View;

import Controler.TabuleiroController;
import Model.ModelTabuleiro;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 *
 * @author felipelageduarte
 */
public class Tabuleiro extends javax.swing.JFrame implements Observer {

    
  private Canvas canvas;  
  private Point mouseCoord;
  private ModelTabuleiro model;
  //private JPanel CanvasD;//atributo com a janela de desenho
  
  /** Creates new form tabuleiro */
  public Tabuleiro(ModelTabuleiro model) {
    initComponents();
    canvas = new Canvas();
    mouseCoord = new Point();
    canvas.registerObserver(this);
    this.model = model;
    canvas.registerObserver(model);
    
    Dimension area = new Dimension(jPCanvas.getWidth(), jPCanvas.getHeight());
    canvas.setPreferredSize(area);//set dimensao do painel de desenho
    jPCanvas.setLayout(new FlowLayout());
    jPCanvas.add(canvas);  
    
  }

    public Point getMouseCoord() {
        return mouseCoord;
    }

    public void setMouseCoord(Point mouseCoord) {
        this.mouseCoord = mouseCoord;
    }
  
    public JLabel getClickLabel() {
        return clickLabel;
    }

    public JLabel getCoordenadaLabel() {
        return coordenadaLabel;
    }

    public void setClickLabel(JLabel clickLabel) {
        this.clickLabel = clickLabel;
    }

    public void setCoordenadaLabel(JLabel coordenadaLabel) {
        this.coordenadaLabel = coordenadaLabel;
    }

    
    public void addController(TabuleiroController controller){
        jPCanvas.addMouseListener(controller);
        jPCanvas.addMouseMotionListener(controller);
    }
  
 public void drawMouseQuadrante(Graphics2D g) {
        
        int width = canvas.getWidth()/8;
        int height = canvas.getHeight()/8;
        
        int teste1 = mouseCoord.x - 327;
        int teste2 = mouseCoord.y - 94; 
        
        //System.out.println("p = " + teste1);
        
        int qx = teste1/54;
        int qy = teste2/54;
        //System.out.println(qx + "   " + qy);
        
       // int squareWidth = g.getClip().getBounds().width / 8;
       // int squareHeight = g.getClip().getBounds().height / 8;
       
        int squareWidth = 54;
        int squareHeight = 54;
        
        
       // squareWidth++; // gambiarra 1
       // squareHeight++;  // gambiarra 2

        //System.out.println(squareWidth + "   " + squareHeight);
        
        if((mouseCoord.x>=327) && (mouseCoord.x<=1135) && (mouseCoord.y<=517) && (mouseCoord.y>=88)){
        
        g.setColor(Color.yellow);
        g.setStroke(new BasicStroke(2));
        g.drawRect(qx * squareWidth+327, qy * squareHeight+87, squareWidth, squareHeight);
        g.setColor(Color.BLACK);
        
        }
    }   
    
    
  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCanvas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        coordenadaLabel = new javax.swing.JLabel();
        clickLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCC0204 - Xadrez");
        setResizable(false);

        jPCanvas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPCanvas.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPCanvas.setMinimumSize(new java.awt.Dimension(400, 400));
        jPCanvas.setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout jPCanvasLayout = new javax.swing.GroupLayout(jPCanvas);
        jPCanvas.setLayout(jPCanvasLayout);
        jPCanvasLayout.setHorizontalGroup(
            jPCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1276, Short.MAX_VALUE)
        );
        jPCanvasLayout.setVerticalGroup(
            jPCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        jLabel2.setText("Coordenada:");

        jLabel3.setText("click:");

        coordenadaLabel.setText(" ");

        clickLabel.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(coordenadaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(210, 210, 210))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(clickLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(246, 246, 246))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(coordenadaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(clickLabel)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clickLabel;
    private javax.swing.JLabel coordenadaLabel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPCanvas;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        drawMouseQuadrante((Graphics2D) arg);
    }
}

/*
class Canvas extends JPanel {
    @Override //sobrescrita do metodo paintComponent da classe JPanel
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    desenhaTabuleiro(g);
  }
  
  private void desenhaTabuleiro(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
    // 64 é o numedo de quadrantes de um tabuleiro de xadrez
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {        
        if ((j+i) % 2 == 0) g2d.setColor(Color.black);
        else g2d.setColor(Color.white);
        g2d.fillRect(j * 50, i*50, 50, 50);
      }
    }
  }
  
}
*/

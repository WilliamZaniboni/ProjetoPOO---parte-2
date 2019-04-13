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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author felipelageduarte
 */
public class Tabuleiro extends javax.swing.JFrame implements Observer {

    
  private Canvas canvas;  
  private Point mouseCoord;
  private ModelTabuleiro model;
 // private JLabel JLabel1;
  
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
    
    Color minhaCor = new Color(40, 40, 40); //pintando o fundo da cor preta 
    
    this.getContentPane().setBackground(minhaCor);
    
    //adicionando os botões sobre o panel que apresenta a parte de baixo do fundo
    
    //botão 1
    
    ImageIcon imgButton = new ImageIcon("img/nave.pNg");
    JButton button_nave1 = new JButton(imgButton);  
    button_nave1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 242, 0), 3)); //cor amarela ao redor do botão
    jLabel1.add(button_nave1); 
    button_nave1.setBounds(420, 30, 106, 94);  
    
    //botão 2
    
    
    JButton button_nave2 = new JButton(imgButton);  
    button_nave2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 242, 0), 3)); //cor amarela ao redor do botão
    jLabel1.add(button_nave2); 
    button_nave2.setBounds(560, 30, 106, 94); 
    
     //botão 3
     
    
    JButton button_nave3 = new JButton(imgButton);  
    button_nave3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(255, 242, 0), 3)); //cor amarela ao redor do botão
    jLabel1.add(button_nave3); 
    button_nave3.setBounds(700, 30, 106, 94); 
    
    
    //Adicionando os labels com as coordenadas do mouse sobre o panel
    
    jLabel1.add(jLabel2);
    jLabel2.setBounds(4, 130, 74, 16); 
    
    jLabel1.add(coordenadaLabel);
    coordenadaLabel.setBounds(78, 130, 540, 16); 
    
    jLabel1.add(jLabel3);
    jLabel3.setBounds(4, 146, 91, 16);
    
    jLabel1.add(clickLabel);
    clickLabel.setBounds(96, 146, 540, 16); 
     
     
    
    
    
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
        jLabel3 = new javax.swing.JLabel();
        coordenadaLabel = new javax.swing.JLabel();
        clickLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SCC0204 - Battle Space");
        setBackground(new java.awt.Color(51, 255, 51));
        setPreferredSize(new java.awt.Dimension(1292, 776));
        setResizable(false);

        jPCanvas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPCanvas.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPCanvas.setMinimumSize(new java.awt.Dimension(400, 400));
        jPCanvas.setPreferredSize(new java.awt.Dimension(1280, 720));

        javax.swing.GroupLayout jPCanvasLayout = new javax.swing.GroupLayout(jPCanvas);
        jPCanvas.setLayout(jPCanvasLayout);
        jPCanvasLayout.setHorizontalGroup(
            jPCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPCanvasLayout.setVerticalGroup(
            jPCanvasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Click do mouse:");

        coordenadaLabel.setBackground(new java.awt.Color(0, 0, 0));
        coordenadaLabel.setForeground(new java.awt.Color(255, 255, 255));
        coordenadaLabel.setText(" ");

        clickLabel.setBackground(new java.awt.Color(0, 0, 0));
        clickLabel.setForeground(new java.awt.Color(255, 255, 255));
        clickLabel.setText(" ");

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Coordenada:");

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\willi\\Desktop\\editando imagem\\baixo.png")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coordenadaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clickLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPCanvas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPCanvas, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(coordenadaLabel)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(clickLabel))
                    .addComponent(jLabel2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clickLabel;
    private javax.swing.JLabel coordenadaLabel;
    private javax.swing.JLabel jLabel1;
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

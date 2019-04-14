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
import java.awt.Image;
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
  private JButton button_nave1;
  private JButton button_nave2;
  private JButton button_nave3;
  
 
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
    
    ImageIcon imgButton = new ImageIcon("img/nave.png");
    Color cor_transparente  = new Color(100,100,100,100);
    button_nave1 = new JButton(imgButton);
    //button_nave1.setBackground(minhaCor);
    button_nave1.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(79, 206, 234), 3)); //cor ao redor do botão
    jLabel1.add(button_nave1); 
    button_nave1.setBounds(560, 30, 106, 94);  
    
    button_nave1.setToolTipText("NAVE1 - COLOCAR CARACTERISTICAS AQUI "); //janela de texto que aparece quando passa o mouse sobre o botão
    
    //botão 2
  
    button_nave2 = new JButton(imgButton);  
    button_nave2.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(79, 206, 234), 3)); //cor amarela ao redor do botão
    jLabel1.add(button_nave2); 
    //button_nave2.setBackground(cor_transparente);
    button_nave2.setBounds(700, 30, 106, 94); 
    button_nave2.setToolTipText("NAVE2 - COLOCAR CARACTERISTICAS AQUI "); //janela de texto que aparece quando passa o mouse sobre o botão
    
     //botão 3
     
    button_nave3 = new JButton(imgButton);  
    button_nave3.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(79, 206, 234), 3)); //cor amarela ao redor do botão
    jLabel1.add(button_nave3); 
    // button_nave3.setBackground(cor_transparente);
    button_nave3.setBounds(840, 30, 106, 94); 
    button_nave3.setToolTipText("NAVE3 - COLOCAR CARACTERISTICAS AQUI" ); //janela de texto que aparece quando passa o mouse sobre o botão
    
    /////////////////
 
    //Adicionando os labels com as coordenadas do mouse sobre o panel
    
    jLabel1.add(jLabel2);
    jLabel2.setBounds(4, 130, 74, 16); 
    
    jLabel1.add(coordenadaLabel);
    coordenadaLabel.setBounds(78, 130, 540, 16); 
    
    jLabel1.add(jLabel3);
    jLabel3.setBounds(4, 146, 91, 16);
    
    jLabel1.add(clickLabel);
    clickLabel.setBounds(96, 146, 540, 16); 
    
    
    
    //Adicionando os labels que apresentam os atributos e deixando set visible false
    
    jLabel1.add(jLabel4);
    jLabel4.setBounds(300, 30, 212, 110); 
    jLabel4.setVisible(false);
    
    jLabel1.add(jLabel5);
    jLabel5.setBounds(300, 30, 212, 110); 
    jLabel5.setVisible(false);
    
    jLabel1.add(jLabel6);
    jLabel6.setBounds(300, 30, 212, 110); 
    jLabel6.setVisible(false);
    
  }
  
  public void addController(TabuleiroController controller){
        jPCanvas.addMouseListener(controller);
        jPCanvas.addMouseMotionListener(controller);
        button_nave1.addActionListener(controller);
        button_nave2.addActionListener(controller);
        button_nave3.addActionListener(controller);
    }
 
    //adicionando os getters dos botões

   public JButton getbutton_nave1(){
        return button_nave1;
    }
   
   public JButton getbutton_nave2(){
        return button_nave2;
    }
   
   
   public JButton getbutton_nave3(){
        return button_nave3;
    }
  
  //adicionando os getters e setters dos labels com atributos
  
    public JLabel getjLabel4() {
        return jLabel4;
    }
    
    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }
    
    public JLabel getjLabel5() {
        return jLabel5;
    }

    public void setjLabel5(JLabel jLabel5) {
        this.jLabel5 = jLabel5;
    }
    
    public JLabel getjLabel6() {
        return jLabel6;
    }

    public void setjLabel6(JLabel jLabel6) {
        this.jLabel6 = jLabel6;
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
    
    
    //variaveis para verificar se o botão foi pressionado e printar (metodo drawMouseQuadrante) o png da nave selecionada na posição do  mouse
    
    boolean k = false;
    
    public void setClickButton1(boolean i){
      k=i;   
    }
    
    public boolean getClickButton1(){
        return k;
    }
    
    boolean l = false;
    
    public void setClickButton2(boolean i){
      l=i;   
    }
    
    public boolean getClickButton2(){
        return l;
    }
    
    boolean j = false;
    
    public void setClickButton3(boolean i){
      j=i;   
    }
    
    public boolean getClickButton3(){
        return j;
    }
    

 public void drawMouseQuadrante(Graphics2D g) { //desenhando um quadrado em volta do quadrante
        
        int width = canvas.getWidth()/8;
        int height = canvas.getHeight()/8;
        
        int pmousex = mouseCoord.x - 327;
        int pmousey = mouseCoord.y - 94; 
        
        int qx = pmousex/54;
        int qy = pmousey/54;
        
       
        int squareWidth = 54;
        int squareHeight = 54;
       
        if((mouseCoord.x>=327) && (mouseCoord.x<=1135) && (mouseCoord.y<=517) && (mouseCoord.y>=88)){
            
       // desenha um quadrado amarelo se o quadrante esta vazio - ainda não esta verificando se o quadrante esta ocupado    
        
        g.setColor(Color.yellow);
        g.setStroke(new BasicStroke(2));
        g.drawRect(qx * squareWidth+327, qy * squareHeight+87, squareWidth, squareHeight);
        g.setColor(Color.BLACK);
        
        //quadrantes de ataque // colocar um verificador para ver se o quadrante esta ocupado e o tipo de objeto que esta ocupando ele
        
        //et1 //ataques horizontais apenas para a esquerda (linha 202 até 211)
        
        /*
        
        for(int i=0; i<15; i++){
            
        if((qx * squareWidth+327-54*i)>=327){    
        g.setColor(Color.red);
        g.setStroke(new BasicStroke(2));
        g.drawRect(qx * squareWidth+327-54*i, qy * squareHeight+87, squareWidth, squareHeight);
        g.setColor(Color.BLACK);
        }
        
        }
        
        */
        
        //ataques em um raio de r quadrantes  (linha 217 até 284)
        
        
        /*
        int r=3;
        int constante =0;
        
        for(int j=r;j>-1;j--){
            
        if((qx * squareWidth+327-54*j>=327) ){
            
           for(int k = 0; k<constante+1; k++){
            
          if((qy * squareHeight+87+k*54<=517)){
              
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(2));  
            g.drawRect(qx * squareWidth+327-54*j, qy * squareHeight+87+k*54, squareWidth, squareHeight);
            g.setColor(Color.BLACK);
            
        }  
          
          if((qy * squareHeight+87-k*54>=87)){
              
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(2));  
            g.drawRect(qx * squareWidth+327-54*j, qy * squareHeight+87-k*54, squareWidth, squareHeight);
            g.setColor(Color.BLACK);
            
        }  
            
        }
           
        }    
        
        constante = constante+1;
        
        }
        
         constante=0;
        
        for(int j=r;j>0;j--){
            
        if((qx * squareWidth+327+54*j<=1136)){
            
           for(int k = 0; k<constante+1; k++){
            
          if((qy * squareHeight+87+k*54<=517)){
              
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(2));  
            g.drawRect(qx * squareWidth+327+54*j, qy * squareHeight+87+k*54, squareWidth, squareHeight);
            g.setColor(Color.BLACK);
            
        }  
          
          if((qy * squareHeight+87-k*54>=87)){
              
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(2));  
            g.drawRect(qx * squareWidth+327+54*j, qy * squareHeight+87-k*54, squareWidth, squareHeight);
            g.setColor(Color.BLACK);
            
        }  
            
        }
           
        }    
        
        constante = constante+1;
        
        }
        */
        
        
        //adicionando o png ao mouse apos clicar no botão 
        
        if(this.getClickButton1() == true){
        
        ImageIcon referencia  = new ImageIcon("img/navehd.png");
        Image nave = referencia.getImage();
        
        g.drawImage(nave,mouseCoord.x, mouseCoord.y, this);
        
        }
        
        if(this.getClickButton2() == true){
        
        ImageIcon referencia  = new ImageIcon("img/navehd.png");
        Image nave = referencia.getImage();
        
        g.drawImage(nave,mouseCoord.x, mouseCoord.y, this);
        
        }
        
        if(this.getClickButton3() == true){
        
        ImageIcon referencia  = new ImageIcon("img/navehd.png");
        Image nave = referencia.getImage();
        
        g.drawImage(nave,mouseCoord.x, mouseCoord.y, this);
        
        }
        
        
        
        
        
        
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
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/atributos_nave3.png"))); // NOI18N

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/baixo.png"))); // NOI18N

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/atributos_nave1.png"))); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/atributos_nave2.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPCanvas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1292, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(coordenadaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clickLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(378, 378, 378))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(190, 190, 190)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(890, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(437, 437, 437)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(643, Short.MAX_VALUE)))
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
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(769, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(64, 64, 64)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(780, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(53, 53, 53)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel clickLabel;
    private javax.swing.JLabel coordenadaLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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

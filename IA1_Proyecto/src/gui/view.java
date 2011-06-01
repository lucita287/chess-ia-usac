/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * view.java
 *
 * Created on 14/03/2011, 10:50:53 AM
 */

package gui;

import gui.jugador.piezas_jugador;
import gui.jugador.tablero;
import gui.resources.image_drive;
import gui.resources.variable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.JOptionPane;


public final class view extends javax.swing.JFrame {

    private JLabel fondo[][]=new JLabel[8][8];
    private JLabel muertan[][]=new JLabel[4][4];
    private JLabel muertab[][]=new JLabel[4][4];
    public int m_negra=0, m_blanca=0;
    private image_drive image_drive=new image_drive();
    public boolean turno, fin;
    public piezas_jugador jugador1;
    public piezas_jugador jugador2;
    public tablero tablero;
    public boolean colorjugador1;
    public boolean cpu;
    
    /** Creates new form view */
    public view(boolean humanovrscpu, boolean colorhumano) {
        initComponents();
        setBounds(new java.awt.Rectangle(150, 0, 950, 770));
        tablero=new tablero();
        this.cpu=humanovrscpu;
        this.colorjugador1=colorhumano;
        turno=variable.BLANCA;
        
        Dibujar();
        Turno();
        //this.setMaximumSize(this.getMaximumSize());
    }      

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tablero_principal = new javax.swing.JSplitPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        estado = new javax.swing.JLabel();
        split1 = new javax.swing.JSplitPane();
        letras = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        Tablero = new javax.swing.JPanel();
        jSplitPane2 = new javax.swing.JSplitPane();
        jSplitPane3 = new javax.swing.JSplitPane();
        jSplitPane4 = new javax.swing.JSplitPane();
        consola = new javax.swing.JTextField();
        estado1 = new javax.swing.JLabel();
        muertas = new javax.swing.JSplitPane();
        mnegras = new javax.swing.JPanel();
        mblancas = new javax.swing.JPanel();
        numeros = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        rendirse = new javax.swing.JMenuItem();
        reiniciar = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajedrez");
        setBounds(new java.awt.Rectangle(75, 100, 640, 640));
        setLocationByPlatform(true);
        setResizable(false);
        setUndecorated(true);

        tablero_principal.setBorder(null);
        tablero_principal.setEnabled(false);
        tablero_principal.setMinimumSize(new java.awt.Dimension(110, 55));
        tablero_principal.setPreferredSize(new java.awt.Dimension(900, 700));

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setEnabled(false);

        estado.setFont(new java.awt.Font("Tahoma", 1, 24));
        estado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/bpeon.png"))); // NOI18N
        estado.setText("Turno de: Blancas");
        estado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        estado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        estado.setMaximumSize(new java.awt.Dimension(640, 35));
        estado.setMinimumSize(new java.awt.Dimension(100, 35));
        estado.setOpaque(true);
        estado.setPreferredSize(new java.awt.Dimension(640, 35));
        jSplitPane1.setTopComponent(estado);

        split1.setBorder(null);
        split1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        split1.setDoubleBuffered(true);
        split1.setEnabled(false);
        split1.setMinimumSize(new java.awt.Dimension(640, 650));
        split1.setPreferredSize(new java.awt.Dimension(650, 650));

        letras.setMinimumSize(new java.awt.Dimension(640, 5));
        letras.setPreferredSize(new java.awt.Dimension(640, 5));
        letras.setLayout(new java.awt.GridLayout(1, 8));
        split1.setBottomComponent(letras);
        letras.getAccessibleContext().setAccessibleParent(split1);

        scroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scroll.setMinimumSize(new java.awt.Dimension(642, 642));
        scroll.setPreferredSize(new java.awt.Dimension(642, 642));

        Tablero.setMinimumSize(new java.awt.Dimension(640, 640));
        Tablero.setPreferredSize(new java.awt.Dimension(640, 640));
        Tablero.setLayout(null);
        scroll.setViewportView(Tablero);

        split1.setTopComponent(scroll);

        jSplitPane1.setBottomComponent(split1);

        tablero_principal.setLeftComponent(jSplitPane1);

        jSplitPane2.setDoubleBuffered(true);
        jSplitPane2.setEnabled(false);

        jSplitPane3.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        jSplitPane4.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane4.setEnabled(false);

        consola.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                consolaKeyPressed(evt);
            }
        });
        jSplitPane4.setTopComponent(consola);

        estado1.setFont(new java.awt.Font("Tahoma", 1, 24));
        estado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        estado1.setText("Piezas Muertas");
        estado1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        estado1.setMaximumSize(new java.awt.Dimension(240, 35));
        estado1.setMinimumSize(new java.awt.Dimension(100, 35));
        estado1.setOpaque(true);
        estado1.setPreferredSize(new java.awt.Dimension(240, 35));
        jSplitPane4.setBottomComponent(estado1);

        jSplitPane3.setTopComponent(jSplitPane4);

        muertas.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        muertas.setDoubleBuffered(true);
        muertas.setMinimumSize(new java.awt.Dimension(240, 670));
        muertas.setPreferredSize(new java.awt.Dimension(240, 670));

        mnegras.setMinimumSize(new java.awt.Dimension(240, 320));
        mnegras.setPreferredSize(new java.awt.Dimension(240, 320));
        mnegras.setLayout(null);
        muertas.setTopComponent(mnegras);
        mnegras.getAccessibleContext().setAccessibleParent(muertas);

        mblancas.setMinimumSize(new java.awt.Dimension(240, 320));
        mblancas.setPreferredSize(new java.awt.Dimension(240, 320));
        mblancas.setLayout(null);
        muertas.setBottomComponent(mblancas);

        jSplitPane3.setBottomComponent(muertas);

        jSplitPane2.setRightComponent(jSplitPane3);

        numeros.setMinimumSize(new java.awt.Dimension(20, 670));
        numeros.setPreferredSize(new java.awt.Dimension(20, 670));
        numeros.setLayout(new java.awt.GridLayout(9, 0));
        jSplitPane2.setLeftComponent(numeros);

        tablero_principal.setRightComponent(jSplitPane2);
        jSplitPane2.getAccessibleContext().setAccessibleParent(tablero_principal);

        jMenu1.setText("Opciones");

        rendirse.setText("Rendirse");
        rendirse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rendirseActionPerformed(evt);
            }
        });
        jMenu1.add(rendirse);

        reiniciar.setText("Reiniciar");
        reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Reiniciar(evt);
            }
        });
        jMenu1.add(reiniciar);

        salir.setText("Salir");
        salir.setText("Salir");
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jMenu1.add(salir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("?");
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablero_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablero_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public void Finish(String txt){
        /**System.out.println("# DE PIEZAS BLANCAS");
        jugador1.vivos.Ver();
        System.out.println("# DE PIEZAS NEGRAS");
        jugador2.vivos.Ver();
         * **/
        Object[] options = {"Si",
                            "No"};
        int n = JOptionPane.showOptionDialog(null,
            "JAQUE MATE\n"
            +"Han Perdido las Piezas "+txt
            + "\n\nDesea Salirse del Juego?\n",
            "FIN DEL JUEGO!!!",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,     //do not use a custom Icon
            options,  //the titles of buttons
            options[0]); //default button title

        if(n==0){
            System.exit(1);
        }
        fin=true;
    }

    public void Reiniciar(){
        turno=true;
        fondo=new JLabel[8][8];
        muertan=new JLabel[4][4];
        muertab=new JLabel[4][4];
        m_negra=0;
        m_blanca=0;
        fin=false;
        Tablero.removeAll();
        mnegras.removeAll();
        mblancas.removeAll();
        numeros = new javax.swing.JPanel();
        numeros.setPreferredSize(new java.awt.Dimension(20, 80));
        numeros.setLayout(new java.awt.GridLayout(9, 0));
        letras = new javax.swing.JPanel();
        letras.setLayout(new java.awt.GridLayout(1, 8));
        Dibujar();
        Tablero.updateUI();
        this.repaint();
        Turno();
    }
    
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

    private void Reiniciar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Reiniciar
        Reiniciar();
    }//GEN-LAST:event_Reiniciar

    private void rendirseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rendirseActionPerformed
     if(turno){
            Finish("Blancas");
        }else{
            Finish("Negras");
        }

    }//GEN-LAST:event_rendirseActionPerformed

    private void consolaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_consolaKeyPressed
        if(evt.getKeyChar()=='\n'){
            String a=consola.getText().trim();
            Comando(a);
            //System.out.println(a.charAt(0)+" "+(a.charAt(1)-48)+" "+a.charAt(2)+" "+(a.charAt(3)-48));            
        }
    }//GEN-LAST:event_consolaKeyPressed

    public void Comando(String a){
 
         if(a.length()>4){
                consola.setText("ERROR!!!");
                consola.selectAll();
            }else{
            if(turno){
                jugador1.Mover(a.charAt(0), (a.charAt(1)-48), a.charAt(2), 9-(a.charAt(3)-48));
            }else{
                jugador2.Mover(a.charAt(0), (a.charAt(1)-48), a.charAt(2), 9-(a.charAt(3)-48));
            }            
            }

     
         consola.setText("");
    }
    
     public void Turno(){
         if(turno){
            estado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/bpeon.png")));
            estado.setText(" Turno de: Blancas");
            estado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            }else{
            estado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/npeon.png")));
            estado.setText(" Turno de: Negras");
            estado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            }
    }

     public void Mover(){
            if((this.cpu)&&this.turno!=this.colorjugador1){
            System.out.println("TURNO DE CPU");
            tablero.GenerarArbol(turno, tablero.getTablero());
            turno=!turno;
        }
     }
private void Dibujar(){
        DibujarPiezas();
        DibujarTablero();
        DibujarMuertas();
        Tablero.updateUI();
        mnegras.updateUI();
        mblancas.updateUI();
        this.repaint();
        //tablero.Imprimir();
}
/**
 * Metodo que dibuja las Piezas del:
 * Jugador1: Negras
 * Jugador2: Blancas
 */
private void DibujarPiezas(){
    jugador1=new piezas_jugador(variable.BLANCA,this,variable.ABAJO);
    jugador2=new piezas_jugador(variable.NEGRA,this,variable.ARRIBA);
}

 private void DibujarMuertas(){

        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                muertan[j][i]=new JLabel("");
                muertan[j][i].setBackground(variable.COLOR);
                muertan[j][i].setOpaque(true);
                muertan[j][i].setBounds((j*variable.PIEZA_ALTO),(i*variable.PIEZA_ANCHO),variable.PIEZA_ANCHO,variable.PIEZA_ALTO);
                muertan[j][i].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                mnegras.add(muertan[j][i]);
                tablero.getTablero()[i+2][j]=0;
                tablero.getTablero()[i+2][j+4]=0;
                muertab[j][i]=new JLabel("");
                muertab[j][i].setOpaque(true);
                muertab[j][i].setBounds((j*variable.PIEZA_ALTO),(i*variable.PIEZA_ANCHO),variable.PIEZA_ANCHO,variable.PIEZA_ALTO);
                muertab[j][i].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                muertab[j][i].setBackground(new java.awt.Color(45, 23, 4));
                
                mblancas.add(muertab[j][i]);
                this.repaint();

            }
        }
    }

private void DibujarTablero(){

        boolean blanco=false;

        for(int j=8;j>0;j--){
            char a=(char)(73-j);
            JLabel n=new JLabel(a+"",SwingConstants.CENTER);
            n.setVerticalAlignment(SwingConstants.CENTER);
            n.setSize(variable.ANCHO, variable.ALTO/10);
            letras.add(n);
        }

        JLabel x=new JLabel("",SwingConstants.CENTER);
        numeros.add(x);

        for(int i=0;i<8;i++){

            for(int j=0;j<8;j++){
                fondo[j][i]=new JLabel("");
                fondo[j][i].setBounds((j*variable.ALTO),(i*variable.ANCHO),variable.ANCHO,variable.ALTO);
                fondo[j][i].setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
                if(blanco){
                fondo[j][i].setIcon(image_drive.getNegro());
                blanco=false;
                }else{
                fondo[j][i].setIcon(image_drive.getBlanco());
                blanco=true;
                }
                Tablero.add(fondo[j][i]);
                this.repaint();
            }
            if(blanco){
                blanco=false;
            }else{
                blanco=true;
            }
            JLabel n=new JLabel((8-(i))+"",SwingConstants.CENTER);
            n.setVerticalAlignment(SwingConstants.TOP);
            n.setSize(variable.ANCHO/10, variable.ALTO);
            numeros.add(n);
        }
    }

public void AgregarMuerto(boolean color, Icon pieza){

    if(color){
        if(m_blanca<4){
          muertab[m_blanca][0].setIcon(pieza);
        }else{
        if(m_blanca<8){
          muertab[m_blanca-4][1].setIcon(pieza);
        }else{
        if(m_blanca<12){
          muertab[m_blanca-8][2].setIcon(pieza);
        }else{
          muertab[m_blanca-12][3].setIcon(pieza);
        }
        }
        }
        m_blanca++;
    }else{
        if(m_negra<4){
                  muertan[m_negra][0].setIcon(pieza);
                }else{
                if(m_negra<8){
                  muertan[m_negra-4][1].setIcon(pieza);
                }else{
                if(m_negra<12){
                  muertan[m_negra-8][2].setIcon(pieza);
                }else{
                  muertan[m_negra-12][3].setIcon(pieza);
                }
                }
                }
                m_negra++;
    }
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Tablero;
    private javax.swing.JTextField consola;
    public javax.swing.JLabel estado;
    public javax.swing.JLabel estado1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JSplitPane jSplitPane2;
    private javax.swing.JSplitPane jSplitPane3;
    private javax.swing.JSplitPane jSplitPane4;
    private javax.swing.JPanel letras;
    public javax.swing.JPanel mblancas;
    public javax.swing.JPanel mnegras;
    private javax.swing.JSplitPane muertas;
    private javax.swing.JPanel numeros;
    private javax.swing.JMenuItem reiniciar;
    private javax.swing.JMenuItem rendirse;
    private javax.swing.JMenuItem salir;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JSplitPane split1;
    private javax.swing.JSplitPane tablero_principal;
    // End of variables declaration//GEN-END:variables

}

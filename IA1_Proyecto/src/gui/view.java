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

import gui.jugador.piezas;
import gui.resources.image_drive;
import gui.resources.variable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class view extends javax.swing.JFrame {

    private JLabel fondo[][]=new JLabel[8][8];
    private image_drive image_drive=new image_drive();
    public boolean turno;
    public piezas jugador1;
    public piezas jugador2;
    
    /** Creates new form view */
    public view() {
        initComponents();
        setBounds(new java.awt.Rectangle(300, 0, 685, 770));
        Dibujar();
          if(turno){
            estado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/bpeon.png")));
            estado.setText("Blancas");
            estado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            }else{
            estado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/npeon.png")));
            estado.setText("Negras");
            estado.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
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

        tablero_principal = new javax.swing.JSplitPane();
        numeros = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        estado = new javax.swing.JLabel();
        split1 = new javax.swing.JSplitPane();
        letras = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tablero = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        salir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ajedrez");
        setBounds(new java.awt.Rectangle(75, 100, 640, 640));
        setResizable(false);

        tablero_principal.setBorder(null);
        tablero_principal.setEnabled(false);
        tablero_principal.setMinimumSize(new java.awt.Dimension(110, 55));

        numeros.setMinimumSize(new java.awt.Dimension(20, 670));
        numeros.setPreferredSize(new java.awt.Dimension(20, 670));
        numeros.setLayout(new java.awt.GridLayout(9, 0));
        tablero_principal.setLeftComponent(numeros);

        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);
        jSplitPane1.setEnabled(false);

        estado.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        estado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/bpeon.png"))); // NOI18N
        estado.setText("Blancas");
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
        split1.setPreferredSize(new java.awt.Dimension(640, 650));

        letras.setMinimumSize(new java.awt.Dimension(640, 5));
        letras.setPreferredSize(new java.awt.Dimension(640, 5));
        letras.setLayout(new java.awt.GridLayout(1, 8));
        split1.setBottomComponent(letras);
        letras.getAccessibleContext().setAccessibleParent(split1);

        scroll.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        scroll.setMinimumSize(new java.awt.Dimension(642, 642));
        scroll.setPreferredSize(new java.awt.Dimension(642, 642));

        tablero.setMinimumSize(new java.awt.Dimension(640, 640));
        tablero.setPreferredSize(new java.awt.Dimension(640, 640));
        tablero.setLayout(null);
        scroll.setViewportView(tablero);

        split1.setTopComponent(scroll);

        jSplitPane1.setBottomComponent(split1);

        tablero_principal.setRightComponent(jSplitPane1);

        jMenu1.setText("Opciones");

        jMenuItem3.setText("Reiniciar");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

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
            .addComponent(tablero_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablero_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
            Reiniciar();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void Reiniciar(){
        tablero.removeAll();
        numeros = new javax.swing.JPanel();
        numeros.setPreferredSize(new java.awt.Dimension(20, 80));
        numeros.setLayout(new java.awt.GridLayout(9, 0));
        letras = new javax.swing.JPanel();
        letras.setLayout(new java.awt.GridLayout(1, 8));
        Dibujar();
        tablero.updateUI();
        this.repaint();
    }
    
    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_salirActionPerformed

 /**
 *
 */
private void Dibujar(){
        DibujarPiezas();
        this.turno=variable.BLANCA;
        DibujarTablero();
        tablero.updateUI();
        this.repaint();
}
/**
 * Metodo que dibuja las Piezas del:
 * Jugador1: Negras
 * Jugador2: Blancas
 */
private void DibujarPiezas(){
    jugador1=new piezas(variable.BLANCA,this,variable.ABAJO);
    jugador2=new piezas(variable.NEGRA,this,variable.ARRIBA);
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
                fondo[j][i].setIcon(image_drive.getBlanco());
                blanco=false;
                }else{
                fondo[j][i].setIcon(image_drive.getNegro());
                blanco=true;
                }
                tablero.add(fondo[j][i]);
                this.repaint();
            }
            if(blanco){
                blanco=false;
            }else{
                blanco=true;
            }
            JLabel n=new JLabel((i+1)+"",SwingConstants.CENTER);
            n.setVerticalAlignment(SwingConstants.TOP);
            n.setSize(variable.ANCHO/10, variable.ALTO);
            numeros.add(n);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel estado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel letras;
    private javax.swing.JPanel numeros;
    private javax.swing.JMenuItem salir;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JSplitPane split1;
    public javax.swing.JPanel tablero;
    private javax.swing.JSplitPane tablero_principal;
    // End of variables declaration//GEN-END:variables

}

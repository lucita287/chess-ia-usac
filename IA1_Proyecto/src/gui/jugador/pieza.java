/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.resources.variable;
import gui.view;
import java.awt.event.MouseEvent;
import java.util.TreeMap;
import javax.swing.Icon;
import javax.swing.JLabel;

public class pieza extends JLabel{


    /**
     * Clase principal que se encarga del manejor
     */
    private boolean color;
    private boolean viva;
    private int x;
    private int y;
    public int casillax;
    public int casillay;
    private int origenx;
    private int origeny;
    private Icon imagen;
    private String nombre;
    private int pieza;
    public view gui;
    private TreeMap movimientos= new TreeMap();
    private boolean inDrag = false;

    public pieza() {
    }

    /*DAVID -code*/
    //y:fila
    //x:columna
    public Integer matrix[][];
    public int mi_color;

    //supervisa si es un oponente
    public boolean es_oponente(int x,int y){
        if(mi_color>0 && matrix[x][y]<0)
            return true;
        if(mi_color<0 && matrix[x][y]>0)
            return true;
        return false;
    }

    //hace el calculo e indica si debe continuar o no
    public boolean calculo(int x_,int y_){
            if(matrix[x_][y_]==0)//espacio libre, puede avanzar
            {
                //posiciones.add(new posicion(x_, y_));
                this.AddMov(x_, y_);
            }
            else if(es_oponente(x_, y_))//es un oponente y debe salir
            {
                //ataques.add(new posicion(x_, y_));
                this.AddMov(x_, y_);
                return false;
            }
            else{//hay una barrera de un compañero
                return false;
            }
        return true;
    }
    /*DAVID -code*/

/**
 * 
 * @param color
 * @param estado
 * @param x
 * @param y
 * @param imagen
 * @param nombre
 * @param gui
 */
    public void setPieza(boolean color, int pieza, boolean estado, int x, int y, Icon imagen, view gui) {
        this.pieza=pieza;
        this.color = color;
        this.viva = estado;
        this.x = x;
        casillax=x/variable.ANCHO;
        casillay=y/variable.ALTO;
        origenx=x/variable.ANCHO;
        origeny=y/variable.ALTO;
        this.y = y;
        this.imagen = imagen;
        this.gui = gui;
        eventos();
        parametros();
        updateUI();
    }

/**
 *
 * @param color
 * @param viva
 * @param x
 * @param y
 * @param imagen
 * @param tablero
 */
    public pieza(boolean color, boolean estado, int x, int y, Icon imagen, view gui) {
        this.color = color;
        this.viva = estado;
        this.x = x;
        casillax=x/variable.ANCHO;
        casillay=y/variable.ALTO;
        origenx=x/variable.ANCHO;
        origeny=y/variable.ALTO;        
        this.y = y;
        this.imagen = imagen;
        this.gui = gui;
        eventos();
        parametros();
        updateUI();
    }

/**
 *
 */
    private void parametros(){
        setIcon(imagen);
        setText(nombre);
        setOpaque(!variable.FONDO);
        setBounds(x,y,variable.PIEZA_ANCHO, variable.PIEZA_ALTO);
        //setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        gui.Tablero.add(this);

    }

    public boolean isTurno() {
        return gui.turno;
    }

     /**
     * Eventos de la Pieza
     */
    private void eventos(){

         addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                Entered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                Exited(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                Pressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                Released(evt);
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                Dragged(evt);
            }
        });
    }

 /**
 *
 * @param evt
 */
private void Exited(java.awt.event.MouseEvent evt) {
       // this.setBackground(new java.awt.Color(240, 240, 240));
        this.setOpaque(!variable.FONDO);
}
/**
 *
 * @param evt
 */
    private void Entered(MouseEvent evt) {
        //setBackground(variable.COLOR);
        //this.setOpaque(variable.FONDO);
          this.repaint();
          gui.Tablero.repaint();
      }




public void PosiblesMovimientos(){

}
/**
 * Regresa la Pieza al Origen
 */
private void RegresarOrigen(){
    this.setLocation(origenx*variable.ANCHO+variable.DP_ANCHO, origeny*variable.ALTO+variable.DP_ALTO);
}

private void Actualizar(){
        this.repaint();
        gui.Tablero.repaint();
        gui.repaint();
}

/**
 * Actualiza la Variable de Turno
 * e Indica que se a cambiado de Turno
 */
private void Turno(){
          gui.turno=!gui.turno;
          gui.Turno();
}

/**
 * Mueve la Pieza a una posicion que sea Valida
 */
private void Mover(){
        if(IsMovimientoValido()){
            Turno();
            this.setOpaque(!variable.FONDO);
            System.out.println(((char)getLetra())+"-"+getNumero());
            this.setLocation(x*variable.ANCHO+variable.DP_ANCHO, y*variable.ALTO+variable.DP_ALTO);
            int temp=gui.tablero.getTablero()[origeny][origenx];
            gui.tablero.getTablero()[origeny][origenx]=0;
            gui.tablero.getTablero()[y][x]=temp;
            gui.tablero.Imprimir();
            origenx=x;
            origeny=y;
        }else{
            RegresarOrigen();
        }
}

/**
 * Mueve la Pieza a una posicion que sea Valida
 */
public void MoverXY(int letra, int numero){
        x=letra-65;
        y=numero-1;
        casillax=x;
        casillay=y;
        setBackground(variable.COLOR);
        this.setOpaque(true);
        PosiblesMovimientos();
        Mover();
        //this.setLocation(x*variable.ANCHO+variable.DP_ANCHO, y*variable.ALTO+variable.DP_ALTO);
        Actualizar();
}
/**
 *
 * @param evt
 */
    private void Released(MouseEvent evt) {
        inDrag = false;
        x=(evt.getX()+this.getX())/variable.ANCHO;
        y=(evt.getY()+this.getY())/variable.ALTO;
        casillax=this.getX()/variable.ANCHO;
        casillay=this.getY()/variable.ALTO;
        setBackground(variable.COLOR);
        this.setOpaque(true);
        PosiblesMovimientos();
        Mover();
        Actualizar();
      }
/**
 * Cuando se Extrae la Ficha
 * @param evt
 */
    private void Dragged(MouseEvent evt) {
        int s1=evt.getX()+this.getX();
        int s2=evt.getY()+this.getY();
          //this.setLocation(s1-40,s2-40);
          this.setLocation(s1,s2);
          setBackground(variable.COLOR);
          this.setOpaque(variable.FONDO);
          if (inDrag) {
          this.repaint();
          gui.Tablero.repaint();
          }

      }
        /**
     *
     * @param evt
     */
 private void Pressed(MouseEvent evt) {
        x=evt.getX();
        y=evt.getY();
        
        casillax=this.getX()/variable.ANCHO;
        casillay=this.getY()/variable.ALTO;
        origenx=this.getX()/variable.ANCHO;
        origeny=this.getY()/variable.ALTO;
         setBackground(variable.COLOR);
         this.setOpaque(variable.FONDO);
    }
/**
 * POSICION EN X DE LA PIEZA
 * A, B, C, D ,E , F, G, H
 * @return
 */
    public char getLetra() {
        return (char)(65+casillax);
    }

/**
 * POSICION EN Y DE LA PIEZA
 * 8, 7, 6 ,5, 4, 3, 2, 1
 * @return
 */
    public int getNumero() {
        return (8-casillay);
    }

    /**DEVULVE EL NUMERO DE CASILLA EN X
     * EN LA CUAL SE ENCUENTRA UBICADO
     *
     * @return
     */
    public int getCasillax() {
        return casillax;
    }

    /**DEVULVE EL NUMERO DE CASILLA EN Y
     * EN LA CUAL SE ENCUENTRA UBICADO
     *
     * @return
     */
    public int getCasillay() {
        return casillay;
    }
    public int getOrigenx() {
        return origenx;
    }

    public int getOrigeny() {
        return origeny;
    }
/**
 * 
 * @return
 */
    public void AddMov(int x, int y) {
        System.out.println("**>"+x+"-"+y);
        movimientos.put(x+","+y, new xypieza(x,y));
    }

    public void ClearMov() {
        movimientos.clear();
    }
 /**
 *
 * @param casillax
 */
    public void setCasillax(int casillax) {
        this.casillax = casillax;
        this.setLocation(x*variable.ANCHO,this.getY());
    }
/**
 *
 * @param casillay
 */
    public void setCasillay(int casillay) {
        this.casillay = casillay;
        this.setLocation(this.getX(), y*variable.ALTO);
    }
/**
 *
 * @param viva
 */
    public void setVivo(boolean estado) {
        this.setVisible(estado);
        this.setBounds(0, 0, 0, 0);
        x=-1;
        y=-1;
        this.repaint();
        this.viva = estado;
    }

    /**
     * Color de la Pieza
     * variable.NEGRA
     * variable.BLANCA
     * @return
     */
    public boolean isColor() {
        return color;
    }
/**
 * Estado de la Ficha:
 * variable.VIVA
 * variable.MUERTA
 * @return
 */
    public boolean isVivo() {
        return viva;
    }
/**
 *Nombre de la Pieza
 * @return
 */
    public String getNombre() {
        return nombre;
    }

    private boolean IsMovimientoValido() {

        if(movimientos.containsKey(y+","+x)){
            if(gui.turno){
                    gui.jugador2.IsPieza(this.pieza,x, y);
                    return true;
                }else{
                    gui.jugador1.IsPieza(this.pieza,x, y);
                    return true;
                }
        }else{
            return false;
        }


    }

}

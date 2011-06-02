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
    public boolean mov = false;

    //Guarda los peligros, o entes que lo acechan
    private TreeMap peligro = new TreeMap();
    
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

    /**
 * Agrega el Movimiento X,Y al Arbol de Casillas a donde se puede mover
 * @return
 */
    public void AddMov(int x, int y) {
            movimientos.put(x +","+ y, new xypieza(x, y));
    }

/**
 * Limpia los Movimientos Posibles Anteriores
 */
    public void ClearMov() {
        movimientos.clear();
    }

    /**
     * Agrega un peligro a la lista
     */
    public void Add_peligro(int x,int y){
        System.out.println("Ataca **"+x+","+y+"**");
        peligro.put(x+","+y,new xypieza(x,y));
    }

 /**
 * Limpia los Movimientos anteriores que ponen en Peligro al Rey
 */
    public void ClearPeligro() {
        peligro.clear();
    }
    public TreeMap getPeligro() {
        return peligro;
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

    public void setOrigenx(int origenx) {
        this.origenx = origenx;
    }

    public void setOrigeny(int origeny) {
        this.origeny = origeny;
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
                if(!mov)
                //if(!((gui.cpu)&&(gui.turno!=gui.colorjugador1)))
                Entered(evt);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                //if(!((gui.cpu)&&(gui.turno!=gui.colorjugador1)))
                Exited(evt);
            }
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                if(!mov)
                //if(!((gui.cpu)&&(gui.turno!=gui.colorjugador1)))
                Pressed(evt);
            }
            @Override
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                if(!mov)
                //if(!((gui.cpu)&&(gui.turno!=gui.colorjugador1)))
                Released(evt);
            }
        });

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            @Override
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                if(!gui.fin)
                if(gui.turno==color)
                if(!mov)
                Dragged(evt);
            }
        });
    }

 /**
 *Evento cuando el mouse se sale de la Pieza
 * @param evt
 */
private void Exited(java.awt.event.MouseEvent evt) {
       // this.setBackground(new java.awt.Color(240, 240, 240));
        this.setOpaque(!variable.FONDO);
        if(mov){
            mov=false;
        this.Turno();
        }

}
/**
 *Evento cuando el mouse se acerca a la pieza
 * @param evt
 */
    private void Entered(MouseEvent evt) {
        //setBackground(variable.COLOR);
        //this.setOpaque(variable.FONDO);
          this.repaint();
          gui.Tablero.repaint();
      }


/** Calcula que movimientos son posibles para la piezaa traves del tablero actual
 *
 * @param matriz
 */
public void PosiblesMovimientos(Integer[][] matriz){
      

     
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


/**Verifica que movimientos es posible para la pieza traves del tablero futuro, sin poner en peligro al rey
 *
 * @param tablero
 */
private boolean IsMovimientoNoPeligroso(Integer[][] m){
            int tx, ty;
            if(pieza==variable.BREY){
                tx=x;
                ty=y;
            }else{
                 if(this.isColor()){
                    tx=gui.jugador1.getRey().getOrigenx();
                    ty=gui.jugador1.getRey().getOrigeny();
                 }else{
                    tx=gui.jugador2.getRey().getOrigenx();
                    ty=gui.jugador2.getRey().getOrigeny();
                 }
            }
            Integer[][] t=GeneraTablero(m, mi_color*pieza, origeny, origenx, y, x);
            rey r=new rey(mi_color,tx,ty);
            r.analizar_peligro(t);
            if(r.getPeligro().size()==0)
                return true;
            else
                return false;
}

/**
 * Mueve la Pieza a una posicion que sea Valida
 */
private boolean Mover(){
               
       if(IsMovimientoValido()){
            this.setOpaque(!variable.FONDO);
            System.out.println(((char)getLetra())+"-"+getNumero());
            this.setLocation(x*variable.ANCHO+variable.DP_ANCHO, y*variable.ALTO+variable.DP_ALTO);
            gui.tablero.Mover(origeny, origenx, y, x);
            origenx=x;
            origeny=y;           
            Actualizar();
            if(!gui.turno){
            gui.estado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            gui.estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/bpeon.png")));
            gui.estado.setText(" Turno de: Blancas");
            gui.estado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            }else{
            gui.estado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            gui.estado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/image/npeon.png")));
            gui.estado.setText(" Turno de: Negras");
            gui.estado.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
            }
            return true;
            //Turno();
            //gui.tablero.Imprimir();
        }else{
            RegresarOrigen();
            Actualizar();
            return false;
        }
}

/**
 * Mueve la Pieza a una posicion que sea Valida a traves del teclado
 */
public void MoverXY(char letra, int numero){
        x=letra-65;
        y=numero-1;
        casillax=x;
        casillay=y;
        setBackground(variable.COLOR);
        this.setOpaque(true);
        PosiblesMovimientos(gui.tablero.getTablero());
        
        mov=Mover();
        //this.setLocation(x*variable.ANCHO+variable.DP_ANCHO, y*variable.ALTO+variable.DP_ALTO);
}

/**
 * Mueve la Pieza a una posicion que sea Valida a traves del teclado
 */
public void MoverXY(int x, int y){
        this.x=x;
        this.y=y;
        casillax=x;
        casillay=y;
        setBackground(variable.COLOR);
        this.setOpaque(true);
        PosiblesMovimientos(gui.tablero.getTablero());

        mov=Mover();
        if(mov){
            gui.turno=!gui.turno;
        }else{
            Turno();
        }
        //this.setLocation(x*variable.ANCHO+variable.DP_ANCHO, y*variable.ALTO+variable.DP_ALTO);
}
/**
 *Evento cuando se suelta la pieza
 * @param evt
 */
    private void Released(MouseEvent evt) {
        x=(evt.getX()+this.getX())/variable.ANCHO;
        y=(evt.getY()+this.getY())/variable.ALTO;
        casillax=this.getX()/variable.ANCHO;
        casillay=this.getY()/variable.ALTO;
        setBackground(variable.COLOR);
        this.setOpaque(true);
        PosiblesMovimientos(gui.tablero.getTablero());
        mov=Mover();
      }
/**
 * Cuando se Extrae la Pieza
 * @param evt
 */
    private void Dragged(MouseEvent evt) {
        int s1=evt.getX()+this.getX();
        int s2=evt.getY()+this.getY();
          this.setLocation(s1-variable.PIEZA_ANCHO/2,s2-variable.PIEZA_ALTO/2);//MOUSE CENTRO
          //this.setLocation(s1,s2); //MOUSE NORMAL
          setBackground(variable.COLOR);
          this.setOpaque(variable.FONDO);
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

        this.getParent().setComponentZOrder(this, 1);
        if(evt.getButton()==MouseEvent.BUTTON3){
            gui.tablero.Imprimir();
        }
        if(evt.getButton()==MouseEvent.BUTTON2){
            Turno();
        }
        /**
        if(this.isColor()){
        gui.tablero.test(0,this.pieza,origeny,origenx);
        }else{
        gui.tablero.test(0,(this.pieza*-1),origeny,origenx);
        }**/
         setBackground(variable.COLOR);
         this.setOpaque(variable.FONDO);
         this.updateUI();
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

    /**Verifica si es un Movimiento Valido
     *
     * @return
     */
    private boolean IsMovimientoValido() {
        if(IsMovimientoNoPeligroso(this.matrix)){
        if(movimientos.containsKey(y+","+x)){
                if(gui.turno){
                    gui.jugador2.IsPieza(x, y);
                }else{
                    gui.jugador1.IsPieza(x, y);
                }
                return true;
        }}
            return false;

    }

    /**Devuelve un Arbol de Movimientos posibles para la Pieza
     *
     * @param tablero
     * @return
     */
    public TreeMap getMovimientos(Integer[][] tablero) {
        this.PosiblesMovimientos(tablero);
        return movimientos;
    }
    
    public TreeMap getMovimientos() {
        return movimientos;
    }

    /**
     * Cuenta el # de Movimientos posibles que tiene la pieza
     *
     * @param tablero
     * @return
     */
    public int ContarMovimientos(Integer[][] tablero) {
        this.PosiblesMovimientos(tablero);
        return movimientos.size();
    }
/**
 * Genera un Tablero en base al tablero actual, a la pieza ox, oy que se desea mover a dx, dy.
 *
 * @param matriz
 * @param pieza
 * @param oy
 * @param ox
 * @param dy
 * @param dx
 * @return
 */
    public Integer[][] GeneraTablero(Integer[][] matriz, int pieza, int oy, int ox, int dy, int dx){
                    tablero nuevo=new tablero(matriz);
                    nuevo.Mover(oy,ox,dy, dx);
                    //nuevo.Imprimir();
                    return nuevo.getTablero();
    }
}

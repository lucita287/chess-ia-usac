/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.resources.image_drive;
import gui.resources.variable;
import gui.view;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author Daniel
 */
public class torre extends pieza{

    /*DAVID -code*/
    //y:fila
    //x:columna
    Integer matrix[][];
    int mi_color;


    //Guarda las posiciones posibles
    public Set<posicion> posiciones;
    public Set<posicion> ataques;//este es para los ataques

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
    public torre(boolean color, view gui, int x, int y) {
        image_drive image_drive=new image_drive();
        super.setPieza(color,'T',variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getTorre(color),gui);

        /*David*/
        if(color)
            mi_color=1;
        else
            mi_color=-1;
   }
 
    @Override
   public void PosiblesMovimientos() {
        this.ClearMov();

        matrix=gui.tablero.getTablero();

        int x_=this.getOrigeny();
        int y_=this.getOrigenx();

        //hacia arriba
        x_--;
        while(x_>=0){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            x_--;
        }

        //hacia abajo
        x_=this.getOrigeny();
        x_++;
        while(x_<=7){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            x_++;
        }
   }
}

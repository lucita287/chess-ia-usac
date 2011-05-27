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
    int matrix[][];
    int mi_color;

    public void recibe_matrix(int m[][]){//recibe la matriz del tablero
        matrix=m;
    }

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
                posiciones.add(new posicion(x_, y_));
            else if(es_oponente(x_, y_))//es un oponente y debe salir
            {
                ataques.add(new posicion(x_, y_));
                return false;
            }
            else{//hay una barrera de un compañero
                return false;
            }
        return true;
    }

    public void calculo_rutas(){
        posiciones = new HashSet<posicion>();
        ataques = new HashSet<posicion>();
        int x_=this.getOrigenx();
        int y_=this.getOrigeny();

        //Calculo Arriba
        y_--;
        while(y_>=0){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            y_--;
        }

        //Calculo Abajo
        y_=this.getOrigeny();
        y_++;
        while(y_<=7){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            y_++;
        }

        //Calculo Derecha
        y_=this.getOrigeny();
        x_++;
        while(x_<=7){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            x_++;
        }

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
        this.getMov().clear();
                
        for(int i=0;i<8;i++){
            if((i!=this.getOrigenx())){
            this.getMov().add(new xypieza(i,this.getOrigeny()));
            }
            if((i!=this.getOrigeny())){
            this.getMov().add(new xypieza(this.getOrigenx(),i));
            }
        }
   }
}

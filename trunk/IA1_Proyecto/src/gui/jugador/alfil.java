/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.resources.image_drive;
import gui.resources.variable;
import gui.view;


/**
 *
 * @author Daniel
 */
public class alfil extends pieza{

    public alfil(boolean color, view gui, int x, int y) {
        image_drive image_drive=new image_drive();
        super.setPieza(color,'A',variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getAlfil(color),gui);

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
        System.out.println(x_+"***"+y_);
        //Diagonal arriba izquierda
        x_--;y_--;
        while(x_>=0&&y_>=0){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            x_--;y_--;
        }
        //Diagonal abajo izquierda
        x_=this.getOrigeny();
        y_=this.getOrigenx();
        x_++;y_--;
        
        while(x_<=7&&y_>=0){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            x_++;y_--;
        }

        //Diagonal abajo derecha
        x_=this.getOrigeny();
        y_=this.getOrigenx();
        x_++;y_++;
        while(x_<=7&&y_<=7){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            x_++;y_++;
        }

        //Diagonal arriba derecha
        x_=this.getOrigeny();
        y_=this.getOrigenx();
        x_--;y_++;
        while(x_>=0&&y_<=7){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            x_--;y_++;
        }

   }
}

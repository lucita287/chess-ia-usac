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
public class torre extends pieza{

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

        //matrix=gui.tablero.getTablero();

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

        //hacia derecha
        y_=this.getOrigenx();
        x_=this.getOrigeny();
        y_++;
        while(y_<=7){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            y_++;
        }

        //hacia izquierda
        y_=this.getOrigenx();
        x_=this.getOrigeny();
        y_--;
        while(y_>=0){
            if(!calculo(x_,y_))//si no debe continuar paramos
                break;
            y_--;
        }

   }
}

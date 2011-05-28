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
public class rey extends pieza{

    public rey(boolean color, view gui, int x, int y) {
        image_drive image_drive=new image_drive();
        super.setPieza(color,'R',variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getRey(color),gui);

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

        //Hacia izquierda
        if((y_-1)>=0)
            calculo(x_,y_-1);
        
        //Hacia derecha
        if((y_+1)<=7)
            calculo(x_,y_+1);
        
        //Hacia arriba
        if((x_-1)>=0){
            calculo(x_-1,y_);

            if((y_-1)>=0)//diagonal izq
            calculo(x_-1,y_-1);
            
            if((y_+1)<=7)//diagonal der
            calculo(x_-1,y_+1);
        }

        //Hacia abajo
        if((x_+1)<=7){
            calculo(x_+1,y_);

            if((y_-1)>=0)//diagonal izq
            calculo(x_+1,y_-1);
            
            if((y_+1)<=7)//diagonal der
            calculo(x_+1,y_+1);
         
        }

   }
}

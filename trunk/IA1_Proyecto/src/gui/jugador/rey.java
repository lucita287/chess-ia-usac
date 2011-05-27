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

    }
 
    @Override
   public void PosiblesMovimientos() {

        /**
        this.getMov().clear();
            this.getMov().add(new xypieza(this.getOrigenx(),this.getOrigeny()+1));
            this.getMov().add(new xypieza(this.getOrigenx(),this.getOrigeny()-1));
            this.getMov().add(new xypieza(this.getOrigenx()+1,this.getOrigeny()));
            this.getMov().add(new xypieza(this.getOrigenx()+1,this.getOrigeny()+1));
            this.getMov().add(new xypieza(this.getOrigenx()+1,this.getOrigeny()-1));
            this.getMov().add(new xypieza(this.getOrigenx()-1,this.getOrigeny()));
            this.getMov().add(new xypieza(this.getOrigenx()-1,this.getOrigeny()+1));
            this.getMov().add(new xypieza(this.getOrigenx()-1,this.getOrigeny()-1));
         * **/
   }
}

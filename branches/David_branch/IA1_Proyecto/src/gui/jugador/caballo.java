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
public class caballo extends pieza{

    public caballo(boolean color, view gui, int x, int y) {
        image_drive image_drive=new image_drive();
        super.setPieza(color,variable.VIVA,x*variable.PIEZA_ANCHO,y*variable.PIEZA_ALTO,image_drive.getCaballo(color),gui);

    }
 
    @Override
   public void PosiblesMovimientos() {
        this.getMov().clear();
            this.getMov().add(new xypieza(this.getOrigenx()+2,this.getOrigeny()-1));
            this.getMov().add(new xypieza(this.getOrigenx()-2,this.getOrigeny()-1));
            this.getMov().add(new xypieza(this.getOrigenx()-1,this.getOrigeny()-2));
            this.getMov().add(new xypieza(this.getOrigenx()+1,this.getOrigeny()-2));
            this.getMov().add(new xypieza(this.getOrigenx()+2,this.getOrigeny()+1));
            this.getMov().add(new xypieza(this.getOrigenx()-2,this.getOrigeny()+1));
            this.getMov().add(new xypieza(this.getOrigenx()+1,this.getOrigeny()+2));
            this.getMov().add(new xypieza(this.getOrigenx()-1,this.getOrigeny()+2));

   }
}

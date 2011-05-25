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
        super.setPieza(color,variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getAlfil(color),gui);

    }
 
    @Override
   public void PosiblesMovimientos() {
        this.getMov().clear();
                
        this.getMov().clear();
        for(int i=1;i<8;i++){
            int a1=this.getOrigenx()+i;
            int a2=this.getOrigenx()-i;
            int b1=this.getOrigeny()+i;
            int b2=this.getOrigeny()-i;
            this.getMov().add(new xypieza(a1,b1));
            this.getMov().add(new xypieza(a1,b2));
            this.getMov().add(new xypieza(a2,b1));
            this.getMov().add(new xypieza(a2,b2));
        }
   }
}

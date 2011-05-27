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
public class peon extends pieza{

    public peon(boolean color, view gui, int x, int y) {
        image_drive image_drive=new image_drive();
        super.setPieza(color,'P',variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getPeon(color),gui);
    }
 
    @Override
   public void PosiblesMovimientos() {

        this.ClearMov();
                
        if(this.isColor()){
            if((this.getOrigeny()-1)>=0){
            this.AddMov(this.getOrigenx(),this.getOrigeny()-1);
            }
            if(((this.getOrigeny()-2)>=0)&&(this.getOrigeny()==6)){
            this.AddMov(this.getOrigenx(),this.getOrigeny()-2);
            }

        }else{
            if((this.getOrigeny()+1)<=8){
            this.AddMov(this.getOrigenx(),this.getOrigeny()+1);
            }
            if((this.getOrigeny()+2)<=8&&(this.getOrigeny()==1)){
            this.AddMov(this.getOrigenx(),this.getOrigeny()+2);
            }
        }

   }
}
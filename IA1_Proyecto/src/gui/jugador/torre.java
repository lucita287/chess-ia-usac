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

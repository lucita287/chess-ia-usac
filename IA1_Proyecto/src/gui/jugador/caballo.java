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
        super.setPieza(color,variable.BCABALLO,variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getCaballo(color),gui);

        if(color)
            mi_color=1;
        else
            mi_color=-1;
    }

    public caballo(int color, int x, int y) {
        mi_color=color;
        this.setOrigenx(x);
        this.setOrigeny(y);
    }
    @Override
     public void PosiblesMovimientos(Integer[][] tablero) {
        this.ClearMov();
        this.matrix=tablero;

        int x=this.getOrigeny();
        int y=this.getOrigenx();

        //Movimientos derecha
        if((x+1<=7)&&(y+2<=7))
            calculo(x+1,y+2);
        if((x+2<=7)&&(y+1<=7))
            calculo(x+2,y+1);
        if((x+1<=7)&&(y-2>=0))
            calculo(x+1,y-2);
        if((x+2<=7)&&(y-1>=0))
            calculo(x+2,y-1);

        //Ahora pivotea
        if((x-1>=0)&&(y+2<=7))
            calculo(x-1,y+2);
        if((x-2>=0)&&(y+1<=7))
            calculo(x-2,y+1);
        if((x-1>=0)&&(y-2>=0))
            calculo(x-1,y-2);
        if((x-2>=0)&&(y-1>=0))
            calculo(x-2,y-1);

   }
}

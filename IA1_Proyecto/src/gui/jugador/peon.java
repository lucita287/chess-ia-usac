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
        super.setPieza(color,variable.BPEON,variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getPeon(color),gui);
    
        if(color)
            mi_color=1;
        else
            mi_color=-1;
    }

   public peon(int color, int x, int y) {
        mi_color=color;
        this.setOrigenx(x);
        this.setOrigeny(y);
    }

   private void MovimientosBlancos(){
       int x=this.getOrigeny();
       int y=this.getOrigenx();
       
       if(x==6)//primer movimento posible puede ser de 2
       {
            if(matrix[x-2][y]==0)
                this.AddMov(x-2, y);
       }

       //Hacia adelante solo se puede si esta vacio
       if((x-1>=0)&&matrix[x-1][y]==0)
        this.AddMov(x-1, y);
       //En diagonal izquierda solo si hay un oponente
       if((x-1>=0)&&(y-1>=0)&&es_oponente(x-1,y-1))
        this.AddMov(x-1,y-1);
       //En diagonal derecha solo si hay un oponente
       if((x-1>=0)&&(y+1<=7)&&es_oponente(x-1,y+1))
        this.AddMov(x-1,y+1);
   }

   private void MovimientosNegros(){
       int x=this.getOrigeny();
       int y=this.getOrigenx();

       if(x==1)//primer movimento posible puede ser de 2
       {
            if(matrix[x+2][y]==0)
                this.AddMov(x+2, y);
       }

       //Hacia adelante solo se puede si esta vacio
       if((x+1<=7)&&matrix[x+1][y]==0)
        this.AddMov(x+1, y);
       //En diagonal izquierda solo si hay un oponente
       if((x+1<=7)&&(y-1>=0)&&es_oponente(x+1,y-1))
        this.AddMov(x+1,y-1);
       //En diagonal derecha solo si hay un oponente
       if((x+1<=7)&&(y+1<=7)&&es_oponente(x+1,y+1))
        this.AddMov(x+1,y+1);
   }


    @Override
   public void PosiblesMovimientos(Integer[][] tablero) {
        this.ClearMov();
        this.matrix=tablero;

        //Dependiendo de el color debe evaluarse
        switch(mi_color)   {
            case 1: this.MovimientosBlancos();break;
            case -1: this.MovimientosNegros();break;
        }
       }
}

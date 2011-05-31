/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.resources.image_drive;
import gui.resources.variable;
import gui.view;
import java.util.TreeMap;


/**
 *
 * @author Daniel
 */
public class rey extends pieza{

    public rey(boolean color, view gui, int x, int y) {
        image_drive image_drive=new image_drive();
        super.setPieza(color,variable.BREY,variable.VIVA,x*variable.ANCHO+variable.DP_ANCHO,y*variable.ALTO+variable.DP_ALTO,image_drive.getRey(color),gui);

                /*David*/
        if(color)
            mi_color=1;
        else
            mi_color=-1;
    }
 
    public rey(int color, int x, int y) {
        mi_color=color;
        this.setOrigenx(x);
        this.setOrigeny(y);
    }

    
    /*
     DAvid
     * 
     * AHora habra una funcion que me diga si el movimiento es valido
     * Calcula si desde la posicion que se encuentra sin moverse esta 
     * en peligro
     * 
     */
    
    
    //retorna si es aliado, porque asi puede parar el ritmo
    public boolean es_aliado(int x,int y){
       if(mi_color>0 && matrix[x][y]>0)
           return true;
       else if(mi_color<0 && matrix[x][y]<0)
           return true;
       return false;
    }
    
    //Analiza si una pieza es oponente, y que pieza es 
    public boolean es_oponente_pieza(int x,int y,int pieza){
        if(mi_color>0 && matrix[x][y]<0&&matrix[x][y]==(-pieza)) //blancos
            return true;
        if(mi_color<0 && matrix[x][y]>0&&matrix[x][y]==pieza) //negros
            return true;
        
        return false;
    }
    
    
    //Guarda los peligros, o entes que lo acechan
    private TreeMap peligro= new TreeMap();
    
    //hace una analisis si debe seguir en el ciclo actual, chequeando si hay oponentes
    //o un aliado, en los dos casos se detiene, se envian las dos variables que le afectan
    public boolean pseudo_analisis(int x, int y,int pieza1, int pieza2){
        if(es_oponente_pieza(x,y,pieza1)||es_oponente_pieza(x,y,pieza2))
        {
                add_peligro(x,y);
                return false;
        }
        else if(es_aliado(x,y))
                return false;
        return true;
    }
    
    //Agrega un peligro a la ista
    public void add_peligro(int x,int y){
        peligro.put(x+","+y,new xypieza(x,y));
    }
    
    public void analizar_peligro(){
        int x=this.getOrigeny();
        int y=this.getOrigenx();
        
        peligro.clear();//limpiamos para ver el contenido
        
        //PRIMERO SERA EL ANALISIS SI ES UN CABALLO QUIEN LO ACECHA
        if((x+1<=7)&&(y+2<=7)&&es_oponente_pieza(x+1,y+2,variable.BCABALLO))
            add_peligro(x+1,y+2);
       
        if((x+1<=7)&&(y-2>=0)&&es_oponente_pieza(x+1,y-2,variable.BCABALLO))
            add_peligro(x+1,y-2);
        
        if((x-1>=0)&&(y+2<=7)&&es_oponente_pieza(x-1,y+2,variable.BCABALLO))
            add_peligro(x-1,y+2);
        
        if((x-1>=0)&&(y-2>=0)&&es_oponente_pieza(x-1,y-2,variable.BCABALLO))
            add_peligro(x-1,y-2);
        
        if((x+2<=7)&&(y+1<=7)&&es_oponente_pieza(x+2,y+1,variable.BCABALLO))
            add_peligro(x+2,y+1);
        
        if((x+2<=7)&&(y-1>=0)&&es_oponente_pieza(x+2,y-1,variable.BCABALLO))
            add_peligro(x+2,y-1);
        
        if((x-2>=0)&&(y+1<=7)&&es_oponente_pieza(x-2,y+1,variable.BCABALLO))
            add_peligro(x-2,y+1);
        
        if((x-2>=0)&&(y-1>=0)&&es_oponente_pieza(x-2,y-1,variable.BCABALLO))
            add_peligro(x-2,y-1);

        
        //AHORA EL ANALISIS REINA TORRE
        //arriba
        x--;
        while(x>=0)
        {
            if(!this.pseudo_analisis(x,y,variable.BDAMA, variable.BTORRE))
                break;
            x--;   
        }
        
        //abajo 
        x=this.getOrigeny();
        x++;
        while(x<=7)
        {
            if(!this.pseudo_analisis(x, y, variable.BDAMA, variable.BTORRE))
                break;
            x++;   
        }
        
        //izquierda 
        x=this.getOrigeny();
        y--;
        while(y>=0)
        {
            if(!this.pseudo_analisis(x, y, variable.BDAMA, variable.BTORRE))
                break;
            y--;   
        }
        
        //derecha
        y=this.getOrigenx();
        y++;
        while(y<=7)
        {
            if(!this.pseudo_analisis(x, y, variable.BDAMA, variable.BTORRE))
                break;
            y++;   
        }
        
        //ahora vamos con los diagonales
        
        //Diagonal arriba izquierda
        x=this.getOrigeny();
        y=this.getOrigenx();
        x--;y--;
        while(x>=0&&y>=0){
            
            //Analisis Peon y Alfil en el primer paso
            if(mi_color==1&&(this.getOrigeny()-x)==1&&(this.getOrigenx()-y)==1)
            {
               if(this.es_oponente_pieza(x, y, variable.BPEON)){
                   this.add_peligro(x, y);
                   break;
               }
            }
            
            if(!this.pseudo_analisis(x, y, variable.BDAMA, variable.BALFIL))
                break;
            x--;y--;
        }
        
        //Diagonal abajo izquierda
        x=this.getOrigeny();
        y=this.getOrigenx();
        x++;y--;
        while(x<=7&&y>=0){
            
            //Analisis Peon y Alfil en el primer paso
            if(mi_color==-1&&(x-this.getOrigeny())==1&&(this.getOrigenx()-y)==1)
            {
               if(this.es_oponente_pieza(x, y, variable.BPEON)){
                   this.add_peligro(x, y);
                   break;
               }
            }
            
            if(!this.pseudo_analisis(x, y, variable.BDAMA, variable.BALFIL))
                break;
            x++;y--;
        }

        //Diagonal abajo derecha
        x=this.getOrigeny();
        y=this.getOrigenx();
        x++;y++;
        while(x<=7&&y<=7){
            //Analisis Peon y Alfil en el primer paso
            if(mi_color==-1&&(x-this.getOrigeny())==1&&(y-this.getOrigenx())==1)
            {
               if(this.es_oponente_pieza(x, y, variable.BPEON)){
                   this.add_peligro(x, y);
                   break;
               }
            }
            
            if(!this.pseudo_analisis(x, y, variable.BDAMA, variable.BALFIL))
                break;
            x++;y++;
        }

        //Diagonal arriba derecha
        x=this.getOrigeny();
        y=this.getOrigenx();
        x--;y++;
        while(x>=0&&y<=7){
            
            //Analisis Peon y Alfil en el primer paso
            if(mi_color==1&&(this.getOrigeny()-x)==1&&(y-this.getOrigenx())==1)
            {
               if(this.es_oponente_pieza(x, y, variable.BPEON)){
                   this.add_peligro(x, y);
                   break;
               }
            }
            
            if(!this.pseudo_analisis(x, y, variable.BDAMA, variable.BALFIL))
                break;
            x--;y++;
        }
        
    }
    
    @Override
     public void PosiblesMovimientos(Integer[][] tablero) {
        this.ClearMov();
        this.matrix=tablero;
        
        
        //Veamos el analisis primero 
        
        this.analizar_peligro();
        
        if(peligro.size()>0)
            System.out.println("Hay peligro!!!!!!!! tamanio: "+peligro.size());
        

        int x=this.getOrigeny();
        int y=this.getOrigenx();

        //Hacia izquierda
        if((y-1)>=0)
            calculo(x,y-1);
        
        //Hacia derecha
        if((y+1)<=7)
            calculo(x,y+1);
        
        //Hacia arriba
        if((x-1)>=0){
            calculo(x-1,y);

            if((y-1)>=0)//diagonal izq
            calculo(x-1,y-1);
            
            if((y+1)<=7)//diagonal der
            calculo(x-1,y+1);
        }

        //Hacia abajo
        if((x+1)<=7){
            calculo(x+1,y);

            if((y-1)>=0)//diagonal izq
            calculo(x+1,y-1);
            
            if((y+1)<=7)//diagonal der
            calculo(x+1,y+1);
         
        }

   }
}

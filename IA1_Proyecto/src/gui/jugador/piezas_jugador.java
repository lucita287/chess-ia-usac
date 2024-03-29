/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.resources.variable;
import gui.view;

/**
 *
 * @author Daniel
 */
public final class piezas_jugador {

    private peon peon[];
    private torre torre[];
    private alfil alfil[];
    private caballo caballo[];
    private reina reina;
    private rey rey;
    private final boolean color;
    private view gui;
    
    public piezas_jugador(boolean color,view gui, boolean posicion){
        int s1=0;
        int s2=1;
        int pos=0;
        int columna=0;
        int fila=0;
        Integer [][]tablero=gui.tablero.getTablero();
        this.color=color;
        this.gui=gui;
        if(!posicion){
            s1=7;
            s2=6;
        }
        peon=new peon[8];
        for(int i=0;i<peon.length;i++){
            peon[i]=new peon(color,gui,i,s2);
            columna=peon[i].getCasillax();
            fila=peon[i].getCasillay();
            if(this.isColor()){
                tablero[fila][columna]=variable.BPEON;
            }else{
                tablero[fila][columna]=variable.NPEON;
            }

        }

        torre=new torre[2];
        for(int i=0;i<torre.length;i++){
            torre[i]=new torre(color,gui,pos,s1);
            columna=torre[i].getCasillax();
            fila=torre[i].getCasillay();
            if(this.isColor()){
                tablero[fila][columna]=variable.BTORRE;
            }else{
                tablero[fila][columna]=variable.NTORRE;
            }
            pos+=7;
        }

        pos=1;
        caballo=new caballo[2];
        for(int i=0;i<caballo.length;i++){
            caballo[i]=new caballo(color,gui,pos,s1);
            columna=caballo[i].getCasillax();
            fila=caballo[i].getCasillay();
            if(this.isColor()){
                tablero[fila][columna]=variable.BCABALLO;
            }else{
                tablero[fila][columna]=variable.NCABALLO;
            }
            pos+=5;
        }

        pos=2;
        alfil=new alfil[2];
        for(int i=0;i<alfil.length;i++){
            alfil[i]=new alfil(color,gui,pos,s1);
            columna=alfil[i].getCasillax();
            fila=alfil[i].getCasillay();
            if(this.isColor()){
                tablero[fila][columna]=variable.BALFIL;
            }else{
                tablero[fila][columna]=variable.NALFIL;
            }
            pos+=3;
        }

        reina=new reina(color,gui,3,s1);
            columna=reina.getCasillax();
            fila=reina.getCasillay();
            if(this.isColor()){
                tablero[fila][columna]=variable.BDAMA;
            }else{
                tablero[fila][columna]=variable.NDAMA;
            }
        rey=new rey(color,gui,4,s1);
            columna=rey.getCasillax();
            fila=rey.getCasillay();
            if(this.isColor()){
                tablero[fila][columna]=variable.BREY;
            }else{
                tablero[fila][columna]=variable.NREY;
            }
        gui.tablero.setTablero(tablero);
    }

public void MoverXY(int pieza, int ox, int oy,int x, int y){
     switch(pieza){

            case variable.BPEON:
            for(int i=0;i<8;i++){
                if((this.getPeon()[i].getOrigenx()==ox)&&((this.getPeon()[i].getOrigeny()==oy))){
                    this.getPeon()[i].MoverXY(x, y);
                    return;
                }
            }
            break;

            case variable.BTORRE:
            for(int i=0;i<2;i++){
                if((this.getTorre()[i].getOrigenx()==ox)&&((this.getTorre()[i].getOrigeny()==oy))){
                    this.getTorre()[i].MoverXY(x, y);
                    return;
                }
            }
            break;

            case variable.BALFIL:
            for(int i=0;i<2;i++){
                if((this.getAlfil()[i].getOrigenx()==ox)&&((this.getAlfil()[i].getOrigeny()==oy))){
                    this.getAlfil()[i].MoverXY(x, y);
                    return;
                }
            }
            break;

            case variable.BCABALLO:
            for(int i=0;i<2;i++){
                if((this.getCaballo()[i].getOrigenx()==ox)&&((this.getCaballo()[i].getOrigeny()==oy))){
                    this.getCaballo()[i].MoverXY(x, y);
                    return;
                }
            }
            break;

            case variable.BDAMA:
                this.getReina().MoverXY(x, y);
                break;
            case variable.BREY:
                this.getRey().MoverXY(x, y);
                break;
            default:
                return;

        }
}
    /**
     *  LETRA DE PIEZAS
     *  Rey = R
        Dama = D
        Torre = T1 y T2
        Caballo = C1 y C2
        Alfil = A1 y A2
        Peón = P1, P2...P8
     * X = LETRAS  (A, B...,H)
     * Y = NUMEROS (1, 2...,8)
     *
     * @param pieza 
     * @param npieza 
     * @param letra
     * @param numero
     */
    public void Mover(int pieza, int npieza, int letra, int numero){
        //System.out.println(letra+" "+numero);
        switch(pieza){

            case 'R': //REY
                getRey().MoverXY(letra, numero);
                break;
            case 'D': //DAMA
                getReina().MoverXY(letra, numero);
                break;
            case 'T': //TORRE
                getTorre()[npieza-1].MoverXY(letra, numero);
                break;
            case 'C': //CABALLO
                getCaballo()[npieza-1].MoverXY(letra, numero);
                break;
            case 'A': //ALFIL
                getAlfil()[npieza-1].MoverXY(letra, numero);
                break;
            case 'P': //PEON
                getPeon()[npieza-1].MoverXY(letra, numero);
                break;
        }
    }
    
    public alfil[] getAlfil() {
        return alfil;
    }

    public caballo[] getCaballo() {
        return caballo;
    }

    public boolean isColor() {
        return color;
    }

    public peon[] getPeon() {
        return peon;
    }

    public reina getReina() {
        return reina;
    }

    public rey getRey() {
        return rey;
    }

    public torre[] getTorre() {
        return torre;
    }

/**
     *  LETRA DE PIEZAS
     *  Rey = R
        Dama = D
        Torre = T1 y T2
        Caballo = C1 y C2
        Alfil = A1 y A2
        Peón = P1, P2...P8
 *
 * @param pieza
 * @param x
 * @param y
 */
public void IsPieza(int x, int y){
    //System.out.print("\n"+x+"-"+y);
   /** if(pieza=='P'){

          return;
        }else{
    * **/
    for(int i=0;i<8;i++){
        if(((peon[i].casillax==x))&&(peon[i].casillay==y)){
            if(peon[i].isVivo()){
            gui.AgregarMuerto(peon[i].isColor(), peon[i].getIcon());
            peon[i].setVivo(variable.MUERTA);
            
            //gui.tablero.getTablero()[peon[i].getCasillax()][peon[i].getCasillay()]=0;
            }
            //System.out.println("Muere Peon "+i+" "+this.ColorFicha());
            
            break;
        }
    }
    for(int i=0;i<2;i++){
        if((torre[i].casillax==x)&&(torre[i].casillay==y)){
            if(torre[i].isVivo()){
            gui.AgregarMuerto(torre[i].isColor(), torre[i].getIcon());
            torre[i].setVivo(variable.MUERTA);

            //gui.tablero.getTablero()[torre[i].getCasillax()][torre[i].getCasillay()]=0;
            }
            //System.out.println("Muere Torre "+i+" "+this.ColorFicha());
            break;
        }
        if((caballo[i].casillax==x)&&(caballo[i].casillay==y)){
            if(caballo[i].isVivo()){
            gui.AgregarMuerto(caballo[i].isColor(), caballo[i].getIcon());
            caballo[i].setVivo(variable.MUERTA);

            //gui.tablero.getTablero()[caballo[i].getCasillax()][caballo[i].getCasillay()]=0;
            }
            //System.out.println("Muere Caballo "+i+" "+this.ColorFicha());

            break;
        }
        if((alfil[i].casillax==x)&&(alfil[i].casillay==y)){
            if(alfil[i].isVivo()){
            gui.AgregarMuerto(alfil[i].isColor(), alfil[i].getIcon());
            alfil[i].setVivo(variable.MUERTA);

            //gui.tablero.getTablero()[alfil[i].getCasillax()][alfil[i].getCasillay()]=0;
            }
            //System.out.println("Muere Alfil "+i+" "+this.ColorFicha());
            break;
        }
    }
        if((reina.casillax==x)&&(reina.casillay==y)){
            if(reina.isVivo()){
            gui.AgregarMuerto(reina.isColor(), reina.getIcon());
            reina.setVivo(variable.MUERTA);

            //gui.tablero.getTablero()[reina.getCasillax()][reina.getCasillay()]=0;
            }
            //System.out.println("Muere Reina "+this.ColorFicha());


        }
        if((rey.casillax==x)&&(rey.casillay==y)){
            if(rey.isVivo()){
            rey.setVivo(variable.MUERTA);
            gui.AgregarMuerto(rey.isColor(), rey.getIcon());

            //gui.tablero.getTablero()[rey.getCasillax()][rey.getCasillay()]=0;
            }
            //System.out.println("Muere Rey "+this.ColorFicha());
            gui.Finish(this.ColorFicha());            
        }

        
}

public void Clear(){

}
 public String ColorFicha(){
    if(this.color){
    return "Blancas";
    }else{
    return "Negras";
    }
}

}

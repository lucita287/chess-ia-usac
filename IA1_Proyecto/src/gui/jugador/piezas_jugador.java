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
public class piezas_jugador {

    private peon peon[];
    private torre torre[];
    private alfil alfil[];
    private caballo caballo[];
    private reina reina;
    private rey rey;
    private boolean color;
    private view gui;
    private npiezas_jugador vivos;
    
    public piezas_jugador(boolean color,view gui, boolean posicion){
        int s1=0;
        int s2=1;
        int pos=0;
        this.color=color;
        this.gui=gui;
        if(!posicion){
            s1=7;
            s2=6;
        }
        peon=new peon[8];
        for(int i=0;i<peon.length;i++){
            peon[i]=new peon(color,gui,i,s2);
        }

        torre=new torre[2];
        for(int i=0;i<torre.length;i++){
            torre[i]=new torre(color,gui,pos,s1);
            pos+=7;
        }

        pos=1;
        caballo=new caballo[2];
        for(int i=0;i<caballo.length;i++){
            caballo[i]=new caballo(color,gui,pos,s1);
            pos+=5;
        }

        pos=2;
        alfil=new alfil[2];
        for(int i=0;i<alfil.length;i++){
            alfil[i]=new alfil(color,gui,pos,s1);
            pos+=3;
        }

        reina=new reina(color,gui,3,s1);
        rey=new rey(color,gui,4,s1);
        vivos=new npiezas_jugador();
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
public void IsPieza(int pieza,int x, int y){
    //System.out.print("\n"+x+"-"+y);
    if(pieza=='P'){
          return;
        }else{
    for(int i=0;i<8;i++){
        if(((peon[i].casillax==x))&&(peon[i].casillay==y)){
            if(peon[i].isVivo()){
            gui.AgregarMuerto(peon[i].isColor(), peon[i].getIcon());
            peon[i].setVivo(variable.MUERTA);
            vivos.removePeon();
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
            vivos.removeTorre();
            }
            //System.out.println("Muere Torre "+i+" "+this.ColorFicha());
            break;
        }
        if((caballo[i].casillax==x)&&(caballo[i].casillay==y)){
            if(caballo[i].isVivo()){
            gui.AgregarMuerto(caballo[i].isColor(), caballo[i].getIcon());
            caballo[i].setVivo(variable.MUERTA);
            vivos.removeCaballo();
            }
            //System.out.println("Muere Caballo "+i+" "+this.ColorFicha());

            break;
        }
        if((alfil[i].casillax==x)&&(alfil[i].casillay==y)){
            if(alfil[i].isVivo()){
            gui.AgregarMuerto(alfil[i].isColor(), alfil[i].getIcon());
            alfil[i].setVivo(variable.MUERTA);
            vivos.removeAlfil();
            }
            //System.out.println("Muere Alfil "+i+" "+this.ColorFicha());
            break;
        }
    }
        if((reina.casillax==x)&&(reina.casillay==y)){
            if(reina.isVivo()){
            gui.AgregarMuerto(reina.isColor(), reina.getIcon());
            reina.setVivo(variable.MUERTA);
            vivos.removeReina();
            }
            //System.out.println("Muere Reina "+this.ColorFicha());


        }
        if((rey.casillax==x)&&(rey.casillay==y)){
            if(rey.isVivo()){
            rey.setVivo(variable.MUERTA);
            gui.AgregarMuerto(rey.isColor(), rey.getIcon());
            vivos.removeRey();
            }
            //System.out.println("Muere Rey "+this.ColorFicha());
            gui.Finish(this.ColorFicha());
            
        }

        }
}

public String ColorFicha(){
    if(this.color){
    return "Blancas";
    }else{
    return "Negras";
    }
}

}

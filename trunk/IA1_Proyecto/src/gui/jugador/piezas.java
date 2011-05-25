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
public class piezas {

    private peon peon[];
    private torre torre[];
    private alfil alfil[];
    private caballo caballo[];
    private reina reina;
    private rey rey;
    private boolean color;
    private view gui;
    
    public piezas(boolean color,view gui, boolean posicion){
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

public void IsPieza(int x, int y){
    System.out.print("\n"+x+"-"+y);
    for(int i=0;i<8;i++){
        if((peon[i].casillax==x)&&(peon[i].casillay==y)){
            peon[i].setEstado(variable.MUERTA);
            //System.out.println("Muere Peon "+i+" "+this.ColorFicha());
            gui.AgregarMuerto(peon[i].isColor(), peon[i].getIcon());
            break;
        }
    }
    for(int i=0;i<2;i++){
        if((torre[i].casillax==x)&&(torre[i].casillay==y)){
            torre[i].setEstado(variable.MUERTA);
            //System.out.println("Muere Torre "+i+" "+this.ColorFicha());
            gui.AgregarMuerto(torre[i].isColor(), torre[i].getIcon());
            break;
        }
        if((caballo[i].casillax==x)&&(caballo[i].casillay==y)){
            caballo[i].setEstado(variable.MUERTA);
            //System.out.println("Muere Caballo "+i+" "+this.ColorFicha());
            gui.AgregarMuerto(caballo[i].isColor(), caballo[i].getIcon());
            break;
        }
        if((alfil[i].casillax==x)&&(alfil[i].casillay==y)){
            alfil[i].setEstado(variable.MUERTA);
            //System.out.println("Muere Alfil "+i+" "+this.ColorFicha());
            gui.AgregarMuerto(alfil[i].isColor(), alfil[i].getIcon());
            break;
        }
    }
        if((reina.casillax==x)&&(reina.casillay==y)){
            reina.setEstado(variable.MUERTA);
            //System.out.println("Muere Reina "+this.ColorFicha());
            gui.AgregarMuerto(reina.isColor(), reina.getIcon());

        }
        if((rey.casillax==x)&&(rey.casillay==y)){
            rey.setEstado(variable.MUERTA);
            System.out.println("Muere Rey "+this.ColorFicha());
            gui.Finish(this.ColorFicha());
            gui.AgregarMuerto(rey.isColor(), rey.getIcon());
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

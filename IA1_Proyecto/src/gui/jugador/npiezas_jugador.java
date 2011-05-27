/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.resources.variable;

/**
 *
 * @author Daniel
 */
public class npiezas_jugador {

    private int peon, alfil, caballo, torre, reina, rey;
    private int color;
    
    public npiezas_jugador() {
    }
  
    public npiezas_jugador(boolean jugador) {
        peon=8;
        alfil=2;
        caballo=2;
        torre=2;
        reina=1;
        rey=1;
        if(jugador){
            color=1;
        }else{
            color=-1;
        }
    }

    public int getColor() {
        return color;
    }

    public int getAlfil() {
        return alfil;
    }

    public int getCaballo() {
        return caballo;
    }

    public int getPeon() {
        return peon;
    }

    public int getReina() {
        return reina;
    }

    public int getRey() {
        return rey;
    }

    public int getTorre() {
        return torre;
    }

    public void removeAlfil() {
        if(alfil!=0){
        this.alfil = alfil-1;
        }
    }

    public void removeCaballo() {
         if(caballo!=0){
        this.caballo = caballo-1;
        }
    }

   public void removePeon() {
        if(peon!=0){
        this.peon = peon-1;
        }
    }

    public void removeTorre() {
        if(torre!=0){
        this.torre = torre-1;
        }
    }

    public void removeReina() {
        if(reina!=0){
        this.reina = reina-1;
        }
    }

    public void removeRey() {
        if(rey!=0){
        this.rey = rey-1;
        }
    }

    public void Ver(){
        System.out.println("PEON(ES): "+peon+" = "+(color*variable.PESO_PEON*peon));
        System.out.println("TORRE(S): "+torre+" = "+(color*variable.PESO_TORRE*torre));
        System.out.println("ALFIL(ES): "+alfil+" = "+(color*variable.PESO_ALFIL*alfil));
        System.out.println("CABALLO(S): "+caballo+" = "+(color*variable.PESO_CABALLO*caballo));
        System.out.println("REINA: "+reina+" = "+(color*variable.PESO_REINA*reina));
        System.out.println("REY: "+rey+" = "+(color*variable.PESO_REY*rey));
    }
}

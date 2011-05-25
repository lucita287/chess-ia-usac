/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

/**
 *
 * @author Daniel
 */
public class npiezas_jugador {

    private int peon, alfil, caballo, torre, reina, rey;

    public npiezas_jugador() {
        peon=8;
        alfil=2;
        caballo=2;
        torre=2;
        reina=1;
        rey=1;
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
}

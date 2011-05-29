/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.edd;

import gui.jugador.alfil;
import gui.jugador.torre;
import gui.resources.variable;

/**
 *
 * @author Daniel
 */
public final class Utilidad {

    private final int PPEON=100, PCABALLO=315, PALFIL=330, PTORRE=500, PDAMA=940, PREY=1;
    private int utilidad;
    private int peones_negros=0, peones_blancos=0;
    private int caballos_negros=0, caballos_blancos=0;
    private int alfiles_negros=0, alfiles_blancos=0;
    private int torres_negros=0, torres_blancos=0;
    private int dama_negros=0, dama_blancos=0;
    private int rey_negros=0, rey_blancos=0;
    private int bpeon_avanzo=0, npeon_avanzo=0;
    private int bpeon_centro=0, npeon_centro=0;
    private int bcaballo_centro=0, ncaballo_centro=0;
    private int bdama_centro=0, ndama_centro=0;
    private int nalfiles_mov=0, balfiles_mov=0;
    private int ntorres_mov=0, btorres_mov=0;

    public Utilidad(Integer[][] tablero) {
        for(int i=0;i<tablero.length;i++){
        for(int j=0;j<tablero[i].length;j++){
            int t=tablero[i][j];
            switch(t){
                /**
                 * PEÓN
                    Por cada peón propio, sumar 100 puntos.
                    Si el peón está en el centro del tablero, añadir 12 puntos más
                    Añadir 2 puntos por cada casilla que haya avanzado el peón desde su punto de partida
                 */
            case variable.NPEON:
                if(i!=1){
                    this.npeon_avanzo+=(i-1)*2;
                }
                if(((i==3)||(i==4))&&((j==3)||(j==4))){
                    this.npeon_centro+=12;
                }
                this.peones_negros++;
                break;

            case variable.BPEON:
                if(i!=1){
                    this.bpeon_avanzo+=(6-i)*2;
                }
                if(((i==3)||(i==4))&&((j==3)||(j==4))){
                    this.bpeon_centro+=12;
                }
                this.peones_blancos++;
                break;
            /**
             * TORRE
            Cada torre suma 500 puntos
            Añadir un punto más por cada casilla a la que pueda moverse libremente (es decir, sin que se lo impida otra pieza que esté en medio)
             */
            case variable.NTORRE:
                this.torres_negros++;
                torre t1=new torre(-1,j,i);
                this.ntorres_mov+=t1.ContarMovimientos(tablero);

                break;

            case variable.BTORRE:
                this.torres_blancos++;
                torre t2=new torre(1,j,i);
                this.btorres_mov+=t2.ContarMovimientos(tablero);

                break;
            /**
             * ALFIL
            Cada alfil suma 330 puntos
            Añadir un punto más por cada casilla a la que pueda moverse libremente (es decir, sin que se lo impida otra pieza que esté en medio)
             */
            case variable.NALFIL:
                this.alfiles_negros++;
                alfil a1=new alfil(-1,j,i);
                this.nalfiles_mov+=a1.ContarMovimientos(tablero);

                break;

            case variable.BALFIL:
                this.alfiles_blancos++;
                alfil a2=new alfil(1,j,i);
                this.balfiles_mov+=a2.ContarMovimientos(tablero);

                break;
            /**
             * CABALLO
            Cada caballo propio suma 315 puntos
            Añadir entre 0 y 15 puntos si está cerca del centro del tablero (más cuanto más cerca del centro)
            Quitar entre 0 y 15 puntos si está lejos del centro (quitar más cuanto más lejos)
             */         
            case variable.NCABALLO:
               if(((i==3)||(i==4))&&((j==3)||(j==4))){
                    this.ncaballo_centro+=15;
                }else{
                    if((i==0)||(i==7)||(j==0)||(j==7)){
                    this.ncaballo_centro-=15;
                }
                }
                this.caballos_negros++;
                break;

            case variable.BCABALLO:
                if(((i==3)||(i==4))&&((j==3)||(j==4))){
                    this.bcaballo_centro+=15;
                }else{
                    if((i==0)||(i==7)||(j==0)||(j==7)){
                    this.bcaballo_centro-=15;
                }
                }
                
                this.caballos_blancos++;
                break;

            /**
             * DAMA
            La dama representa 940 puntos
            Como en el caballo, añadir o quitar puntos (de 0 a 10) dependiendo de lo cerca o lejos que esté del centro del tablero
             */
            case variable.NDAMA:
                if(((i==3)||(i==4))&&((j==3)||(j==4))){
                    this.ndama_centro+=10;
                }else{
                if((i==0)||(i==7)||(j==0)||(j==7)){
                    this.ndama_centro-=10;
                }}

                this.dama_negros++;
                break;

            case variable.BDAMA:
               if(((i==3)||(i==4))&&((j==3)||(j==4))){
                    this.bdama_centro+=10;
                }else{
                if((i==0)||(i==7)||(j==0)||(j==7)){
                    this.bdama_centro-=10;
                }}
                
                this.dama_blancos++;
                break;

            case variable.NREY:
                this.rey_negros++;
                break;

            case variable.BREY:
                this.rey_blancos++;
                break;

            default:
               break;
        }
        }
        }
        this.utilidad=this.UtilidadBlancas()*this.getRey_blancos()-this.UtilidadNegras()*this.getRey_negros();
        //this.Ver();
    }

    private int UtilidadNegras(){
        int pts_pieza=this.getPeones_negros()+this.getAlfiles_negros()+this.getCaballos_negros()+this.getDama_negros()+this.getTorres_negros();
        pts_pieza+=this.getNpeon_avanzo()+this.getNpeon_centro(); //PEON
        pts_pieza+=this.getNcaballo_centro(); //CABALLO
        pts_pieza+=this.getNdama_centro(); //DAMA
        pts_pieza+=this.getNalfiles_mov(); //ALFIL
        pts_pieza+=this.getNtorres_mov(); //TORRE

        return pts_pieza;
    }

    private int UtilidadBlancas(){
        int pts_pieza=this.getPeones_blancos()+this.getAlfiles_blancos()+this.getCaballos_blancos()+this.getDama_blancos()+this.getTorres_blancos();
        pts_pieza+=this.getBpeon_avanzo()+this.getBpeon_centro();//PEON
        pts_pieza+=this.getBcaballo_centro(); //CABALLO
        pts_pieza+=this.getBdama_centro(); //DAMA
        pts_pieza+=this.getBalfiles_mov(); //ALFIL
        pts_pieza+=this.getBtorres_mov(); //TORRE
        return pts_pieza;
    }

    public int getUtilidad() {
        return utilidad;
    }

    private int getBpeon_avanzo() {
        return bpeon_avanzo;
    }

    private int getNpeon_avanzo() {
        return npeon_avanzo;
    }

    
    private int getAlfiles_blancos() {
        return alfiles_blancos*this.PALFIL;
    }

    private int getAlfiles_negros() {
        return alfiles_negros*this.PALFIL;
    }

    private int getCaballos_blancos() {
        return caballos_blancos*this.PCABALLO;
    }

    private int getCaballos_negros() {
        return caballos_negros*this.PCABALLO;
    }

    private int getDama_blancos() {
        return dama_blancos*this.PDAMA;
    }

    private int getDama_negros() {
        return dama_negros*this.PDAMA;
    }

    private int getPeones_blancos() {
        return peones_blancos*this.PPEON;
    }

    private int getPeones_negros() {
        return peones_negros*this.PPEON;
    }

    private int getRey_blancos() {
        return rey_blancos*this.PREY;
    }

    private int getRey_negros() {
        return rey_negros*this.PREY;
    }

    private int getTorres_blancos() {
        return torres_blancos*this.PTORRE;
    }

    private int getTorres_negros() {
        return torres_negros*this.PTORRE;
    }

    private int getBpeon_centro() {
        return bpeon_centro;
    }

    private int getNpeon_centro() {
        return npeon_centro;
    }

    private int getBcaballo_centro() {
        return bcaballo_centro;
    }

    private int getBdama_centro() {
        return bdama_centro;
    }

    private int getNcaballo_centro() {
        return ncaballo_centro;
    }

    private int getNdama_centro() {
        return ndama_centro;
    }

    private int getBalfiles_mov() {
        return balfiles_mov;
    }

    private int getBtorres_mov() {
        return btorres_mov;
    }

    private int getNalfiles_mov() {
        return nalfiles_mov;
    }

    private int getNtorres_mov() {
        return ntorres_mov;
    }

   
    public void Ver(){
        System.out.println("**UTILIDAD NEGRAS: "+this.UtilidadNegras());
        //System.out.println("PEON CENTRO+AVANZO: "+(this.getNpeon_avanzo()+this.getNpeon_centro()));
        //System.out.println("CABALLO CENTRO: "+this.getNcaballo_centro());
        //System.out.println("ALFIL MOV: "+this.getNalfiles_mov());
        //System.out.println("TORRE MOV: "+this.getNtorres_mov());
        //System.out.println("DAMA CENTRO: "+this.getNdama_centro());
        System.out.println("**UTILIDAD BLANCAS: "+this.UtilidadBlancas());
        //System.out.println("PEON CENTRO+AVANZO: "+(this.getBpeon_avanzo()+this.getBpeon_centro()));
        //System.out.println("CABALLO CENTRO: "+this.getBcaballo_centro());
        //System.out.println("ALFIL MOV: "+this.getBalfiles_mov());
        //System.out.println("TORRE MOV: "+this.getBtorres_mov());
        //System.out.println("DAMA CENTRO: "+this.getBdama_centro());
        System.out.println("UTILIDAD: "+this.getUtilidad());
    }



}

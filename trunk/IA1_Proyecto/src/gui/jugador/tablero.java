/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.resources.variable;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class tablero {

    private Integer matriz[][];
    private int nturno;

    public tablero() {
        matriz=new Integer[8][8];
        nturno=0;
    }

    public void setTablero(Integer[][] tablero) {
        this.matriz = tablero;
    }

    
    public int getNturno() {
        return nturno;
    }

    public Integer[][] getTablero() {
        return matriz;
    }

    public void setNTurno(){
        nturno++;
    }

    public void Imprimir(){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.print("\n");
        }
        ArrayList<xypieza> piezas1=this.PiezasJugadores(variable.BLANCA);
        Print(piezas1);
        ArrayList<xypieza> piezas2=this.PiezasJugadores(variable.NEGRA);
        Print(piezas2);
    }

    private void Print(ArrayList<xypieza> piezas){
        for(int i=0;i<piezas.size();i++){
            System.out.println(piezas.get(i).getPieza());
        }
    }
    public Integer[][] GenerarTablero(int pieza){
        return null;
    }

    public ArrayList<xypieza> PiezasJugadores(boolean color){
        ArrayList<xypieza> piezas=new ArrayList();
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                int temp=matriz[i][j];
                if((temp>0)&&color){
                    piezas.add(new xypieza(temp, i, j));
                }else{
                    if((temp<0)&&!color){
                    piezas.add(new xypieza(temp, i, j));
                    }
                }
            }
        }
        return piezas;
    }

}

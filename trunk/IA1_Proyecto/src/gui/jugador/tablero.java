/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.edd.Nodo;
import gui.resources.variable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Daniel
 */
public class tablero {

    private Integer matriz[][];
    private int nturno;

    public tablero(Integer [][] m) {
        matriz=new Integer[8][8];
        for(int i=0;i<m.length;i++){
            System.arraycopy(m[i], 0, matriz[i], 0, m.length);
        }
        nturno=0;
    }

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

    public void Mover(int oy, int ox, int dy, int dx){
            int temp=getTablero()[oy][ox];
            getTablero()[oy][ox]=0;
            getTablero()[dy][dx]=temp;
    }

    public void Imprimir(){
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.print(matriz[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    public void test(int pieza, int y, int x){
            TreeMap a=this.GenerarMovimientos(pieza, y, x);
            if(a!=null){
                System.out.println("****PIEZA PEON****");
                for (Iterator iterator=a.values().iterator();iterator.hasNext();) {
                    xypieza t=(xypieza)iterator.next();
                    System.out.println(y+" "+x+"***"+t.getX()+" "+t.getY());
                    System.out.println("************OPCION***************");
                    tablero nuevo=new tablero(matriz);
                    nuevo.Mover(y,x,t.getX(), t.getY());
                    nuevo.Imprimir();
                    System.out.println("**********************************");
                }

        }
    }
    
    private void Print(ArrayList<xypieza> piezas){

        for(int i=0;i<piezas.size();i++){
            System.out.println(piezas.get(i).getPieza());
        }
    }

    public TreeMap GenerarMovimientos(int pieza, int y, int x){

        switch(pieza){
            case variable.NPEON:
                peon t1=new peon(-1,x,y);
                return t1.getMovimientos(getTablero());
            case variable.BPEON:
                t1=new peon(1,x,y);
                return t1.getMovimientos(getTablero());
            case variable.NTORRE:
                torre t2=new torre(-1,x,y);
                return t2.getMovimientos(getTablero());
            case variable.BTORRE:
                t2=new torre(1,x,y);
                return t2.getMovimientos(getTablero());
            case variable.NALFIL:
                alfil t3=new alfil(-1,x,y);
                return t3.getMovimientos(getTablero());
            case variable.BALFIL:
                t3=new alfil(1,x,y);
                return t3.getMovimientos(getTablero());
            case variable.NCABALLO:
                caballo t4=new caballo(-1,x,y);
                return t4.getMovimientos(getTablero());
            case variable.BCABALLO:
                t4=new caballo(1,x,y);
                return t4.getMovimientos(getTablero());
            case variable.NDAMA:
                reina t5=new reina(-1,x,y);
                return t5.getMovimientos(getTablero());
            case variable.BDAMA:
                t5=new reina(1,x,y);
                return t5.getMovimientos(getTablero());
            case variable.NREY:
                rey t6=new rey(-1,x,y);
                return t6.getMovimientos(getTablero());
            case variable.BREY:
                t6=new rey(1,x,y);
                return t6.getMovimientos(getTablero());
            default:
                return null;
        }
    }

    public ArrayList<xypieza> Piezas_de_Jugador(boolean color){
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

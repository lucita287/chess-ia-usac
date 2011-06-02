/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.jugador;

import gui.edd.Arbol;
import gui.edd.Jugada;
import gui.edd.Nodo;
import gui.edd.Utilidad;
import gui.resources.variable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Daniel
 */
public class tablero {

    private Integer matriz[][];
    private int nturno;
    private final int infinito=9999;
    public tablero(Integer [][] m) {
        matriz=new Integer[8][8];
        for(int i=0;i<m.length;i++){
            System.arraycopy(m[i], 0, matriz[i], 0, m.length);
        }
        nturno=0;
    }

    public tablero() {
        matriz=new Integer[8][8];
       /** for(int i=0;i<8;i++){
            Integer t[]={0,0,0,0,0,0,0,0};
            matriz[i]=t;
        }**/
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
/**
 * Metodo el Cual Genera el Arbol MinMax
 * @param color
 * @param tablero
 */
    public Jugada GenerarArbol( boolean color, Integer [][]tablero){

        Tiempo();
         Arbol<Jugada> t=new Arbol();
         Nodo raiz=new Nodo();
         Jugada inicio=new Jugada(color);
         inicio.setRamificacion(0);
         inicio.setAlfaBeta(-infinito, infinito);
         raiz.setData(inicio);
         GenerarHijos(1,color, tablero,raiz); //Invocamos al Metodo que generar los hijos del arbol a partir de una raiz(tablero inicial)
         t.setRootElement(raiz);
            /**for(int i=0;i<t.toList().size();i++){
            Jugada j=t.toList().get(i).getData();
            if(j.getRamificacion()==2){
                System.out.println("**RAMIFICACION: "+j.getRamificacion());
                System.out.println("->PIEZA: "+j.getPieza());
                System.out.println("->MOVER A: "+j.getY()+"-"+j.getX());
                System.out.println("->UTILIDAD: "+j.getId());
                System.out.println("->( "+j.getAlfa()+", "+j.getBeta()+" )");
                }
        }**/
         inicio=(Jugada) raiz.getData();
         //inicio.Ver();
         Tiempo();
         if(color){
            return Resultado(raiz,inicio.getAlfa());
        }else{
            return Resultado(raiz,inicio.getBeta());
        }
            
            //return inicio;
    }

    private Jugada Resultado(Nodo raiz, int utilidad){

        for(int i=0;i<raiz.getNumberOfChildren();i++){
            Jugada r=((Jugada)((Nodo)raiz.getChildren().get(i)).getData());
            if(r.getId()==utilidad){
                r.Ver();
                return r;
            }
        }

        return (Jugada) raiz.getData();
    }
    private void Tiempo(){
        Calendar calendario = new GregorianCalendar();
        int hora, minutos, segundos;
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
        System.out.println(hora + ":" + minutos + ":" + segundos);
    }
    private void GenerarHijos(int r, boolean color, Integer [][]tablero, Nodo padre){

                ArrayList<xypieza> xyp=this.Piezas_de_Jugador(color);
                if(xyp!=null){
                for(int i=0;i<xyp.size();i++){
                    int pieza=xyp.get(i).getPieza();
                    int x=xyp.get(i).getX();
                    int y=xyp.get(i).getY();

                    TreeMap a=this.GenerarMovimientos(pieza, y, x);
                        for (Iterator iterator=a.values().iterator();iterator.hasNext();) {
                            xypieza t=(xypieza)iterator.next();
                            //System.out.println("************OPCION***************");
                            //System.out.println("---------------RAMIFICACION: "+(r)+"-----------------");
                            //System.out.println("****PIEZA: "+pieza+"****"+y+"-"+x);
                            //System.out.println(y+" "+x+"***"+t.getX()+" "+t.getY());
                            tablero nuevo=new tablero(tablero);
                            nuevo.Mover(y,x,t.getX(), t.getY());
                            //nuevo.Imprimir();
                             Nodo hijo=new Nodo();
                             Jugada j=new Jugada(color);
                             j.setPieza(pieza);
                             j.setXY(t.getY(), t.getX());
                             j.setOXY(x, y);
                             j.setRamificacion(r);
                             j.setTipo(color);
                             Jugada jp=(Jugada) padre.getData();
                             j.setAlfaBeta(jp.getAlfa(), jp.getBeta());
                             
                             int id=new Utilidad(tablero).getUtilidad();
                             if((id!=infinito)||(id!=-infinito)){
                                  if(!((r+1)<=variable.PROFUNDIDAD_RAMIFICACION)){
                                             j.setId(id);
                                             hijo.setData(j);
                                             padre.addChild(hijo);
                                             if(color){
                                             if(MinPoda((Jugada)padre.getData(),(Jugada)hijo.getData())){
                                                 break;
                                             }
                                            }else{
                                              if(MaxPoda((Jugada)padre.getData(),(Jugada)hijo.getData())){
                                                 break;
                                             }
                                            }
                                  }else{
                                            hijo.setData(j);
                                            nuevo.GenerarHijos(r+1, !color, nuevo.getTablero(), hijo);
                                            padre.addChild(hijo);
                                             if(color){
                                             if(MinPoda((Jugada)padre.getData(),(Jugada)hijo.getData())){
                                                 break;
                                             }
                                            }else{
                                              if(MaxPoda((Jugada)padre.getData(),(Jugada)hijo.getData())){
                                                 break;
                                             }
                                                
                                      }
                                  }
                             }else{
                                            j.setId(id);
                                             hijo.setData(j);
                                             padre.addChild(hijo);
                                             if(color){
                                             if(MinPoda((Jugada)padre.getData(),(Jugada)hijo.getData())){
                                                 break;
                                             }
                                            }else{
                                              if(MaxPoda((Jugada)padre.getData(),(Jugada)hijo.getData())){
                                                 break;
                                             }
                                 }
                             }
                                 
                             
                        }
 
                    }
        }
    }
 public boolean MinPoda(Jugada padre, Jugada hijo){

            if(hijo.getId()<=padre.getAlfa()){
                return true;
            }else{
                if(hijo.getId()<padre.getBeta()){
                padre.setBeta(hijo.getId());
                }
                //padre.setXY(hijo.getX(),hijo.getY());
                //padre.setOXY(hijo.getOx(),hijo.getOy());
                //padre.setPieza(hijo.getPieza());
                padre.setId(hijo.getBeta());
                return false;
            }

    }

    public boolean MaxPoda(Jugada padre, Jugada hijo){
            if(hijo.getId()<=padre.getAlfa()){
                return true;
            }else{
                if(hijo.getId()<padre.getBeta()){
                padre.setBeta(hijo.getId());
                }
                //padre.setXY(hijo.getX(),hijo.getY());
                //padre.setOXY(hijo.getOx(),hijo.getOy());
                //padre.setPieza(hijo.getPieza());
                padre.setId(hijo.getBeta());
                return false;
            }
    }

    public void Print(ArrayList<xypieza> piezas){

        for(int i=0;i<piezas.size();i++){
            System.out.println(piezas.get(i).getPieza()+" Y:"+piezas.get(i).getY()+" X:"+piezas.get(i).getX());
        }
    }

    private TreeMap GenerarMovimientos(int pieza, int y, int x){

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

    private ArrayList<xypieza> Piezas_de_Jugador(boolean color){
        ArrayList<xypieza> piezas=new ArrayList();
        boolean hayrey=false;
        for(int i=matriz.length-1;-1<i;i--){
            for(int j=0;j<matriz[i].length;j++){
                int temp=matriz[i][j];
                if((temp>0)&&color){
                    if(temp==variable.BREY)
                        hayrey=true;
                    piezas.add(new xypieza(temp, i, j));
                }else{
                    if((temp<0)&&!color){
                    if(temp==variable.NREY)
                        hayrey=true;
                    piezas.add(new xypieza(temp, i, j));
                    }
                }
            }
        }
        if(hayrey){
        return piezas;
        }else{
        return null;
        }
    }

    public int Utilidad(){
        return new Utilidad(this.matriz).getUtilidad();
    }

}

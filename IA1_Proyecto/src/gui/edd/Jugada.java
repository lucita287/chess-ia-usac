/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.edd;

/**
 *
 * @author Daniel
 */
public class Jugada {

    private boolean Tipo;
    private int Id, Alfa, Beta;
    private int pieza, x, y, ox, oy, ramificacion;
    
    public Jugada(boolean Tipo) {
        this.Tipo = Tipo;
    }

    public void setOx(int ox) {
        this.ox = ox;
    }

    public void setOy(int oy) {
        this.oy = oy;
    }

    public int getOx() {
        return ox;
    }

    public int getOy() {
        return oy;
    }

    public int getPieza() {
        return pieza;
    }

    public void setAlfa(int Alfa) {
        this.Alfa = Alfa;
    }

    public void setBeta(int Beta) {
        this.Beta = Beta;
    }

    public void setPieza(int pieza) {
        this.pieza = pieza;
    }

    public int getRamificacion() {
        return ramificacion;
    }

    public void setRamificacion(int ramificacion) {
        this.ramificacion = ramificacion;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setOXY(int x, int y) {
        this.ox = x;
        this.oy = y;
    }

    public int getAlfa() {
        return Alfa;
    }

    public void setAlfaBeta(int Alfa,int Beta) {
        this.Beta = Beta;
        this.Alfa = Alfa;
    }

    public int getBeta() {
        return Beta;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public boolean isTipo() {
        return Tipo;
    }

    public void setTipo(boolean Tipo) {
        this.Tipo = Tipo;
    }

    public void Ver(){
        System.out.println("RAMIFICACION: "+this.getRamificacion());
        System.out.println("UTILIDAD: "+this.getId());
        System.out.println("PIEZA: "+this.getPieza());
        System.out.println("ORIGEN X,Y: "+this.getOx()+","+this.getOy());
        System.out.println("MOVER A X,Y: "+this.getX()+","+this.getY());
        System.out.println("( "+this.getAlfa()+","+this.getBeta()+" )");
    }
}

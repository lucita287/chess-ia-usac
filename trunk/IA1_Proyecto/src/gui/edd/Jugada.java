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
    private int pieza, x, y, ramificacion;

    public Jugada(boolean Tipo) {
        this.Tipo = Tipo;
    }

    public int getPieza() {
        return pieza;
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
    
}

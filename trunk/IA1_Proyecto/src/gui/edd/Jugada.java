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
    private Integer Tablero[][];

    public Jugada(boolean Tipo, Integer[][] Tablero) {
        this.Tipo = Tipo;
        this.Tablero = Tablero;
    }

    public int getAlfa() {
        return Alfa;
    }

    public void setAlfa(int Alfa) {
        this.Alfa = Alfa;
    }

    public int getBeta() {
        return Beta;
    }

    public void setBeta(int Beta) {
        this.Beta = Beta;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Integer[][] getTablero() {
        return Tablero;
    }

    public void setTablero(Integer[][] Tablero) {
        this.Tablero = Tablero;
    }

    public boolean isTipo() {
        return Tipo;
    }

    public void setTipo(boolean Tipo) {
        this.Tipo = Tipo;
    }
    
}

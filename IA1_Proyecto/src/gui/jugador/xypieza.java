package gui.jugador;

/**
 *
 * @author Daniel
 */
public class xypieza {

    private int pieza;
    private int x;
    private int y;

    public xypieza(int pieza, int y, int x) {
        this.pieza=pieza;
        this.x = x;
        this.y = y;
    }

    public xypieza(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getPieza() {
        return pieza;
    }

    public void setPieza(int pieza) {
        this.pieza = pieza;
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
    
}

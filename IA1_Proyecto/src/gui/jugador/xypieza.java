package gui.jugador;

/**
 *
 * @author Daniel
 */
public class xypieza {

    private int pieza;
    private int x;
    private int y;
    private int x_;
    private int y_;

    public xypieza(int pieza, int x, int y, int x_, int y_) {
        this.pieza = pieza;
        this.x = x;
        this.y = y;
        this.x_ = x_;
        this.y_ = y_;
    }

   
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

        public int getX_() {
        return x_;
    }

    public void setX_(int x_) {
        this.x_ = x_;
    }

    public int getY_() {
        return y_;
    }

    public void setY_(int y_) {
        this.y_ = y_;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.resources;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class image_drive {

    /**Clase encargada
     * de devolver una Variable Icon
     * con todas las imagenes que se van a implementar
     *
     * Realizada por David Recinos
     *
     */
    private Icon no_seleccionado;
    private Icon seleccionado;
    private Icon blanco, negro;

    private Icon nrey, nreina, nalfil, ncaballo, ntorre, npeon;
    private Icon brey, breina, balfil, bcaballo, btorre, bpeon;

    /**Constructor que inicializa variables
     * 
     */
    public image_drive(){

        Image i1=new ImageIcon(this.getClass().getResource("image/negro.jpg")).getImage();
        negro=new ImageIcon(i1.getScaledInstance(variable.ANCHO,variable.ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/blanco.jpg")).getImage();
        blanco=new ImageIcon(i1.getScaledInstance(variable.ANCHO,variable.ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/bpeon.png")).getImage();
        bpeon=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/btorre.png")).getImage();
        btorre=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/bcaballo.png")).getImage();
        bcaballo=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/balfil.png")).getImage();
        balfil=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/breina.png")).getImage();
        breina=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/brey.png")).getImage();
        brey=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/npeon.png")).getImage();
        npeon=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/ntorre.png")).getImage();
        ntorre=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/ncaballo.png")).getImage();
        ncaballo=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/nalfil.png")).getImage();
        nalfil=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/nreina.png")).getImage();
        nreina=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));

        i1=new ImageIcon(this.getClass().getResource("image/nrey.png")).getImage();
        nrey=new ImageIcon(i1.getScaledInstance(variable.PIEZA_ANCHO,variable.PIEZA_ALTO, Image.SCALE_DEFAULT));
    }

/**Color: Blanca o Negra
 * variable.BLANCA
 * variable.NEGRA
 * Pieza: Alfil
 *
 * @param color
 * @return
 */
    public Icon getAlfil(boolean color) {
        if(color){
        return balfil;
        }else{
        return nalfil;
        }
    }
/**Color: Blanca
 * Pieza: Caballo
 * @return
 */
    public Icon getBcaballo() {
        return bcaballo;
    }
/**Color: Blanca
 * Tipo: Casilla
 * @return
 */
    public Icon getBlanco() {
        return blanco;
    }
/**Color: Blanca o Negra
 * variable.BLANCA
 * variable.NEGRA
 *
 * @param color
 * @return
 */
    public Icon getPeon(boolean color) {
        if(color){
        return bpeon;
        }else{
        return npeon;
        }
    }
/**Color: Blanca o Negra
 * variable.BLANCA
 * variable.NEGRA
 * Pieza: Reina
 *
 * @param color
 * @return
 */
    public Icon getReina(boolean color) {
       if(color){
        return breina;
        }else{
        return nreina;
        }
    }
/**Color: Blanca o Negra
 * variable.BLANCA
 * variable.NEGRA
 * Pieza: Rey
 *
 * @param color
 * @return
 */
    public Icon getRey(boolean color) {
        if(color){
        return brey;
        }else{
        return nrey;
        }
    }
/**Color: Blanca o Negra
 * variable.BLANCA
 * variable.NEGRA
 * Pieza: Torre
 *
 * @param color
 * @return
 */
    public Icon getTorre(boolean color) {
        if(color){
        return btorre;
        }else{
        return ntorre;
        }
    }

/**Color: Blanca o Negra
 * variable.BLANCA
 * variable.NEGRA
 * Pieza: Caballo
 *
 * @param color
 * @return
 */
    public Icon getCaballo(boolean color) {
        if(color){
        return bcaballo;
        }else{
        return ncaballo;
        }
    }
/**Color: Negra
 * Tipo: Casilla
 * @return
 */
    public Icon getNegro() {
        return negro;
    }
/**Color: Gris
 * Tipo: Casilla
 * @return
 */
    public Icon getNo_seleccionado() {
        return no_seleccionado;
    }

/**Color: Celeste
 * Tipo: Casilla
 * @return
 */
    public Icon getSeleccionado() {
        return seleccionado;
    }

   

   
}

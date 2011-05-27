/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.edd;


/**
 *
 * @author Daniel
 */
public class Test {



    public static void main(String[] args){
            Arbol<String> t=new Arbol();
            Nodo raiz=new Nodo();
            raiz.data="1";
            for(int i=0;i<8;i++){
                Nodo hijo1=new Nodo();
                hijo1.data="HIJO"+i;
                raiz.addChild(hijo1);
                for(int j=0;j<i;j++){
                    Nodo hijo2=new Nodo();
                    hijo2.data="->HIJO"+i+j;
                    hijo1.addChild(hijo2);
                }

            }
            t.setRootElement(raiz);
            for(int i=0;i<t.toList().size();i++){
                System.out.println(t.toList().get(i).data);
            }

            /**Arbol a = new Arbol();
            Posicion raiz = new Posicion();
            raiz.info = "Raiz";
            a.insertaHijo(raiz, "Raiz");
            **/
    
    }
}

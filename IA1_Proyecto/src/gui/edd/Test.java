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
            Tree<String> t=new Tree();
            Node raiz=new Node();
            raiz.data="1";
            for(int i=0;i<8;i++){
                Node hijo1=new Node();
                hijo1.data="HIJO"+i;
                raiz.addChild(hijo1);
                for(int j=0;j<i;j++){
                    Node hijo2=new Node();
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

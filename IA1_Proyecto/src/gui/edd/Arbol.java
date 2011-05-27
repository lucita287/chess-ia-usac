/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.edd;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daniel
 */
/**
 * Represents a Arbol of Objects of generic type T. The Arbol is represented as
 * a single rootElement which points to a List<Nodo<T>> of children. There is
 * no restriction on the number of children that a particular node may have.
 * This Arbol provides a method to serialize the Arbol into a List by doing a
 * pre-order traversal. It has several methods to allow easy updation of Nodes
 * in the Arbol.
 */
public class Arbol<T> {

    private Nodo<T> rootElement;

    /**
     * Default ctor.
     */
    public Arbol() {
        super();
    }

    /**
     * Return the root Nodo of the tree.
     * @return the root element.
     */
    public Nodo<T> getRootElement() {
        return this.rootElement;
    }

    /**
     * Set the root Element for the tree.
     * @param rootElement the root element to set.
     */
    public void setRootElement(Nodo<T> rootElement) {
        this.rootElement = rootElement;
    }

    /**
     * Returns the Arbol<T> as a List of Nodo<T> objects. The elements of the
     * List are generated from a pre-order traversal of the tree.
     * @return a List<Nodo<T>>.
     */
    public List<Nodo<T>> toList() {
        List<Nodo<T>> list = new ArrayList<Nodo<T>>();
        walk(rootElement, list);
        return list;
    }

    /**
     * Returns a String representation of the Arbol. The elements are generated
     * from a pre-order traversal of the Arbol.
     * @return the String representation of the Arbol.
     */
    @Override
    public String toString() {
        return toList().toString();
    }

    /**
     * Walks the Arbol in pre-order style. This is a recursive method, and is
     * called from the toList() method with the root element as the first
     * argument. It appends to the second argument, which is passed by reference     * as it recurses down the tree.
     * @param element the starting element.
     * @param list the output of the walk.
     */
    private void walk(Nodo<T> element, List<Nodo<T>> list) {
        list.add(element);
        for (Nodo<T> data : element.getChildren()) {
            walk(data, list);
        }
    }
}

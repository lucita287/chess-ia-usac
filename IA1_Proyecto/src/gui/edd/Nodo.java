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
 * Represents a node of the Tree<T> class. The Nodo<T> is also a container, and
 * can be thought of as instrumentation to determine the location of the type T
 * in the Tree<T>.
 */
public final class Nodo<T> {

    public T data;
    public List<Nodo<T>> children;

    /**
     * Default ctor.
     */
    public Nodo() {
        super();
    }

    /**
     * Convenience ctor to create a Nodo<T> with an instance of T.
     * @param data an instance of T.
     */
    public Nodo(T data) {
        this();
        setData(data);
    }

    /**
     * Return the children of Nodo<T>. The Tree<T> is represented by a single
     * root Nodo<T> whose children are represented by a List<Nodo<T>>. Each of
     * these Nodo<T> elements in the List can have children. The getChildren()
     * method will return the children of a Nodo<T>.
     * @return the children of Nodo<T>
     */
    public List<Nodo<T>> getChildren() {
        if (this.children == null) {
            return new ArrayList<Nodo<T>>();
        }
        return this.children;
    }

    /**
     * Sets the children of a Nodo<T> object. See docs for getChildren() for
     * more information.
     * @param children the List<Nodo<T>> to set.
     */
    public void setChildren(List<Nodo<T>> children) {
        this.children = children;
    }

    /**
     * Returns the number of immediate children of this Nodo<T>.
     * @return the number of immediate children.
     */
    public int getNumberOfChildren() {
        if (children == null) {
            return 0;
        }
        return children.size();
    }

    /**
     * Adds a child to the list of children for this Nodo<T>. The addition of
     * the first child will create a new List<Nodo<T>>.
     * @param child a Nodo<T> object to set.
     */
    public void addChild(Nodo<T> child) {
        if (children == null) {
            children = new ArrayList<Nodo<T>>();
        }
        children.add(child);
    }

    /**
     * Inserts a Nodo<T> at the specified position in the child list. Will     * throw an ArrayIndexOutOfBoundsException if the index does not exist.
     * @param index the position to insert at.
     * @param child the Nodo<T> object to insert.
     * @throws IndexOutOfBoundsException if thrown.
     */
    public void insertChildAt(int index, Nodo<T> child) throws IndexOutOfBoundsException {
        if (index == getNumberOfChildren()) {
            // this is really an append
            addChild(child);
            return;
        } else {
            children.get(index); //just to throw the exception, and stop here
            children.add(index, child);
        }
    }

    /**
     * Remove the Nodo<T> element at index index of the List<Nodo<T>>.
     * @param index the index of the element to delete.
     * @throws IndexOutOfBoundsException if thrown.
     */
    public void removeChildAt(int index) throws IndexOutOfBoundsException {
        children.remove(index);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(getData().toString()).append(",[");
        int i = 0;
        for (Nodo<T> e : getChildren()) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(e.getData().toString());
            i++;
        }
        sb.append("]").append("}");
        return sb.toString();
    }
}

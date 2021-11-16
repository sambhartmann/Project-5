/**
 * 
 */
package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sam Hartmann, Annalise Gellene, Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class LinkedList<T> {
    public static class Node<D> {

        // The data element stored in the node.
        private D data;

        // The next node in the sequence.
        private Node<D> next;

        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(D d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<D> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<D> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public D getData() {
            return data;
        }
    }

    private Node<T> firstNode;
    private int size;

    public LinkedList() {
        firstNode = null;
        size = 0;
    }


    public int size() {
        return size;
    }


    public Node<T> getFirstNode() {
        return firstNode;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    public void add(int index, T obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        // check if the index is out of bounds
        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = firstNode;

        // empty stack case
        if (isEmpty()) {
            firstNode = new Node<T>(obj);
        }

        // all other cases
        else {
            if (index == 0) {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(firstNode);
                firstNode = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    current = current.next();
                }
            }
        }
        size++;
    }


    public void add(T obj) {
        // check if the object is null
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = firstNode;

        // empty stack case
        if (isEmpty()) {
            firstNode = new Node<T>(obj);
        }

        // other cases
        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }


    public T get(int index) {
        Node<T> current = firstNode;
        int currentIndex = 0;
        T data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        if (data == null) {
            throw new IndexOutOfBoundsException("Index" + ""
                + "exceeds the size.");
        }
        return data;
    }


    public boolean remove(T obj) {
        Node<T> current = firstNode;

        // account for matching head
        if ((null != firstNode) && (obj.equals(current.data))) {
            firstNode = firstNode.next;
            size--;
            return true;
        }

        // account for 2+ size
        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    public void clear() {
        // make sure we don't call clear on an empty list
        if (firstNode != null) {
            firstNode.setNext(null);
            firstNode = null;
        }

    }


    public boolean contains(T obj) {
        Node<T> current = firstNode;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    @Override
    public String toString() {
        String result = "{";

        Node<T> current = firstNode;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            LinkedList<T> other = ((LinkedList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = firstNode;
                Node<T> otherCurrent = other.firstNode;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }


    public Iterator<T> iterator() {
        return new SLListIterator<T>();
    }

    private class SLListIterator<A> implements Iterator<T> {

        private Node<T> next;

        /**
         * Creates a new DLListIterator
         */
        public SLListIterator() {
            next = firstNode.next;
        }


        @Override
        public boolean hasNext() {
            return (next.next() != null);
        }


        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException(
                    "There are no more nodes left in the list");
            }

            T data = next.getData();
            next = next.next;
            return data;
        }
    }

}

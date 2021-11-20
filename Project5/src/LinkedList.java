/**
 * 
 */
package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.18.2021
 * @param <T>
 *            the type of object the linkedList contains
 */
public class LinkedList<T> {
    /**
     * 
     * @author Sam Hartmann
     * @author Josh Sapirstein
     * @version 11.18.2021
     *
     * @param <D>
     *            the type of object that the node is
     */
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

    /**
     * Creates a new linked list object
     */
    public LinkedList() {
        firstNode = null;
        size = 0;
    }


    /**
     * gets the size of the linked list
     * 
     * @return the size of the linked list
     */
    public int size() {
        return size;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     */
    public void add(int index, T obj) {
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
                    currentIndex++;
                }
            }
        }
        size++;
    }


    /**
     * Adds a element to the end of the list
     *
     * @param obj
     *            the element to add to the end
     */
    public void add(T obj) {
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


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     */
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


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
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
                current.setNext(current.next.next);
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     */
    public boolean remove(int index) {
        // if the index is invalid
        if (index < 0 || firstNode == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node<T> current = firstNode;
            int currentIndex = 0;
            if (index == 0) {
                firstNode = current.next;
                size--;
                return true;
            }
            while (current.next != null) {
                if ((currentIndex + 1) == index) {
                    Node<T> newNext = current.next.next;
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++;
            }

            // if the element was never found, this also handles empty case
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Removes all of the elements from the list and sets size to 0
     */
    public void clear() {
        // make sure we don't call clear on an empty list
        if (firstNode != null) {
            firstNode.setNext(null);
            firstNode = null;
        }
        size = 0;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
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


    /**
     * creates an array from the contents of the linked list
     * 
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<T> current = firstNode;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Performs an insertion sort by splitting the list into a sorted and an
     * unsorted portion and then iterates through the unsorted portion to
     * insert each node one-by-one into the sorted portion.
     * 
     * @param comp
     *            the Comparator to compare nodes
     */
    public void insertionSort(Comparator<T> comp) {
        if (size > 1) {
            Node<T> unsortedPart = firstNode.next;
            Node<T> sortedPart = firstNode;
            sortedPart.setNext(null);

            while (unsortedPart != null) {
                Node<T> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next;
                insertIntoSorted(nodeToInsert, comp);
            }
        }
    }


    /**
     * Helper method to insert a node into its proper location in a sorted
     * linked chain.
     * 
     * @param nodeToInsert
     *            node to add to sorted section of list
     * @param comp
     *            the Comparator to compare nodes
     */
    private void insertIntoSorted(Node<T> nodeToInsert, Comparator<T> comp) {
        T item = nodeToInsert.getData();
        Node<T> currentNode = firstNode;
        Node<T> previousNode = null;
        while ((currentNode != null && (comp.compare(item, currentNode
            .getData()) > 0))) {

            previousNode = currentNode;
            currentNode = currentNode.next;
        }
        if (previousNode == null) {
            nodeToInsert.setNext(firstNode);
            firstNode = nodeToInsert;
        }
        else {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }

    }


    /**
     * converts the singly linked list into a string
     * 
     * @return the string representing the singly linked list
     */
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


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
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


    /**
     * Iterator method creates Iterator object
     *
     * @return new Iterator object
     */
    public Iterator<T> iterator() {
        return new SLListIterator<T>();
    }

    private class SLListIterator<A> implements Iterator<T> {

        private Node<T> next;

        /**
         * Creates a new SLListIterator
         */
        public SLListIterator() {
            next = firstNode;
        }


        /**
         * Checks if there are more elements in the list
         *
         * @return true if there are more elements in the list
         */
        @Override
        public boolean hasNext() {
            return (next != null);
        }


        /**
         * Gets the next value in the list
         *
         * @return the next value
         */
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException(
                    "There are no more nodes left in the list");
            }

            T data = next.getData();
            next = next.next();
            return data;
        }
    }
}

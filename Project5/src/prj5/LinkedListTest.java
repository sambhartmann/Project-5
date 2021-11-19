package prj5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Sam Hartmann, Josh Sapirstein
 * @version 11.18.2021
 */
public class LinkedListTest extends student.TestCase {
    private LinkedList<String> list1;
    private LinkedList<String> emptyList;
    private LinkedList<String> list3;

    /**
     * Sets up the test methods
     */
    public void setUp() {
        list1 = new LinkedList<String>();
        list1.add("Doc Ock");
        list1.add("Green Goblin");
        list1.add("Electro");
        list1.add("Lizard");
        list1.add("Sandman");
        emptyList = new LinkedList<String>();
        list3 = new LinkedList<String>();
        list3.add("Doc Ock");
        list3.add("Green Goblin");
        list3.add("Electro");
        list3.add("Lizard");
        list3.add("Sandman");
    }


    /**
     * tests size()
     */
    public void testSize() {
        assertEquals(5, list1.size());
        assertEquals(0, emptyList.size());
    }


    /**
     * tests isEmpty
     */
    public void testIsEmpty() {
        assertFalse(list1.isEmpty());
        assertTrue(emptyList.isEmpty());
    }


    /**
     * tests add method with specific index
     */
    public void testAddByIndex() {
        Exception exception = null;
        try {
            list1.add(0, null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        try {
            list1.add(-1, "bob");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        try {
            list1.add(10, "bob");
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        Object[] array = { "Scorpion", "Vulture", "Doc Ock", "Green Goblin",
            "Electro", "Venom", "Lizard", "Shocker", "Sandman" };

        list1.add(0, "Scorpion");
        list1.add(1, "Vulture");
        list1.add(5, "Venom");
        list1.add(7, "Shocker");
        assertTrue(Arrays.equals(list1.toArray(), array));
        assertEquals(9, list1.size());
        emptyList.add(0, "Peter Parker");
    }


    /**
     * Tests add() with no specified location
     */
    public void testAdd() {
        Exception exception = null;
        try {
            list1.add(null);
            fail("add() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("add() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);

        assertEquals(0, emptyList.size());
        emptyList.add("Spider-Man");
        assertEquals(1, emptyList.size());
        emptyList.add("Aunt May");
        emptyList.add("Ned Leeds");
        emptyList.add("MJ");
        assertEquals(4, emptyList.size());
    }


    /**
     * tests get()
     */
    public void testGet() {
        Exception exception = null;
        try {
            list1.get(7);
            fail("get() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("get() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        assertEquals("Electro", list1.get(2));
        assertEquals("Doc Ock", list1.get(0));
        assertEquals("Sandman", list1.get(4));

    }


    /**
     * Tests remove() where the parameter is a string
     */
    public void testRemove() {
        assertTrue(list1.remove("Green Goblin"));
        assertFalse(list1.contains("Kingpin"));
        assertTrue(list1.remove("Electro"));
        assertFalse(list1.contains("Electro"));
        assertFalse(list1.remove("bob"));
        assertFalse(emptyList.remove("cat"));
        emptyList.add("cat");
        assertFalse(emptyList.remove("dog"));
        assertTrue(emptyList.remove("cat"));
    }


    /**
     * Tests remove() where the parameter is an index
     */
    public void testRemoveIndex() {
        String removedList = "{Electro, Sandman}";
        assertTrue(list1.remove(3));
        assertTrue(list1.remove(1));
        assertTrue(list1.remove(0));
        assertEquals(2, list1.size());
        assertEquals(removedList, list1.toString());

    }


    /**
     * Tests index out of bounds exceptions for remove() where the parameter is
     * an index
     */
    public void testRemoveIndexException() {
        Exception exception = null;
        try {
            list1.remove(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        try {
            list1.remove(7);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        try {
            emptyList.remove(0);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);

        try {
            emptyList.remove(-1);
            fail("remove() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("remove() is throwing the wrong type of exceptions",
            exception instanceof IndexOutOfBoundsException);
    }


    /**
     * Tests clear() without turning it into an array
     * 
     */
    public void testClear() {
        assertEquals(5, list1.size());
        assertTrue(list1.contains("Sandman"));
        list1.clear();
        list1.clear();
        assertEquals(0, list1.size());
        assertFalse(list1.contains("Sandman"));
        assertEquals(0, emptyList.size());
        emptyList.clear();
        assertEquals(0, emptyList.size());

    }


    /**
     * Tests contains()
     */
    public void testContains() {
        assertTrue(list1.contains("Green Goblin"));
        assertFalse(list1.contains("Kingpin"));
    }


    /**
     * tests toString()
     */
    public void testToString() {
        assertEquals("{}", emptyList.toString());
        String str = "{Doc Ock, Green Goblin, Electro, Lizard, Sandman}";
        String str2 = "{Doc Ock, Green Goblin, Lizard, Sandman}";
        assertEquals(str, list1.toString());
        list1.remove(2);
        emptyList.add("cats");
        assertEquals("{cats}", emptyList.toString());
        assertEquals(str2, list1.toString());
    }


    /**
     * tests equals()
     */
    public void testEquals() {
        assertTrue(list1.equals(list1));
        assertFalse(list1.equals(emptyList));
        assertFalse(list1.equals(null));
        assertFalse(list1.equals("bob"));
        assertTrue(list1.equals(list3));
        emptyList.add("cat");
        emptyList.add("cat");
        emptyList.add("cat");
        emptyList.add("cat");
        emptyList.add("cat");
        assertFalse(list1.equals(emptyList));
    }


    /**
     * Test cases for SLLIterator
     */

    /**
     * tests hasNext()
     */
    public void testHasNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        Iterator<String> iter = list.iterator();
        assertTrue(iter.hasNext());
        iter.next();
        iter.next();
        assertFalse(iter.hasNext());
    }


    /**
     * Tests next()
     */
    public void testNext() {
        LinkedList<String> list = new LinkedList<String>();
        list.add("A");
        list.add("B");
        Iterator<String> iter = list.iterator();
        assertEquals("A", iter.next());
        iter.next();
        Exception exception;
        exception = null;
        try {
            iter.next();
        }
        catch (NoSuchElementException e) {
            exception = e;
        }
        assertTrue(exception instanceof NoSuchElementException);

    }


    /**
     * Tests insertionSort() and the helper method insertIntoSorted
     */
    public void testInsertionSort() {
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> comp2 = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        list1.insertionSort(comp);
        list.insertionSort(comp2);
    }

}

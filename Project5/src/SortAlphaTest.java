package prj5;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.19.2021
 *
 */
public class SortAlphaTest extends student.TestCase {
    private SortAlpha sa;
    private Race race1;
    private Race race2;
    private Race race3;

    /**
     * sets up test Methods
     */
    public void setUp() {
        sa = new SortAlpha();
        race1 = new Race("Wookie", 9.0, 10.0, 1.3);
        race2 = new Race("Ewok", 1.0, 2.0, 3.3);
        race3 = new Race("Wookie", 1.0, 2.0, 3.3);
    }


    /**
     * tests compare()
     */
    public void testCompare() {
        assertEquals(18, sa.compare(race1, race2));
        assertEquals(-18, sa.compare(race2, race1));
        assertEquals(0, sa.compare(race1, race3));
    }

}

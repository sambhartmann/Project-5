package prj5;

/**
 * @author Sam Hartmann, Josh Sapirstein
 * @version 11.19.2021
 *
 */
public class RaceTest extends student.TestCase {

    private Race race;

    /**
     * sets up test methods
     */
    public void setUp() {
        race = new Race("white", 8.0, 7.0, 2.3);
    }


    /**
     * tests getName()
     */
    public void testGetName() {
        assertEquals("white", race.getName());
    }


    /**
     * tests getCases()
     */

    public void testGetCases() {
        assertEquals(8.0, race.getCases(), 0.1);
    }


    /**
     * tests getDeaths()
     */
    public void testGetDeaths() {
        assertEquals(7.0, race.getDeaths(), 0.1);
    }


    public void testGetCFR() {
        assertEquals(2.3, race.getCFR(), 0.1);
    }
}

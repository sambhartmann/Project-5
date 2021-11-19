package prj5;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * @author Sam Hartmann, Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class StateTest extends student.TestCase {
    private State state1;
    private State state2;
    private int[] cases;
    private int[] deaths;
    private int[] casesWithNA;
    private int[] deathsWithNA;

    /**
     * sets up test cases
     */
    public void setUp() {
        cases = new int[] { 70678, 179563, 97118, 5407, 108784 };
        deaths = new int[] { 1924, 13365, 2269, 254, 170 };
        state1 = new State("DC", cases, deaths);
        casesWithNA = new int[] { 616402, -1, 738177, -1, 77733 };
        deathsWithNA = new int[] { 4311, 14702, -1, -1, 5745 };
        state2 = new State("VA", casesWithNA, deathsWithNA);
    }


    /**
     * tests getName()
     */
    public void testGetName() {
        assertEquals("DC", state1.getName());
    }


    /**
     * tests getCases
     */
    public void testGetCases() {
        int[] correctCases = new int[] { 70678, 179563, 97118, 5407, 108784 };
        assertTrue(Arrays.equals(correctCases, state1.getCases()));
    }


    /**
     * tests getDeaths
     */
    public void testGetDeaths() {
        int[] correctDeaths = new int[] { 1924, 13365, 2269, 254, 170 };
        assertTrue(Arrays.equals(correctDeaths, state1.getDeaths()));
    }


    /**
     * tests getSpecificCase()
     */
    public void testGetSpecificCase() {
        assertEquals(70678, state1.getSpecificCase("white"));
        assertEquals(-1, state2.getSpecificCase("asian"));
        assertEquals(-1, state1.getSpecificCase("Germanic"));
    }


    /**
     * tests getSpecificDeath()
     */
    public void testGetSpecificDeath() {
        assertEquals(1924, state1.getSpecificDeath("white"));
        assertEquals(-1, state1.getSpecificDeath("Germanic"));

    }


    /**
     * tests calculateCFR()
     */
    public void testCalculateCFR() {
        DecimalFormat df1 = new DecimalFormat("#.0");
        assertEquals("2.7", (df1.format(state1.calculateCFR("white"))));
        assertEquals(-1.0, state2.calculateCFR("latinx"), 0.1);
        assertEquals(-1.0, state2.calculateCFR("black"), 0.1);
        assertEquals(-1.0, state2.calculateCFR("asian"), 0.1);

        Exception e = null;
        try {
            state1.calculateCFR("Germanic");
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
    }


    /**
     * tests toString
     */
    public void testToString() {
        String state1String = "DC\r\n" + "white: 70678 cases, 2.7% CFR\r\n"
            + "black: 179563 cases, 7.4% CFR\r\n"
            + "latinx: 97118 cases, 2.3% CFR\r\n"
            + "asian: 5407 cases, 4.7% CFR\r\n"
            + "other: 108784 cases, 0.2% CFR";
        assertEquals(state1String, state1.toString());
        String state2String = "VA\r\n" + "white: 616402 cases, 0.7% CFR\r\n"
            + "black: -1 cases, -1% CFR\r\n"
            + "latinx: 738177 cases, -1% CFR\r\n"
            + "asian: -1 cases, -1% CFR\r\n" + "other: 77733 cases, 7.4% CFR";
        assertEquals(state2String, state2.toString());
    }
}

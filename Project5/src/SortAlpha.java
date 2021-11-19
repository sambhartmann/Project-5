package prj5;

import java.util.Comparator;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.19.2021
 *
 */
public class SortAlpha implements Comparator<Race> {

    /**
     * compares two race objects by their name
     * 
     * @param a
     *            the first race
     * @param b
     *            the race that the first race is being compared two
     * @return an int of the difference between the first race and the second
     *         race's names
     */
    public int compare(Race a, Race b) {
        String race1 = a.getName();
        String race2 = b.getName();
        return race1.compareTo(race2);
    }
}

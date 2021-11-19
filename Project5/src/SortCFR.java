package prj5;

import java.util.Comparator;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.19.2021
 *
 */
public class SortCFR implements Comparator<Race> {

    /**
     * compares the two Race objects by their CFR, if that is equal it compares
     * them by their name
     * 
     * @param a
     *            the first race
     * @param b
     *            the race we are comparing the first race to
     * @return -1, if the first race's CFR is larger that the second race's, if
     *         both CFR's are equal than then return int from comparing their
     *         names, 1 otherwise
     */
    public int compare(Race a, Race b) {
        double cfr1 = a.getCFR();
        double cfr2 = b.getCFR();
        if (cfr1 > cfr2) {
            return -1;
        }
        if (Double.compare(cfr1, cfr2) == 0) {
            String race1 = a.getName();
            String race2 = b.getName();
            return race1.compareTo(race2);
        }
        else {
            return 1;
        }
    }
}

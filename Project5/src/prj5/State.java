/**
 * 
 */
package prj5;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sam Hartmann, Annalise Gellene, Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class State {
    private String name;
    private Object[] cases;
    private Object[] deaths;
    /**
     * Since we only have a specific number of races,
     * we can store them in this array
     */
    public String[] races = { "White", "Black", "LatinX", "Asian", "Other" };
    /**
     * Creates a list of Strings from the array of races
     * the reason we are doing this is so that we are able to sort by race
     */
    public List<String> listOfRaces = Arrays.asList(races);

    /**
     * 
     * @param name
     *            the name of the state
     * @param cases
     *            the number of cases in a state for each race
     * @param deaths
     *            the number of deaths in a state for each race
     */
    public State(String name, Object[] cases, Object[] deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
    }


    public String getName() {
        return name;
    }


    public Object[] getCases() {
        return cases;
    }


    public Object[] getDeaths() {
        return deaths;
    }


    public Object getSpecificCase(String race) {
        for (int i = 0; i < races.length; i++) {
            if (races[i] == race) {
                return cases[i];
            }
        }
        return -1;
    }


    public Object getSpecificDeath(String race) {
        for (int i = 0; i < races.length; i++) {
            if (races[i] == race) {
                return deaths[i];
            }
        }
        return -1;
    }


    public Object calculateCFR(String race) {
        int index = -1;
        for (int i = 0; i < races.length; i++) {
            if (races[i] == race) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("race not found");
        }
        if (deaths[index] != "NA" || cases[index] != "NA") {

            double cfr = ((double)deaths[index] / (double)cases[index]) * 100;
            return cfr;

        }
        return "";
    }
}

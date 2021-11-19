
package prj5;

import java.text.DecimalFormat;

/**
 * @author Sam Hartmann, Annalise Gellene, Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class State {
    private String name;
    private int[] cases;
    private int[] deaths;
    /**
     * Since we only have a specific number of races,
     * we can store them in this array
     */
    public final String[] RACES = { "white", "black", "latinx", "asian",
        "other" };
    /**
     * Creates a list of Strings from the array of races
     * the reason we are doing this is so that we are able to sort by race
     */
    public LinkedList<Race> listOfRaces;

    /**
     * 
     * @param name
     *            the name of the state
     * @param cases
     *            the number of cases in a state for each race
     * @param deaths
     *            the number of deaths in a state for each race
     */
    public State(String name, int[] cases, int[] deaths) {
        this.name = name;
        this.cases = cases;
        this.deaths = deaths;
        listOfRaces = this.createList();
    }


    /**
     * gets the name of the state
     * 
     * @return the name of the state
     */
    public String getName() {
        return name;
    }


    /**
     * gets the cases array of the state
     * 
     * @return the cases array of the state
     */
    public int[] getCases() {
        return cases;
    }


    /**
     * gets the deaths array of the state
     * 
     * @return the death array of the state
     */
    public int[] getDeaths() {
        return deaths;
    }


    public LinkedList<Race> createList() {
        LinkedList<Race> tempList = new LinkedList<Race>();
        for (int i = 0; i < RACES.length; i++) {
            Race raceI = new Race(RACES[i], (double)cases[i], (double)deaths[i],
                calculateCFR(RACES[i]));
            tempList.add(raceI);
        }
        return tempList;
    }


    /**
     * gets number of cases given a race
     * 
     * @param race
     *            the race that we are looking for the number of cases of
     * @return
     *         the number of cases that rase has in the state
     */
    public Object getSpecificCase(String race) {
        for (int i = 0; i < RACES.length; i++) {
            if (RACES[i] == race) {
                return cases[i];

            }
        }
        return -1;
    }


    /**
     * gets number of deaths given a race
     * 
     * @param race
     *            the race that we are looking for the number of deaths of
     * @return
     *         the number of deaths that rase has in the state
     */
    public Object getSpecificDeath(String race) {
        for (int i = 0; i < RACES.length; i++) {
            if (RACES[i] == race) {
                return deaths[i];
            }
        }
        return -1;
    }


    /**
     * @param race
     *            the race we are calculating the CFR number for
     * @return the CFR number for that race in the state
     * @throws IllegalArgumentException
     *             is thrown if that race is not found
     */
    public double calculateCFR(String race) throws IllegalArgumentException {

        int index = -1;
        for (int i = 0; i < RACES.length; i++) {
            if (RACES[i] == race) {
                index = i;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("race not found");
        }
        if (deaths[index] == -1 || cases[index] == -1) {
            return -1.0;
        }
        else {

            double cfr = (((double)deaths[index])) / (((double)cases[index]));
            return cfr * 100.0;
        }
    }


    /**
     * ToString() implementation for the State class
     * 
     * @return String
     */
    // TODO Requires sorting implentation first
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.#");
        StringBuilder str = new StringBuilder();
        str.append(this.name + "\n");
        for (int i = 0; i < cases.length; i++) {
            Race currentRace = listOfRaces.get(i);
            str.append(currentRace.getName() + ": " + df.format(currentRace
                .getCases()) + " cases, " + df.format(currentRace.getCFR())
                + "% CFR");
            if (i != cases.length - 1) {
                str.append("\n");
            }
        }
        return str.toString();
    }
}

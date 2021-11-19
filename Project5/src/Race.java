package prj5;

/**
 * 
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.19.2021
 */
public class Race {
    private String raceName;
    private double cases;
    private double deaths;
    private double cfr;

    /**
     * creates a Race object
     * 
     * @param name
     *            the name of the race
     * @param cases
     *            the number of cases that race has
     * @param deaths
     *            the number of deaths that race has
     * @param cfr
     *            the Case Fatality Ratio of the race
     */
    public Race(String name, double cases, double deaths, double cfr) {
        raceName = name;
        this.cases = cases;
        this.deaths = deaths;
        this.cfr = cfr;
    }


    /**
     * gets the name of the race
     * 
     * @return the name of the race
     */
    public String getName() {
        return raceName;
    }


    /**
     * gets the number of cases of the race
     * 
     * @return the number of cases of the race
     */
    public double getCases() {
        return cases;
    }


    /**
     * gets the number of deaths of the race
     * 
     * @return the number of deaths of the race
     */
    public double getDeaths() {
        return deaths;
    }


    /**
     * gets the Case Fatality Ratio of the race
     * 
     * @return the Case Fatality Ratio of the race
     */
    public double getCFR() {
        return cfr;
    }

}

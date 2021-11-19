package prj5;

import java.text.DecimalFormat;

/**
 * @author Sam Hartmann, Josh Sapirstein
 * @version 11.19.2021
 *
 */
public class Race {
    private String raceName;
    private double cases;
    private double deaths;
    private double cfr;
    DecimalFormat df = new DecimalFormat("0.#");

    public Race(String name, double cases, double deaths, double cfr) {
        raceName = name;
        this.cases = cases;
        this.deaths = deaths;
        this.cfr = cfr;
    }


    public String getName() {
        return raceName;
    }


    public double getCases() {
        return cases;
    }


    public double getDeaths() {
        return deaths;
    }


    public double getCFR() {
        return cfr;
    }

}

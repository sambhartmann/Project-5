package prj5;

import java.io.FileNotFoundException;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.19.2021
 *
 */
public class Input {

    public Input() {
        // Left empty on purpose
    }


    /**
     * main method to run project
     * 
     * @param args
     *            the array containing the file names that we will run
     * @throws FileNotFoundException
     *             is thrown if no file is givenF
     */
    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0) {
            DataReader dr = new DataReader(args[0]);
        }
        else {

            DataReader dr = new DataReader(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }
    }
}

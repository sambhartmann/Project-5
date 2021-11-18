package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sam Hartmann, Annalise Gellene, Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class DataReader {
    private Object[] cases;
    private Object[] deaths;
    private LinkedList<State> stateList;

    /**
     * creates a DataReader object
     * 
     * @param file
     *            the file that will be turned into the LinkedList of states
     * @throws FileNotFoundException
     *             is thrown if no file is given
     */
    public DataReader(String file) throws FileNotFoundException {
        stateList = readStates(file);
    }


    /**
     * 
     * @param fileName
     *            the file containing all the state information
     * @return a linked list containing all the states
     * @throws FileNotFoundException
     *             is thrown if no file is given
     */
    public LinkedList<State> readStates(String fileName)
        throws FileNotFoundException {
        if (fileName == null) {
            throw new FileNotFoundException("file is null");
        }
        LinkedList<State> tempList = new LinkedList<State>();
        Scanner myScanner = new Scanner(new File(fileName));
        while (myScanner.hasNextLine()) {
            String lineRead = myScanner.nextLine();
            String[] myData = lineRead.split(", *");
            for (int i = 0; i < 5; i++) {
                if (myData[i + 1] == "NA") {
                    cases[i] = "NA";
                }
                else {
                    cases[i] = Integer.valueOf(myData[i + 1]);
                }
            }
            for (int i = 0; i < 5; i++) {
                if (myData[i + 5] == "NA") {
                    deaths[i] = "NA";
                }
                else {
                    deaths[i] = Integer.valueOf(myData[i + 5]);
                }
            }
            State tempState = new State(myData[0], cases, deaths);
            tempList.add(tempState);
        }

        return tempList;
    }

}
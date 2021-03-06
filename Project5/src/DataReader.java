package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class DataReader {
    private int[] cases;
    private int[] deaths;
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
        GUIWindow window = new GUIWindow(stateList);
// SortAlpha sa = new SortAlpha();
// SortCFR sCFR = new SortCFR();
// for (int i = 0; i < stateList.size(); i++) {
// stateList.get(i).getListOfRaces().insertionSort(sa);
// System.out.println(stateList.get(i));
// System.out.print("=====");
// stateList.get(i).getListOfRaces().insertionSort(sCFR);
// System.out.println(stateList.get(i).toString().substring(2,
// stateList.get(i).toString().length()));
// System.out.println("=====");
//
// }

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
        cases = new int[5];
        deaths = new int[5];
        if (fileName == null) {
            throw new FileNotFoundException("file is null");
        }
        LinkedList<State> tempList = new LinkedList<State>();
        Scanner myScanner = new Scanner(new File(fileName));
        myScanner.nextLine();
        while (myScanner.hasNextLine()) {
            String lineRead = myScanner.nextLine();
            String[] myData = lineRead.split(", *");
            for (int i = 0; i < cases.length; i++) {
                if (myData[i + 1].equals("NA")) {
                    cases[i] = -1;
                }
                else {
                    cases[i] = Integer.valueOf(myData[i + 1]);
                }
            }
            for (int i = 0; i < deaths.length; i++) {
                if (myData[i + 6].equals("NA")) {
                    deaths[i] = -1;
                }
                else {

                    deaths[i] = Integer.valueOf(myData[i + 6]);
                }
            }
            State tempState = new State(myData[0], cases, deaths);
            tempList.add(tempState);
        }

        return tempList;
    }

}
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class DataReader {
    private int[] cases;
    private int[] deaths;
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
        GUIWindow window = new GUIWindow(stateList);
// SortAlpha sa = new SortAlpha();
// SortCFR sCFR = new SortCFR();
// for (int i = 0; i < stateList.size(); i++) {
// stateList.get(i).getListOfRaces().insertionSort(sa);
// System.out.println(stateList.get(i));
// System.out.print("=====");
// stateList.get(i).getListOfRaces().insertionSort(sCFR);
// System.out.println(stateList.get(i).toString().substring(2,
// stateList.get(i).toString().length()));
// System.out.println("=====");
//
// }

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
        cases = new int[5];
        deaths = new int[5];
        if (fileName == null) {
            throw new FileNotFoundException("file is null");
        }
        LinkedList<State> tempList = new LinkedList<State>();
        Scanner myScanner = new Scanner(new File(fileName));
        myScanner.nextLine();
        while (myScanner.hasNextLine()) {
            String lineRead = myScanner.nextLine();
            String[] myData = lineRead.split(", *");
            for (int i = 0; i < cases.length; i++) {
                if (myData[i + 1].equals("NA")) {
                    cases[i] = -1;
                }
                else {
                    cases[i] = Integer.valueOf(myData[i + 1]);
                }
            }
            for (int i = 0; i < deaths.length; i++) {
                if (myData[i + 6].equals("NA")) {
                    deaths[i] = -1;
                }
                else {

                    deaths[i] = Integer.valueOf(myData[i + 6]);
                }
            }
            State tempState = new State(myData[0], cases, deaths);
            tempList.add(tempState);
        }

        return tempList;
    }

}
package prj5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 11.18.2021
 *
 */
public class DataReader {
    private int[] cases;
    private int[] deaths;
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
        GUIWindow window = new GUIWindow(stateList);
// SortAlpha sa = new SortAlpha();
// SortCFR sCFR = new SortCFR();
// for (int i = 0; i < stateList.size(); i++) {
// stateList.get(i).getListOfRaces().insertionSort(sa);
// System.out.println(stateList.get(i));
// System.out.print("=====");
// stateList.get(i).getListOfRaces().insertionSort(sCFR);
// System.out.println(stateList.get(i).toString().substring(2,
// stateList.get(i).toString().length()));
// System.out.println("=====");
//
// }

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
        cases = new int[5];
        deaths = new int[5];
        if (fileName == null) {
            throw new FileNotFoundException("file is null");
        }
        LinkedList<State> tempList = new LinkedList<State>();
        Scanner myScanner = new Scanner(new File(fileName));
        myScanner.nextLine();
        while (myScanner.hasNextLine()) {
            String lineRead = myScanner.nextLine();
            String[] myData = lineRead.split(", *");
            for (int i = 0; i < cases.length; i++) {
                if (myData[i + 1].equals("NA")) {
                    cases[i] = -1;
                }
                else {
                    cases[i] = Integer.valueOf(myData[i + 1]);
                }
            }
            for (int i = 0; i < deaths.length; i++) {
                if (myData[i + 6].equals("NA")) {
                    deaths[i] = -1;
                }
                else {

                    deaths[i] = Integer.valueOf(myData[i + 6]);
                }
            }
            State tempState = new State(myData[0], cases, deaths);
            tempList.add(tempState);
        }

        return tempList;
    }

}

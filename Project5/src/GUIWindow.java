/**
 * 
 */
package prj5;

import cs2.Button;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;
import cs2.Shape;
import cs2.TextShape;
import cs2.SquareShape;
import list.AList;

/**
 * @author Sam Hartmann
 * @author Josh Sapirstein
 * @version 12.02.2021
 *
 */
public class GUIWindow {
    private Window window;
    private LinkedList<State> stateList;
    private LinkedList<Shape> shapeList;
    private Button sortAlpha;
    private Button quit;
    private Button sortCFR;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;
    private State currentState;
// private State[] states;

    /**
     * Constructor
     * 
     * @param dataReader
     *            The linkedList of states
     */
    public GUIWindow(LinkedList<State> list) {
        window = new Window();
        shapeList = new LinkedList<Shape>();
        window.setTitle("Space Colony Placement");
        stateList = list;
        // Initialize Buttons
        sortAlpha = new Button("Sort by Alpha");
        sortAlpha.onClick(this, "clickedSortAlpha");

        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");

        sortCFR = new Button("Sort by CFR");
        sortCFR.onClick(this, "clickedSortCFR");

        representDC = new Button("Represent DC");
        representDC.onClick(this, "clickedDC");

        representGA = new Button("Represent GA");
        representGA.onClick(this, "clickedGA");

        representMD = new Button("Represent MD");
        representMD.onClick(this, "clickedMD");

        representNC = new Button("Represent NC");
        representNC.onClick(this, "clickedNC");

        representTN = new Button("Represent TN");
        representTN.onClick(this, "clickedTN");

        representVA = new Button("Represent VA");
        representVA.onClick(this, "clickedVA");

        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);

        window.addButton(representDC, WindowSide.SOUTH);
        window.addButton(representGA, WindowSide.SOUTH);
        window.addButton(representMD, WindowSide.SOUTH);
        window.addButton(representNC, WindowSide.SOUTH);
        window.addButton(representTN, WindowSide.SOUTH);
        window.addButton(representVA, WindowSide.SOUTH);
        currentState = setCurrentState("DC");

    }


    /**
     * Displays the data for the state
     */
    public void displayData() {
        window.removeAllShapes();
        drawGraph(currentState);
    }


    /**
     * sorts the data in the state by alphabetizing the race names
     * 
     * @param button
     *            the button to sort the data in the state by alphabetizing the
     *            race names
     */
    public void clickedSortAlpha(Button button) {
        SortAlpha sortAlpha = new SortAlpha();
        currentState.getListOfRaces().insertionSort(sortAlpha);
        displayData();
    }


    /**
     * Quits the program
     * 
     * @param button
     *            the quit button
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * sorts the data in the state by the Case Fatality Ratio
     * 
     * @param button
     *            the sort by Case Fatality Ratio button
     */
    public void clickedSortCFR(Button button) {
        SortCFR sortCFR = new SortCFR();
        currentState.getListOfRaces().insertionSort(sortCFR);
        displayData();
    }


    /**
     * shows the data for DC
     * 
     * @param button
     *            the button to show the data for DC
     */
    public void clickedDC(Button button) {
        currentState = setCurrentState("DC");
        displayData();

    }


    /**
     * shows the data for Georgia
     * 
     * @param button
     *            the button to show the data for Georgia
     */
    public void clickedGA(Button button) {
        currentState = setCurrentState("GA");
    }


    /**
     * shows the data for Maryland
     * 
     * @param button
     *            the button to show the data for Maryland
     */
    public void clickedMD(Button button) {
        currentState = setCurrentState("MD");
    }


    /**
     * shows the data for Maryland
     * 
     * @param button
     *            the button to show the data for Maryland
     */
    public void clickedNC(Button button) {
        currentState = setCurrentState("NC");
    }


    /**
     * shows the data for Tennessee
     * 
     * @param button
     *            the button that shows the data for Tennessee
     */
    public void clickedTN(Button button) {
        currentState = setCurrentState("TN");
    }


    /**
     * shows the data for Virginia
     * 
     * @param button
     *            the button that shows the data for Virginia
     */
    public void clickedVA(Button button) {
        currentState = setCurrentState("VA");

    }


    private void update() {

    }


    private void updatePercentages(State state) {

    }


    private void updateNames(State state) {

    }


    private void drawGraph(State state) {
        int shapeX = 75;
        int shapeY = 50;
        for (int i = 0; i < state.getListOfRaces().size(); i++) {
            double cfr = state.calculateCFR(state.getListOfRaces().get(i)
                .getName());

            int barHeight = (int)(cfr * 100);
            Shape shape = new Shape(shapeX, shapeY, 20, barHeight);
            shape.setBackgroundColor(Color.BLUE);
            shape.setForegroundColor(Color.BLUE);

            shapeList.add(shape);
            shapeX = shapeX + 30;

        }
        for (int i = 0; i < shapeList.size(); i++) {
            if (shapeList.get(i).getHeight() < 0) {
                TextShape text = new TextShape(shapeList.get(i).getX(),
                    shapeList.get(i).getY(), "NA");
                window.addShape(text);
            }
            else {
                window.addShape(shapeList.get(i));
            }
        }
    }


    /**
     * sets the state we want to view
     * 
     * @param stateName
     *            the name of the state we want to view
     * @return the State we want to view
     */
    private State setCurrentState(String stateName) {
        if (stateName.length() > 0) {
            for (int i = 0; i < stateList.size(); i++) {
                if (stateName.equals(stateList.get(i).getName())) {
                    return stateList.get(i);
                }

            }
        }
        throw new IllegalArgumentException("State not found");
    }
}

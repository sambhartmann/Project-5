/**
 * 
 */
package prj5;

import cs2.Button;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Shape;
import cs2.TextShape;

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
    private int shapeX;
    private int shapeY;

    /**
     * Constructor
     * 
     * @param dataReader
     *            The linkedList of states
     */
    public GUIWindow(LinkedList<State> list) {
        shapeList = new LinkedList<Shape>();
        shapeX = 150;
        shapeY = 100;
        window = new Window();
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
        // Adds the buttons to the top of the window
        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);
        // Adds all the state buttons to the bottom of the window
        window.addButton(representDC, WindowSide.SOUTH);
        window.addButton(representGA, WindowSide.SOUTH);
        window.addButton(representMD, WindowSide.SOUTH);
        window.addButton(representNC, WindowSide.SOUTH);
        window.addButton(representTN, WindowSide.SOUTH);
        window.addButton(representVA, WindowSide.SOUTH);

        // Sets default currentState
        currentState = setCurrentState("DC");

    }


    /**
     * Displays the data for the state
     */
    public void displayData() {
        window.removeAllShapes();
        window.repaint();
        drawGraph();
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
        displayData();
    }


    /**
     * shows the data for Maryland
     * 
     * @param button
     *            the button to show the data for Maryland
     */
    public void clickedMD(Button button) {
        currentState = setCurrentState("MD");
        displayData();
    }


    /**
     * shows the data for Maryland
     * 
     * @param button
     *            the button to show the data for Maryland
     */
    public void clickedNC(Button button) {
        currentState = setCurrentState("NC");
        displayData();
    }


    /**
     * shows the data for Tennessee
     * 
     * @param button
     *            the button that shows the data for Tennessee
     */
    public void clickedTN(Button button) {
        currentState = setCurrentState("TN");
        displayData();
    }


    /**
     * shows the data for Virginia
     * 
     * @param button
     *            the button that shows the data for Virginia
     */
    public void clickedVA(Button button) {
        currentState = setCurrentState("VA");
        displayData();

    }


    /**
     * creates the cfr percentage text shape for each of the cfr graphs
     */
    private void updatePercentages() {
        DecimalFormat df = new DecimalFormat("0.#");
        for (int i = 0; i < shapeList.size(); i++) {
            double cfr = currentState.getListOfRaces().get(i).getCFR();
            String cfrText = df.format(cfr);
            if (cfr > 0.0) {
                TextShape cfrShape = new TextShape(shapeList.get(i).getX(),
                    shapeList.get(i).getY() - 40, cfrText + "%");
                window.addShape(cfrShape);
            }

        }
    }


    /**
     * Creates the names of the races for each of the cfr graphs
     */
    private void updateNames() {
        TextShape topname = new TextShape((window.getGraphPanelWidth() / 2)
            - 100, 20, currentState.getName() + "Case Fatality Ratios by Race");
        window.addShape(topname);
        for (int i = 0; i < shapeList.size(); i++) {
            String raceName = currentState.getListOfRaces().get(i).getName();
            TextShape name = new TextShape(shapeList.get(i).getX(), shapeList
                .get(i).getY() - 20, raceName);
            window.addShape(name);

        }
    }


    /**
     * Creates all the graphics for the window
     */
    private void drawGraph() {
        shapeX = 150;
        shapeList.clear();
        // Creates all the shapes and adds them to the list
        for (int i = 0; i < currentState.getListOfRaces().size(); i++) {
            double cfr = currentState.getListOfRaces().get(i).getCFR();
            int barHeight = (int)(cfr * 20);
            Shape shape = new Shape(shapeX, shapeY, 20, barHeight);
            shape.setBackgroundColor(Color.BLUE);
            shape.setForegroundColor(Color.BLUE);
            shapeList.add(shape);
            shapeX = shapeX + 100;

        }
        // adds the shapes to the windows, adds NA if CFR is NA
        for (int i = 0; i < shapeList.size(); i++) {
            if (shapeList.get(i).getHeight() < 0) {
                TextShape text = new TextShape(shapeList.get(i).getX(),
                    shapeList.get(i).getY(), "NA");
                window.addShape(text);
            }
            else {
                shapeList.get(i).setY(shapeList.get(i).getY());
                window.addShape(shapeList.get(i));

            }
        }
        // adds the names and percentages for each of the bars
        updateNames();
        updatePercentages();
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

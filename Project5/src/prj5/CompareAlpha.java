package prj5;

import java.util.Comparator;

public class CompareAlpha implements Comparator<State>
{ 
    /**
     * Compares the states alphabetically
     * @param s1 
     *         State
     * @param s2 
     *         State
     * @return int
     */
    @Override
    public int compare(State s1, State s2) 
    {
        return s1.getName().compareTo(s2.getName());
    }

}

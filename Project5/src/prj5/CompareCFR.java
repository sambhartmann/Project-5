package prj5;

import java.util.Comparator;

public class CompareCFR implements Comparator<State> 
{
    /**
     * Compares the States by CFR
     * @param s1
     *          State
     * @param s2 
     *          State
     */
    @Override
    public int compare(State s1, State s2) 
    {
        int value = 0;
        int score = 0;
        
        int arrLen = s1.RACES.length;
        
        for (int i = 0; i < arrLen; i++)
        {
            if (s1.calculateCFR(s1.RACES[i]) > s2.calculateCFR(s2.RACES[i]))
            {
                score++;
            }
            else if (s1.calculateCFR(s1.RACES[i]) < s2.calculateCFR(s2.RACES[i]))
            {
                score--;
            }
            else
            {
                score++;
                score--;
            }
        }
        
        if (score > 0)
        {
            value = 1;
        }
        else if (score < 0)
        {
            value = -1;
        }
        else
        {
            CompareAlpha comp = new CompareAlpha();
            value = comp.compare(s1, s2);
        }
        
        return value;
    }
}

package fa.dfa;

import java.util.HashMap;
import java.util.Map;

/**
 * This is the DFA state class which includes the characteristics
 * of each DFA state. The most notable method of this class is the
 * addTransition method which stores a map of the different
 * transitions for this state. 
 * 
 * @authors Jason Kuphaldt, Connor Jackson
 *
 */

public class DFAState extends fa.State {
    private boolean finalState;
    private boolean initialState;
    private Map<Character, DFAState> transitions;


    public DFAState(String name) {
        this.name = name;
        this.finalState = false;
        this.initialState = false;
        this.transitions = new HashMap<Character, DFAState>();
    }

    
    /** 
     * @param onSymb
     * @param toState
     * 
     * Accepts a character and a toState. A map is then
     * created that stores these values.
     */
    public void addTransition(char onSymb, DFAState toState) {
        transitions.put(onSymb, toState);
    }

    //Used to tell if a state is a start state or not
    public void setInitial() {
        this.initialState = true;
    }
    //used to tell if a state is a final state or not
    public void setFinal() {
        this.finalState = true;
    }

    
    /** 
     * @return boolean
     * returns true if this is a start state
     */
    public boolean checkInitial() {
        return this.initialState;
    }

    
    /** 
     * @return boolean
     * Retuns true if this state is a final state 
     */
    public boolean checkFinal() {
        return this.finalState;
    }

    
    /** 
     * @param getName(
     * @return Map<Character, DFAState>
     * Returns all of the transitions for this state 
     */
    public Map<Character, DFAState> getTransitions() {
        return this.transitions;
    }

    
    /** 
     * @return String
     * Returns the dfa state name.
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @param onSymb
     * @return DFAState
     * returns the transition for a specific character
     */
    public DFAState checkTransition(char onSymb) {
        return transitions.get(onSymb);
    }

}

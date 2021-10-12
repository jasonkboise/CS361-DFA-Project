package fa.dfa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import fa.State;

public class DFA implements DFAInterface{
    
    //Creates a set that contains all states
    private Set<DFAState> states;
    /* Creates a set that contains only the final states.
     * This way we can call finalStates.contains() to find if
     * a state is a final state. 
     */
    private Set<DFAState> finalStates;
    //Creates the set of characters in the alphabet.
    private Set<Character> alphabet;
    //Creates the start state 
    private DFAState startState;

    public DFA() {
        
        //Initializes all sets
        states = new HashSet<DFAState>();
        finalStates = new HashSet<DFAState>();
        alphabet = new HashSet<Character>();
        this.startState = null;
    }
    
    /* When addStartState is called then the start
     * state is created and it is also added to 
     * the list of states
     */   
    @Override
    public void addStartState(String name) {
        DFAState newState = new DFAState(name);
        newState.setInitial();
        startState = newState;
        states.add(newState);
        
    }
    
    /* Every time a state, start state, or final state is created
     * this method is used.
     */
    @Override
    public void addState(String name) {
        DFAState newState = new DFAState(name);
        states.add(newState);
        
    }
    
    //Used to add states as final states
    @Override
    public void addFinalState(String name) {
        DFAState newState = new DFAState(name);
        newState.setFinal();
        finalStates.add(newState);
        states.add(newState);
    }
    /* Iterates through all states until it hits from and to states
     * when it hits from state then the value is stored in from.
     * when it hits to state the value is stored in to.
     * Once it has both states it can then call from.addTransition(onSymb,to)
     * which adds the transition to the from state based off of the alphabet
     * Symbol.
     */
    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        alphabet.add(onSymb);
        Iterator<DFAState> stateIterator = states.iterator();
        DFAState from = null;
        DFAState to = null;
        while (stateIterator.hasNext()) {
            DFAState curr = stateIterator.next();
            if (curr.getName().equals(fromState)) {
                from = curr;
            }
            if (curr.getName().equals(toState)) {
                to = curr;
            }
        }
        from.addTransition(onSymb, to);
        
    }
    //returns all states in set
    @Override
    public Set<? extends State> getStates() {
        return states;
    }
    //returns all final states in set
    @Override
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }
    //returns start state. There will only ever be one 
    @Override
    public State getStartState() {
        return this.startState;
    }
    //Returns all the chars in the alphabet set
    @Override
    public Set<Character> getABC() {
        return this.alphabet;
    }
    //Uses the transition map data to initiate a transition 
    @Override
    public fa.dfa.DFAState getToState(DFAState from, char onSymb) {
        DFAState newState = from.checkTransition(onSymb);
        return newState;
    }
    
    /* Checks a string to see if it is accepted by the DFA.
     * checkAcc begins at start state and transitions
     * as each character of the string is read.
     * returns true if the final state that has been
     * transitioned into is a final state by using
     * finalstates.contains(checkAcc)
     */
    @Override
    public boolean accepts(String s) {
        DFAState checkAcc = this.startState;
        
        for (int i = 0; i < s.trim().length(); i ++) {
           checkAcc = checkAcc.checkTransition(s.charAt(i));
        }
        
        if (finalStates.contains(checkAcc))
            return true;
        
        return false;
    }

    /* Returns the 5 tuple for the FA.
     * This includes: 
     * The states set
     * The alphabet
     * The start State
     * The final States
     * And finally the Transition function
     */
    public String toString() {
        String output = "";
        output += "Q = " + this.states + " \n";
        output += "Sigma = " + this.getABC() + " \n";
        output += "delta = \n";
        output += "\t\t";
        Set<Character> abc = this.getABC();
        Iterator<Character> abcIter = abc.iterator();
        Set<DFAState> states = this.states;
        Iterator<DFAState> stateIter = states.iterator();

        for (int i = 0; i < this.getABC().size(); i++) {
            output += abcIter.next() + "\t";
        }
        output += "\n";

        abcIter = abc.iterator();

        for (int i = 0; i < this.states.size(); i++) {
            DFAState current = stateIter.next();
            output += "\t" + current + "\t";
            for (int j = 0; j < this.getABC().size(); j++) {
                output += current.checkTransition(abcIter.next()).getName() + "\t";
            }
            output += "\n";
            abcIter = abc.iterator();
        }

        output += "q0 = " + this.startState + "\n";
        output += "F = " + this.finalStates + " \n";


        return output;
    }
}

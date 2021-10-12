package fa.dfa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import fa.State;

/**
 * This is the DFA class which includes methods
 * that add the various states to the DFA and
 * categorizes them as final states, start state, 
 * as well as all states. Some notable methods
 * include the toString method which returns the
 * 5 tuple, the accepts method which tests whether
 * or not strings are legal, and various addState 
 * methods.
 *  
 * 
 * @authors Jason Kuphaldt, Connor Jackson
 *
 */
public class DFA implements DFAInterface{
    
    
    private Set<DFAState> states;
    private Set<DFAState> finalStates;
    private Set<Character> alphabet; 
    private DFAState startState;
    public DFA() {
        
        
        states = new HashSet<DFAState>();
        finalStates = new HashSet<DFAState>();
        alphabet = new HashSet<Character>();
        this.startState = null;
    }
      
    
    /** 
     * @param name is a string that newState is set to. 
     * Newstate is set to name. Newstate is then set as
     * start state and also added to the states set.
     * 
     */
    @Override
    public void addStartState(String name) {
        DFAState newState = new DFAState(name);
        newState.setInitial();
        startState = newState;
        states.add(newState);
        
    }
   
    
    /** 
     * @param name
     * newstate is set to name and then newstate
     * is added to the states set
     */
    @Override
    public void addState(String name) {
        DFAState newState = new DFAState(name);
        states.add(newState);
        
    }

    
    /** 
     * @param name
     * newState is set to name and then added to the
     * final states set as well as the states set.
     */
    @Override
    public void addFinalState(String name) {
        DFAState newState = new DFAState(name);
        newState.setFinal();
        finalStates.add(newState);
        states.add(newState);
    }
    
    
    /** 
     * @param fromState
     * @param onSymb
     * @param toState
     * 
     * onSymb is added to the alphabet set. 
     * An iterator is created and while we iterate through all states
     * we find the from and to states. Once those are found the 
     * from state gets a transition added into it using the addTransition
     * method. This adds a transition using the onsymb and tostate.
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
    
    
    /** 
     * @return Set<? extends State>
     * returns all of the states that are in the states set.
     */
    @Override
    public Set<? extends State> getStates() {
        return states;
    }
    
    
    /** 
     * @return Set<? extends State>
     * returns all of the states that are in 
     * the final states set.
     */
    @Override
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }
     
    
    /** 
     * @return State
     * returns the one and only start state.
     */
    @Override
    public State getStartState() {
        return this.startState;
    }
    
    
    /** 
     * @return Set<Character>
     * Returns all of the characters 
     * that exist in the alphabet set.
     */
    @Override
    public Set<Character> getABC() {
        return this.alphabet;
    }
    
    
    /** 
     * @param from
     * @param onSymb
     * @return DFAState
     * GetToState accepts a state and a transition symbol.
     * It then returns the state that is would transition to
     * based off of the onSymb.
     */
    @Override
    public fa.dfa.DFAState getToState(DFAState from, char onSymb) {
        DFAState newState = from.checkTransition(onSymb);
        return newState;
    }
 
    
    /** 
     * @param s
     * @return boolean
     * 
     * checkAcc is first set to the start state
     * a string is read and iterated through and
     * every cahr is used for a transition. 
     * Once the final character has been read and
     * the final transition has occured, checkAcc
     * is checked to see if it is a state that falls
     * in the final states set. If it is return true
     * if it is not return false.
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

    
    /** 
     * @return String
     * The toString method returns the 5 tuple for the DFA as a string
     * This includes:
     * 1: Set of states
     * 2: Alphabet set
     * 3: The transition function delta
     * 4: The start state
     * 5: Set of final states
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

package fa.dfa;

import java.util.HashSet;
import java.util.Set;
import fa.State;

public class DFA implements DFAInterface{

    private Set<DFAState> states;
    private Set<Character> alphabet;
    private DFAState startState;

    public DFA() {
        states = new HashSet<DFAState>();
        alphabet = new HashSet<Character>();
        this.startState = null;
    }
    @Override
    public void addStartState(String name) {
        DFAState newState = new DFAState(name);
        newState.setInitial();
        startState = newState;
        
    }
    @Override
    public void addState(String name) {
        
    }
    @Override
    public void addFinalState(String name) {
        DFAState newState = new DFAState(name);
        newState.setFinal();
        //add it to the list of other states
        states.add(newState);

    }
    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        alphabet.add(onSymb);
        
    }
    @Override
    public Set<? extends State> getStates() {
        return null;
    }
    @Override
    public Set<? extends State> getFinalStates() {
        return null;
    }
    @Override
    public State getStartState() {
        return this.startState;
    }
    @Override
    public Set<Character> getABC() {
        return null;
    }
    @Override
    public fa.dfa.DFAState getToState(DFAState from, char onSymb) {
        return null;
    }
    @Override
    public boolean accepts(String s) {
        return false;
    }
}

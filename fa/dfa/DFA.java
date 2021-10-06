package fa.dfa;

import java.util.HashSet;
import java.util.Set;
import fa.State;

public class DFA implements DFAInterface{

    private Set<DFAState> states;

    public DFA() {
        states = new HashSet<DFAState>();
    }
    @Override
    public void addStartState(String name) {

        
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
        return null;
    }
    @Override
    public Set<Character> getABC() {
        return null;
    }
    @Override
    public fa.dfa.State getToState(DFAState from, char onSymb) {
        return null;
    }
    @Override
    public boolean accepts(String s) {
        return false;
    }
}

package fa.dfa;

import java.util.Set;

import fa.State;

public class DFA implements DFAInterface{

    public DFA() {

    }
    @Override
    public void addStartState(String name) {
        // TODO Auto-generated method stub

        
    }
    @Override
    public void addState(String name) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void addFinalState(String name) {
        // TODO Auto-generated method stub
        DFAState newState = new DFAState(name);
        newState.setFinal();
        //add it to the list of other states

    }
    @Override
    public void addTransition(String fromState, char onSymb, String toState) {
        // TODO Auto-generated method stub
        
    }
    @Override
    public Set<? extends State> getStates() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Set<? extends State> getFinalStates() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public State getStartState() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public Set<Character> getABC() {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public fa.dfa.State getToState(DFAState from, char onSymb) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public boolean accepts(String s) {
        // TODO Auto-generated method stub
        return false;
    }
}

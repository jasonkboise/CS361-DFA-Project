package fa.dfa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import fa.State;

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

    @Override
    public void addStartState(String name) {
        DFAState newState = new DFAState(name);
        newState.setInitial();
        startState = newState;
        states.add(newState);
        
    }

    @Override
    public void addState(String name) {
        DFAState newState = new DFAState(name);
        states.add(newState);
        
    }

    @Override
    public void addFinalState(String name) {
        DFAState newState = new DFAState(name);
        newState.setFinal();
        finalStates.add(newState);
        states.add(newState);
    }

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

    @Override
    public Set<? extends State> getStates() {
        return states;
    }

    @Override
    public Set<? extends State> getFinalStates() {
        return finalStates;
    }

    @Override
    public State getStartState() {
        return this.startState;
    }

    @Override
    public Set<Character> getABC() {
        return this.alphabet;
    }

    @Override
    public fa.dfa.DFAState getToState(DFAState from, char onSymb) {
        DFAState newState = from.checkTransition(onSymb);
        return newState;
    }
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

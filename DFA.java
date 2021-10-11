package fa.dfa;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;
import fa.State;

public class DFA implements DFAInterface{

    private LinkedHashSet<DFAState> states;
    private LinkedHashSet<DFAState> finalStates;
    private HashSet<Character> alphabet;
    private DFAState startState;
    private DFAState checkAcc;
    private DFAState newState;

    public DFA() {
        states = new LinkedHashSet<DFAState>();
        finalStates = new LinkedHashSet<DFAState>();
        alphabet = new HashSet<Character>();
        
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
        DFAState from = startState;
        DFAState to = startState;
        while (stateIterator.hasNext()) {
            DFAState curr = stateIterator.next();
            if (curr.getName() == fromState && curr.getName() != null) {
                from = curr;
            }
            if (curr.getName() == toState && curr.getName() != null) {
                to = curr;
            }
        }

        if (to != null)
        
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
        if (from == null) {
            return null;
        }
        DFAState newState = from.checkTransition(onSymb);
        
        return newState;
    }
    
    public fa.dfa.DFAState getDfaStartState() {
        
        return startState;
    }

    @Override
    public boolean accepts(String s) {
        checkAcc = this.startState;
        
        for (int i = 0; i < s.trim().length(); i ++) {
           checkAcc = checkAcc.checkTransition(s.charAt(i));
        }
        
        if (finalStates.contains(checkAcc))
            return true;

        
        
        return false;
    }

   
}

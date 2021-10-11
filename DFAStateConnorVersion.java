package fa.dfa;

import java.util.HashMap;
import java.util.Map;

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

    public void addTransition(char onSymb, DFAState toState) {
        transitions.put(onSymb, toState);
    }

    public void setInitial() {
        this.initialState = true;
    }

    public void setFinal() {
        this.finalState = true;
    }

    public boolean checkInitial() {
        return this.initialState;
    }

    public boolean checkFinal() {
        return this.finalState;
    }

    public String getName() {
        return this.name;
    }

    public DFAState checkTransition(char onSymb) {
        return transitions.get(onSymb);
    }

}

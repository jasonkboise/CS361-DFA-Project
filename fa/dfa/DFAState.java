package fa.dfa;

import java.util.HashSet;
import java.util.Set;

public class DFAState extends fa.State {
    private boolean finalState;
    private boolean initialState;
    private Set<DFAState> transitions;


    public DFAState(String name) {
        this.name = name;
        this.finalState = false;
        this.initialState = false;
        this.transitions = new HashSet<DFAState>();
    }

    public void addTransition(DFAState transition) {
        transitions.add(transition);
    }

    public Set<DFAState> getTransitions() {
        return null;
    }

    public void setInitial() {
        this.initialState = true;
    }

    public void setFinal() {
        this.finalState = true;
    }

    public boolean checkTransition(DFAState check) {
        if (transitions.contains(check)) {
            return true;
        }
        else {
            return false;
        }
    }

}

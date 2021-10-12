package fa.dfa;

public class test {
    public static void main(String[] args) {
        System.out.println("test baldskfajdslkafj");
        DFA dfa = new DFA();
        

        
        

        dfa.addStartState("a");
        dfa.addFinalState("b");
        dfa.addTransition("a", '1', "b");
        
        dfa.addTransition("a", '0', "a");
        dfa.addTransition("b", '1', "b");
        dfa.addTransition("b", '0', "a");

        
        if (dfa.accepts("1000000100000001")) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        } 
        

        

        
    }

}


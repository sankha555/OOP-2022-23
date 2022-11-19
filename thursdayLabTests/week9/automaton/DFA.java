// Remove public in hackerrank submission
public class DFA implements Automaton {
    private final Map<State, Map<Character, State>> transitionFunction = new HashMap<>();
    private final State startState;
    private final List<State> acceptStates;
    private final String alphabet;

    public DFA(State[] states, char[] inputAlphabet, List<Edge> transitions, State startState) {
        this.startState = startState;
        alphabet = new String(inputAlphabet);
        this.acceptStates = new ArrayList<>();
        for (State state : states) {
            if (state.isAcceptState()) {
                acceptStates.add(state);
            }
            transitionFunction.put(state, new HashMap<>());
        }
        for (Edge transition : transitions) {
            if (alphabet.indexOf(transition.getOn()) == -1) {
                throw new IllegalArgumentException("Illegal transition for DFA; cannot construct it!");
            }
            transitionFunction.get(transition.getFrom()).put(transition.getOn(), transition.getTo());
        }
    }

    @Override
    public void simulate(String input) {
        State current = startState;
        System.out.print(current);
        for (int i = 0; i < input.length(); i++) {
            char in = input.charAt(i);
            if (alphabet.indexOf(in) == -1) {
                throw new IllegalArgumentException("\nIllegal input character " + in  + "; DFA dies!" );
            }
            State next = transitionFunction.get(current).get(in);
            System.out.print(" on " + in + " --> " + next);
            current = next;
        }

        if (current.isAcceptState()) {
            System.out.println("\nDFA accepted the string " + input);
        } else {
            System.out.println("\nDFA rejected the string " + input);
        }
    }

    @Override
    public List<State> getAcceptStates() {
        return acceptStates;
    }

    public Map<State, Map<Character, State>> getTransitionFunction() {
        return transitionFunction;
    }

    public State getStartState() {
        return startState;
    }

    public String getAlphabet() {
        return alphabet;
    }
}

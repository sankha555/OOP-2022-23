
import java.util.List;
import java.util.Map;
// Remove public in hackerrank submission
public class NFA implements Automaton {
    public NFA() {
        throw new UnsupportedOperationException("No time to implement NFAs");
    }

    @Override
    public void simulate(String input) {
    }

    @Override
    public List<State> getAcceptStates() {
        return null;
    }

    @Override
    public State getStartState() {
        return null;
    }

    @Override
    public String getAlphabet() {
        return null;
    }

    public Map<State, Map<Character, List<State>>> getTransitionFunction() {
        return null;
    }
}

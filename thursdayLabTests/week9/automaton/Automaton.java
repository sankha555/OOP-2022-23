import java.util.List;
// Remove public in hackerrank submission
public interface Automaton {
    void simulate(String input);

    List<State> getAcceptStates();

    State getStartState();

    String getAlphabet();
}

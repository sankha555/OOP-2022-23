
import java.util.ArrayList;
import java.util.List;
// Remove public in hackerrank submission
public class DFATester {
    public static void main(String[] args) {
        State q0 = new State(0, false);
        State q1 = new State(1, false);
        State q2 = new State(2, false);
        State q3 = new State(3, true);
        List<Edge> transitions = new ArrayList<>();
        transitions.add(new Edge(q0, 'a', q1));
        transitions.add(new Edge(q0, 'b', q0));
        transitions.add(new Edge(q1, 'b', q0));
        transitions.add(new Edge(q1, 'a', q2));
        transitions.add(new Edge(q2, 'a', q2));
        transitions.add(new Edge(q2, 'b', q3));
        transitions.add(new Edge(q3, 'a', q3));
        transitions.add(new Edge(q3, 'b', q3));

        Automaton dfaAABSubstring = new DFA(new State[]{q0, q1, q2, q3}, new char[]{'a', 'b'}, transitions, q0);
        dfaAABSubstring.simulate("aab");
        dfaAABSubstring.simulate("aaba");
        dfaAABSubstring.simulate("ab");
        dfaAABSubstring.simulate("abbbbbaaa");
    }
}

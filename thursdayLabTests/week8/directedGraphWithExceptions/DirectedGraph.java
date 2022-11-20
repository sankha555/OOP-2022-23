
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DirectedGraph {
    private final int V;
    private final List<Set<Integer>> adjList;
    private int E;

    /**
     * @param V the number of vertices/nodes in the graph labeled 0 to V - 1
     * @throws IllegalArgumentException if V passed is less than or equal to 0
     */
    public DirectedGraph(int V) {
        if (V <= 0) {
            throw new IllegalArgumentException("Number of vertices (" + V + ") must be greater than 0");
        }
        this.V = V;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new HashSet<>());
        }
    }

    /**
     * Adds the edge "from->to" to the adjacency list of the graph
     *
     * @param from the tail of the edge
     * @param to   the head of the edge
     * @throws IllegalArgumentException if from and to are invalid nodes (i.e. < 0 or >= V)
     */
    public void addEdge(int from, int to) {
        if (from < 0 || from >= V || to < 0 || to >= V) {
            String message = "from (" + from + ") and to " + "(" + to + ") must be in range of valid nodes!";
            throw new IllegalArgumentException(message);
        }
        if (!adjList.get(from).contains(to)) {
            ++E;
        }
        adjList.get(from).add(to);
    }

    public int getNumberOfVertices() {
        return V;
    }

    public int getNumberOfEdges() {
        return E;
    }

    /**
     * Returns a string representation of this graph such that:
     * Line 1 contains the number of vertices
     * Line 2 contains the number of edges
     * Line 3 contains Node 0 followed by a colon and its adjacency list
     * Line 4 contains Node 1 followed by a colon and its adjacency list
     * and so in till the last node
     *
     * @return a string representation
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(V).append(" vertices ").append("\n");
        stringBuilder.append(E).append(" edges ").append("\n");
        for (int i = 0; i < V; i++) {
            stringBuilder.append(i).append(" - ").append(adjList.get(i).toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}

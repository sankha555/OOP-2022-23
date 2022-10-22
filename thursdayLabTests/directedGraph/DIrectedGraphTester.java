// Remove public in hackerrank submission
public class DirectedGraphTester {
    public static void main(String[] args) {
        DirectedGraph graph = new DirectedGraph(5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(1, 4);
        System.out.println(graph);
    }
}

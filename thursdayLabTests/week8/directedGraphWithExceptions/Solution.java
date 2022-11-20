import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        try {
            DirectedGraph directedGraph = new DirectedGraph(V);
            for (int i = 0; i < E; i++) {
                directedGraph.addEdge(sc.nextInt(), sc.nextInt());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Terminating...");
        }
    }
}

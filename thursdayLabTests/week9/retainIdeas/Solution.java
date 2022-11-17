
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    private static class Thought implements Comparable<Thought> {
        private final String contents;
        private final int createdAt;
        private final int worth;

        public Thought(String contents, int createdAt, int worth) {
            this.contents = contents;
            this.createdAt = createdAt;
            this.worth = worth;
        }

        @Override
        public int compareTo(Thought o) {
            return this.createdAt - o.createdAt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Thought> priorityQueue = new PriorityQueue<>(new Comparator<Thought>() {
            @Override
            public int compare(Thought o1, Thought o2) {
                return o1.worth - o2.worth;
            }
        });
        int N = Integer.parseInt(sc.nextLine());
        int K = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < K; i++) {
            String[] s = sc.nextLine().split(",");
            Thought thought = new Thought(s[0], Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            priorityQueue.offer(thought);
        }
        for (int i = 0; i < N - K; i++) {
            String[] s = sc.nextLine().split(",");
            Thought thought = new Thought(s[0], Integer.parseInt(s[1]),Integer.parseInt(s[2]));
            if (thought.worth >= priorityQueue.peek().worth) {
                priorityQueue.poll();
                priorityQueue.offer(thought);
            }
        }
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll().contents);
        }
    }
}

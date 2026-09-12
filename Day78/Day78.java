/*Problem Statement
Given weighted undirected graph, compute total weight of Minimum Spanning Tree using Prim’s algorithm.

Input Format
n m
u v w
...

Output Format
Total weight of MST.

Sample Input
4 5
1 2 3
1 3 5
2 3 1
2 4 4
3 4 2

Sample Output
6

Explanation
One possible MST edges: (2-3), (3-4), (1-2) */
import java.util.*;

class Day78 {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected weighted graph
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.weight, b.weight)
        );

        // Start from node 1
        pq.add(new Pair(1, 0));

        long mstWeight = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            int weight = current.weight;

            // Already included in MST
            if (visited[node]) {
                continue;
            }

            visited[node] = true;
            mstWeight += weight;

            // Add all edges to unvisited neighbors
            for (Pair neighbor : graph.get(node)) {
                if (!visited[neighbor.node]) {
                    pq.add(neighbor);
                }
            }
        }

        System.out.println(mstWeight);

        sc.close();
    }
}
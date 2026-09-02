import java.util.*;

class Day68 {

    static void topologicalSort(int n, int[][] edges) {

        // Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Calculate in-degree
        int[] indegree = new int[n];

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            indegree[v]++;
        }

        // Add vertices with in-degree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Topological ordering
        ArrayList<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();
            result.add(node);

            // Remove node's outgoing edges
            for (int neighbor : graph.get(node)) {

                indegree[neighbor]--;

                // If in-degree becomes 0
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // If all vertices are processed, topological sort exists
        if (result.size() != n) {
            System.out.println("Cycle exists - Topological ordering not possible");
        } else {
            System.out.println("Topological Order: " + result);
        }
    }

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        topologicalSort(n, edges);
    }
}
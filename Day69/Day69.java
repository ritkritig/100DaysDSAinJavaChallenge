/*Problem: Given weighted graph with non-negative edges, compute shortest path from source using priority queue. */
import java.util.*;

class Day69 {

    static int[] dijkstra(int n, int[][] edges, int source) {

        // Adjacency list
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            graph.get(u).add(new int[]{v, weight});

            // For undirected graph
            graph.get(v).add(new int[]{u, weight});
        }

        // Distance array
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[source] = 0;

        // Min Heap: {node, distance}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{source, 0});

        while (!pq.isEmpty()) {

            int[] current = pq.poll();

            int node = current[0];
            int distance = current[1];

            // Ignore outdated distance
            if (distance > dist[node]) {
                continue;
            }

            // Visit neighbors
            for (int[] edge : graph.get(node)) {

                int neighbor = edge[0];
                int weight = edge[1];

                int newDistance = distance + weight;

                // Relaxation
                if (newDistance < dist[neighbor]) {

                    dist[neighbor] = newDistance;

                    pq.offer(new int[]{
                        neighbor,
                        newDistance
                    });
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        int n = 5;

        int[][] edges = {
            {0, 1, 2},
            {0, 2, 4},
            {1, 2, 1},
            {1, 3, 7},
            {2, 4, 3},
            {3, 4, 1}
        };

        int source = 0;

        int[] result = dijkstra(n, edges, source);

        System.out.println(Arrays.toString(result));
    }
}
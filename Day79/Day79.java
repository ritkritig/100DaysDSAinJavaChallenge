import java.util.*;

class Day79 {

    static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
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

        // Build graph
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w)); // remove if graph is directed
        }

        int source = sc.nextInt();

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.distance, b.distance)
        );

        dist[source] = 0;
        pq.add(new Pair(source, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();

            int node = current.node;
            int distance = current.distance;

            // Ignore outdated entries
            if (distance != dist[node]) {
                continue;
            }

            for (Pair neighbor : graph.get(node)) {
                int nextNode = neighbor.node;
                int weight = neighbor.distance;

                if (dist[node] + weight < dist[nextNode]) {
                    dist[nextNode] = dist[node] + weight;
                    pq.add(new Pair(nextNode, dist[nextNode]));
                }
            }
        }

        // Print distances
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.print("-1");
            } else {
                System.out.print(dist[i]);
            }

            if (i < n) {
                System.out.print(" ");
            }
        }

        System.out.println();
        sc.close();
    }
}
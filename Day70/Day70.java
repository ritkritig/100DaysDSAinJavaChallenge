/*Problem: Compute shortest path from source and detect negative weight cycles using Bellman-Ford.

Input:
- n vertices
- m edges (u,v,w)

Output:
- Shortest distances OR NEGATIVE CYCLE */
import java.util.*;

public class Day70 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] edges = new int[m][3];

        for (int i = 0; i < m; i++) {
            edges[i][0] = sc.nextInt(); // u
            edges[i][1] = sc.nextInt(); // v
            edges[i][2] = sc.nextInt(); // w
        }

        int src = sc.nextInt();

        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n];

        Arrays.fill(dist, INF);
        dist[src] = 0;

        // Relax all edges n-1 times
        for (int i = 0; i < n - 1; i++) {

            boolean updated = false;

            for (int[] edge : edges) {

                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (dist[u] != INF &&
                    dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                    updated = true;
                }
            }

            // Optimization: stop if nothing changed
            if (!updated) {
                break;
            }
        }

        // Check for negative weight cycle
        boolean negativeCycle = false;

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (dist[u] != INF &&
                dist[u] + w < dist[v]) {

                negativeCycle = true;
                break;
            }
        }

        if (negativeCycle) {
            System.out.println("NEGATIVE CYCLE");
        } else {

            for (int i = 0; i < n; i++) {

                if (dist[i] == INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i] + " ");
                }
            }
        }

        sc.close();
    }
}
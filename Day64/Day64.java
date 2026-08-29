/*Problem: Perform BFS from a given source using queue.

Input:
- n
- adjacency list
- source s

Output:
- BFS traversal order*/
import java.util.*;

class Day64 {

    static void bfs(int source, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.offer(source);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            System.out.print(vertex + " ");

            for (int neighbor : graph.get(vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Input adjacency list
        for (int i = 0; i < n; i++) {
            int k = sc.nextInt();

            for (int j = 0; j < k; j++) {
                graph.get(i).add(sc.nextInt());
            }
        }

        int s = sc.nextInt();

        boolean[] visited = new boolean[n];

        bfs(s, graph, visited);

        sc.close();
    }
}
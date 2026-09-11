/*Problem Statement
Using BFS or DFS, check if the entire graph is connected.

Input Format
n m
edges

Output Format
CONNECTED
NOT CONNECTED

Sample Input
4 2
1 2
3 4

Sample Output
NOT CONNECTED */
import java.util.*;

class Day77 {

    static void dfs(int node, ArrayList<ArrayList<Integer>> graph,
                    boolean[] visited) {

        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited = new boolean[n + 1];

        // Start DFS from node 1
        dfs(1, graph, visited);

        // Check if every node was visited
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                System.out.println("NOT CONNECTED");
                return;
            }
        }

        System.out.println("CONNECTED");

        sc.close();
    }
}
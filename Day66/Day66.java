import java.util.*;

class Day66 {

    public static boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj) {

        boolean[] visited = new boolean[V];
        boolean[] recursionStack = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, recursionStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                       boolean[] visited, boolean[] recursionStack) {

        visited[node] = true;
        recursionStack[node] = true;

        for (int neighbour : adj.get(node)) {

            // If neighbour is not visited, visit it
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, recursionStack)) {
                    return true;
                }
            }

            // Neighbour is already in current DFS path
            else if (recursionStack[neighbour]) {
                return true;
            }
        }

        // Remove node from current recursion path
        recursionStack[node] = false;

        return false;
    }
}
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Day53 {

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (i < arr.length && arr[i] != -1) {
                current.left = new Node(arr[i]);
                queue.add(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != -1) {
                current.right = new Node(arr[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    static void verticalOrder(Node root) {

        if (root == null) {
            return;
        }

        // horizontal distance -> nodes
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        // Queue stores node and its horizontal distance
        Queue<Node> nodeQueue = new LinkedList<>();
        Queue<Integer> distanceQueue = new LinkedList<>();

        nodeQueue.add(root);
        distanceQueue.add(0);

        while (!nodeQueue.isEmpty()) {

            Node current = nodeQueue.poll();
            int hd = distanceQueue.poll();

            map.putIfAbsent(hd, new ArrayList<>());
            map.get(hd).add(current.data);

            if (current.left != null) {
                nodeQueue.add(current.left);
                distanceQueue.add(hd - 1);
            }

            if (current.right != null) {
                nodeQueue.add(current.right);
                distanceQueue.add(hd + 1);
            }
        }

        // Print from leftmost column to rightmost
        for (List<Integer> column : map.values()) {
            for (int value : column) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Node root = buildTree(arr);

        verticalOrder(root);

        sc.close();
    }
}
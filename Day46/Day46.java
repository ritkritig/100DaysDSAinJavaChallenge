import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Day46 {

    static Node buildTree(int[] arr) {
        if (arr.length == 0 || arr[0] == -1)
            return null;

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

    static void levelOrder(Node root) {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print(current.data + " ");

            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
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

        levelOrder(root);

        sc.close();
    }
}
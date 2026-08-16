/*Problem: BST Insert

Implement the solution for this problem.

        Input:
        - Input specifications

Output:
        - Output specifications*/
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Day49 {

    static Node insert(Node root, int value) {

        if (root == null) {
            return new Node(value);
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node root = null;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();

            if (value != -1) {
                root = insert(root, value);
            }
        }

        int value = sc.nextInt();

        root = insert(root, value);

        inorder(root);

        sc.close();
    }
}
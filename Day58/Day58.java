import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Day58 {

    static int preIndex = 0;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static Node buildTree(int[] preorder, int left, int right) {

        if (left > right) {
            return null;
        }

        // Preorder ka current element root hai
        int value = preorder[preIndex++];
        Node root = new Node(value);

        // Inorder mein root ka index
        int mid = map.get(value);

        // Left subtree
        root.left = buildTree(preorder, left, mid - 1);

        // Right subtree
        root.right = buildTree(preorder, mid + 1, right);

        return root;
    }

    static void postorder(Node root) {

        if (root == null) {
            return;
        }

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] preorder = new int[n];
        int[] inorder = new int[n];

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            map.put(inorder[i], i);
        }

        Node root = buildTree(preorder, 0, n - 1);

        postorder(root);

        sc.close();
    }
}
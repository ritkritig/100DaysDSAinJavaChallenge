import java.util.*;

class Day59 {

    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static int postIndex;
    static HashMap<Integer, Integer> map = new HashMap<>();

    static Node buildTree(int[] inorder, int[] postorder, int start, int end) {

        if (start > end) {
            return null;
        }

        // Last element of postorder is the root
        int value = postorder[postIndex--];

        Node root = new Node(value);

        // Find root position in inorder
        int rootIndex = map.get(value);

        // Build right subtree first
        root.right = buildTree(inorder, postorder, rootIndex + 1, end);

        // Build left subtree
        root.left = buildTree(inorder, postorder, start, rootIndex - 1);

        return root;
    }

    static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] inorder = new int[n];
        int[] postorder = new int[n];

        // Read inorder
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
            map.put(inorder[i], i);
        }

        // Read postorder
        for (int i = 0; i < n; i++) {
            postorder[i] = sc.nextInt();
        }

        postIndex = n - 1;

        Node root = buildTree(inorder, postorder, 0, n - 1);

        preorder(root);
    }
}
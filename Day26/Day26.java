/*Problem: Doubly Linked List Insertion and Traversal - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n
- Second line: n space-separated integers

Output:
- Print the linked list elements in forward order, space-separated*/
import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next, ListNode prev) { this.val = val; this.next = next; this.prev = prev;}
}
class Solution {
    public void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " " : ""));
            curr = curr.next;
        }
        System.out.println();
    }
}
public class Day26 {
    private static ListNode createList(Scanner sc, int size) {
        if (size <= 0) return null;

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < size; i++) {
            ListNode newNode = new ListNode(sc.nextInt());
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.prev = tail;
                tail.next = newNode;
                tail = newNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            ListNode head = createList(sc, n);
            Solution sol = new Solution();
            sol.traverse(head);
        }
        sc.close();
    }
}
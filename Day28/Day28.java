/* Problem: Circular Linked List Creation and Traversal - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n
- Second line: n space-separated integers

Output:
- Print the circular linked list elements starting from head, space-separated
*/
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day28 {
    static void tr(ListNode head) {
        if (head == null) return;

        ListNode curr = head;
        do {
            System.out.print(curr.val + " ");
            curr = curr.next;
        } while (curr != head);

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;

        int n = sc.nextInt();
        if (n <= 0) return;

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            ListNode newNode = new ListNode(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        if (tail != null) {
            tail.next = head;
        }
        tr(head);

        sc.close();
    }
}
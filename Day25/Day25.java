/*Problem: Count Occurrences of an Element in Linked List - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n (number of nodes)
- Second line: n space-separated integers (linked list elements)
- Third line: integer key (element to be counted)

Output:
- Print the number of times the key appears in the linked list*/
import java.util.Scanner;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public int countElements(ListNode head, int val) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                count++;
            }
            curr = curr.next;
        }
        return count;
    }
}
public class Day25 {
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
            int m = sc.nextInt();
            Solution sol = new Solution();
            int count = sol.countElements(head, m);
            System.out.println(count);
        }
        sc.close();
    }
}
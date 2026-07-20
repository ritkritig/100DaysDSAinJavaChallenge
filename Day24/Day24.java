/*Problem: Delete First Occurrence of a Key - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n
- Second line: n space-separated integers
- Third line: integer key

Output:
- Print the linked list elements after deletion, space-separated*/
import java.util.Scanner;
class ListNode {
int val;
ListNode next;
 ListNode() {}
   ListNode(int val) { this.val = val; }
 ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            if (curr.val == val) {
                prev.next = curr.next;
                break;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }

        return dummy.next;
    }
    public void traverse(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println();
    }
}
public class Day24 {
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
            ListNode newlist = sol.removeElements(head, m);
            sol.traverse(newlist);
        }
        sc.close();
    }
}
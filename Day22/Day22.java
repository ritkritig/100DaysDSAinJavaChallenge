/*Problem: Count Nodes in Linked List

Input:
- First line: integer n
- Second line: n space-separated integers

Output:
- Print the result*/
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void traverse(ListNode head) {
        ListNode curr = head;
        int count = 0;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
            count++;
        }
        System.out.println();
        System.out.println(count);
    }
}

public class Day22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            ListNode newNode = new ListNode(val);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Solution sol = new Solution();
        sol.traverse(head);

        sc.close();
    }
}
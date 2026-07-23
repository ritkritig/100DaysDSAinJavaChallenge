/*Problem: Find Intersection Point of Two Linked Lists - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n
- Second line: n space-separated integers (first list)
- Third line: integer m
- Fourth line: m space-separated integers (second list)

Output:
- Print value of intersection node or 'No Intersection'
*/
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public void findIntersection(ListNode head1, ListNode head2) {
        Set<Integer> visited = new HashSet<>();
        ListNode curr = head1;
        while (curr != null) {
            visited.add(curr.val);
            curr = curr.next;
        }
        curr = head2;
        while (curr != null) {
            if (visited.contains(curr.val)) {
                System.out.println(curr.val);
                return;
            }
            curr = curr.next;
        }
        System.out.println("No Intersection");
    }
}

public class Day27 {
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
            ListNode head1 = createList(sc, n);

            if (sc.hasNextInt()) {
                int m = sc.nextInt();
                ListNode head2 = createList(sc, m);

                Solution sol = new Solution();
                sol.findIntersection(head1, head2);
            }
        }
        sc.close();
    }
}
/*Problem: Circular Queue Using Array - Implement using linked list with dynamic memory allocation.

Input:
- First line: integer n (number of elements to enqueue)
- Second line: n space-separated integers
- Third line: integer m (number of dequeue operations)

Output:
- Print queue elements from front to rear after operations, space-separated*/
import java.util.Scanner;

public class Day36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] queue = new int[n];

        for (int i = 0; i < n; i++) {
            queue[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int front = 0;
        int rear = n - 1;

        for (int i = 0; i < m; i++) {
            int temp = queue[front];
            front = (front + 1) % n;
            rear = (rear + 1) % n;
            queue[rear] = temp;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(queue[(front + i) % n]);
            if (i != n - 1)
                System.out.print(" ");
        }

        sc.close();
    }
}
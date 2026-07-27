/*Problem: Implement a stack data structure using an array with the following operations: push, pop, and display.

Input:
- First line: integer n (number of operations)
- Next n lines: operation type and value (if applicable)
  - 1 value: push value
  - 2: pop
  - 3: display
*/
import java.util.Scanner;
class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.top = -1;
    }
    public void push(int value) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top] = value;
    }
    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stack[top--]);
        }
    }
    public void display() {
        if (top == -1) {
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + (i == 0 ? "" : " "));
        }
        System.out.println();
    }
}
public class Day31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        ArrayStack stack = new ArrayStack(n);

        for (int i = 0; i < n; i++) {
            int op = sc.nextInt();

            if (op == 1) {
                int val = sc.nextInt();
                stack.push(val);
            } else if (op == 2) {
                stack.pop();
            } else if (op == 3) {
                stack.display();
            }
        }

        sc.close();
    }
}

/*Problem: Implement push and pop operations on a stack and verify stack operations.

Input:
- First line: integer n
- Second line: n integers to push
- Third line: integer m (number of pops)

Output:
- Print remaining stack elements from top to bottom*/
import java.util.Scanner;
import java.util.Stack;

class CustomStack {
    private Stack<Integer> stack;

    public CustomStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
        }
    }

    public void display() {
        if (stack.isEmpty()) {
            return;
        }

        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + (i == 0 ? "" : " "));
        }
        System.out.println();
    }
}

public class Day32 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
        CustomStack stack = new CustomStack();

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        if (sc.hasNextInt()) {
            int m = sc.nextInt();

            for (int i = 0; i < m; i++) {
                stack.pop();
            }
        }

        stack.display();

        sc.close();
    }
}
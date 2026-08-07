import java.util.*;

public class Day42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        while (!stack.isEmpty()) {
            queue.offer(stack.pop());
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll());
            if (!queue.isEmpty())
                System.out.print(" ");
        }

        sc.close();
    }
}
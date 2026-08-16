import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Day41 {

    static Node front = null;
    static Node rear = null;

    static void enqueue(int x) {
        Node newNode = new Node(x);

        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue
    static int dequeue() {
        if (front == null)
            return -1;

        int val = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return val;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String op = sc.next();

            if (op.equals("enqueue")) {
                int x = sc.nextInt();
                enqueue(x);
            } else if (op.equals("dequeue")) {
                System.out.println(dequeue());
            }
        }

        sc.close();
    }
}
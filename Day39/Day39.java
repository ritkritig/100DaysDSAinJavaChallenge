/*Problem Statement:
        Implement a Min Heap using an array where the smallest element is always at the root.

        Supported Operations:
        - insert x
        - extractMin
        - peek

        Input Format:
        - First line contains integer N
        - Next N lines contain heap operations

        Output Format:
        - Print results of extractMin and peek
        - Print -1 if operation cannot be performed*/
import java.util.Scanner;

public class Day39 {
    static int[] heap = new int[1000];
    static int size = 0;

    static void insert(int val) {
        heap[size] = val;
        int i = size;
        size++;

        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap[parent] > heap[i]) {
                int temp = heap[parent];
                heap[parent] = heap[i];
                heap[i] = temp;
                i = parent;
            } else {
                break;
            }
        }
    }
    static int peek() {
        if (size == 0)
            return -1;
        return heap[0];
    }

    // Remove and return minimum element
    static int extractMin() {
        if (size == 0)
            return -1;

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        int i = 0;

        while (true) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap[left] < heap[smallest])
                smallest = left;

            if (right < size && heap[right] < heap[smallest])
                smallest = right;

            if (smallest != i) {
                int temp = heap[i];
                heap[i] = heap[smallest];
                heap[smallest] = temp;
                i = smallest;
            } else {
                break;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String op = sc.next();

            if (op.equals("insert")) {
                int x = sc.nextInt();
                insert(x);
            } else if (op.equals("peek")) {
                System.out.println(peek());
            } else if (op.equals("extractMin")) {
                System.out.println(extractMin());
            }
        }

        sc.close();
    }
}
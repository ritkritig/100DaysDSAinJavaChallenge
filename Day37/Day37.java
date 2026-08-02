/*Problem Statement:
Implement a Priority Queue using an array. An element with smaller value has higher priority.

Supported Operations:
- insert x
- delete
- peek*/
import java.util.Scanner;

    public class Day37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        int[] pq = new int[1000];
        int size = 0;

        for (int i = 0; i < N; i++) {
            String[] input = sc.nextLine().split(" ");

            if (input[0].equals("insert")) {
                int x = Integer.parseInt(input[1]);

                pq[size] = x;
                int j = size;

                while (j > 0 && pq[j] < pq[j - 1]) {
                    int temp = pq[j];
                    pq[j] = pq[j - 1];
                    pq[j - 1] = temp;
                    j--;
                }
                size++;
            }

            else if (input[0].equals("delete")) {
                if (size == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(pq[0]);
                    for (int j = 0; j < size - 1; j++) {
                        pq[j] = pq[j + 1];
                    }
                    size--;
                }
            }

            else if (input[0].equals("peek")) {
                if (size == 0) {
                    System.out.println(-1);
                } else {
                    System.out.println(pq[0]);
                }
            }
        }

        sc.close();
    }
}
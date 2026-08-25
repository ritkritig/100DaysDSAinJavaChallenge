import java.util.*;

class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean isMinHeap = true;

        for (int i = 0; i < n; i++) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // Check left child
            if (left < n && arr[i] > arr[left]) {
                isMinHeap = false;
                break;
            }

            // Check right child
            if (right < n && arr[i] > arr[right]) {
                isMinHeap = false;
                break;
            }
        }

        if (isMinHeap) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
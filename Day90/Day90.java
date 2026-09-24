import java.util.*;

public class Day90 {

    static boolean canPaint(int[] boards, int k, long maxTime) {
        int painters = 1;
        long currentTime = 0;

        for (int board : boards) {
            if (currentTime + board <= maxTime) {
                currentTime += board;
            } else {
                painters++;
                currentTime = board;

                if (painters > k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] boards = new int[n];

        long low = 0;
        long high = 0;

        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();

            low = Math.max(low, boards[i]);
            high += boards[i];
        }

        // Binary search on the minimum possible maximum time
        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canPaint(boards, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(low);
    }
}
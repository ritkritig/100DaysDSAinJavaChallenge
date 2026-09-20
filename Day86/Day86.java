import java.util.*;

public class Day86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n == 0 || n == 1) {
            System.out.println(n);
            return;
        }

        int low = 0;
        int high = n;
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Avoid overflow
            if (mid <= n / mid) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
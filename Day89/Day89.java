import java.util.*;

public class Day89 {

    // Checks if books can be allocated to m students
    // with no student getting more than maxPages
    public static boolean canAllocate(int[] pages, int m, int maxPages) {

        int students = 1;
        int currentPages = 0;

        for (int page : pages) {

            if (currentPages + page > maxPages) {
                students++;
                currentPages = page;

                if (students > m) {
                    return false;
                }
            } else {
                currentPages += page;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] pages = new int[n];

        int low = 0;
        int high = 0;

        for (int i = 0; i < n; i++) {
            pages[i] = sc.nextInt();

            low = Math.max(low, pages[i]);
            high += pages[i];
        }

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canAllocate(pages, m, mid)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
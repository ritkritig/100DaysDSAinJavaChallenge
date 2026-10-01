import java.util.*;

public class Day97 {

    public static int minMeetingRooms(int[] start, int[] end) {

        // Store meetings as [start, end]
        int n = start.length;
        int[][] meetings = new int[n][2];

        for (int i = 0; i < n; i++) {
            meetings[i][0] = start[i];
            meetings[i][1] = end[i];
        }

        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);

        // Min-heap stores ending times
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {

            // If the earliest meeting has ended,
            // its room can be reused
            if (!minHeap.isEmpty() && minHeap.peek() <= meetings[i][0]) {
                minHeap.poll();
            }

            // Add current meeting's ending time
            minHeap.add(meetings[i][1]);
        }

        // Heap size = minimum rooms required
        return minHeap.size();
    }

    public static void main(String[] args) {

        int[] start = {2, 9, 6};
        int[] end = {4, 12, 10};

        int result = minMeetingRooms(start, end);

        System.out.println("Minimum rooms required: " + result);
    }
}
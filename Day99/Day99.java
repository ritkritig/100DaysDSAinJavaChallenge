import java.util.*;

public class Day99 {

    public static int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        int[][] cars = new int[n][2];

        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort by position in descending order
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);

        int fleets = 0;
        double lastTime = 0;

        for (int i = 0; i < n; i++) {

            double time = (double) (target - cars[i][0]) / cars[i][1];

            // Car forms a new fleet
            if (time > lastTime) {
                fleets++;
                lastTime = time;
            }
        }

        return fleets;
    }

    public static void main(String[] args) {

        int target = 12;

        int[] position = {10, 8, 0, 5, 3};

        int[] speed = {2, 4, 1, 1, 3};

        int result = carFleet(target, position, speed);

        System.out.println("Number of car fleets: " + result);
    }
}
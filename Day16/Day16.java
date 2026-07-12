import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

public class Day16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Integer, Integer> m = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int number = scanner.nextInt();
            int currentCount = m.getOrDefault(number, 0);
            m.put(number, currentCount + 1);
        }
        for (int key : m.keySet()) {
            System.out.print(key + ":" + m.get(key) + " ");
        }
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<String, Integer> votes = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            votes.put(name, votes.getOrDefault(name, 0) + 1);
        }

        String winner = "";
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : votes.entrySet()) {
            String candidate = entry.getKey();
            int count = entry.getValue();

            if (count > maxVotes ||
                (count == maxVotes && candidate.compareTo(winner) < 0)) {
                winner = candidate;
                maxVotes = count;
            }
        }

        System.out.println(winner + " " + maxVotes);

        sc.close();
    }
}
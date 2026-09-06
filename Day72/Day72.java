import java.util.*;

class Day72 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';

            if (seen[index]) {
                System.out.println(s.charAt(i));
                return;
            }

            seen[index] = true;
        }

        System.out.println(-1);
    }
}
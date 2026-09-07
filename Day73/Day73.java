import java.util.*;

class Day73 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int[] freq = new int[26];

        // Count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Find first non-repeating character
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1) {
                System.out.println(s.charAt(i));
                return;
            }
        }

        // No non-repeating character
        System.out.println('$');
    }
}
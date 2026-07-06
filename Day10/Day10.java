/*Problem: Read a string and check if it is a palindrome using two-pointer comparison.

Input:
- Single line: string s

Output:
- Print YES if palindrome, otherwise NO*/
import java.util.Scanner;
class Palindrome{
    static boolean pal(char[] s){
        int a=0;
        int b=s.length-1;
        while (a < b) {
            if (s[a] != s[b]) {
                return false;
            }
            a++;
            b--;
        }
        return true;
    }
}
public class Day10{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string: ");
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        boolean result = Palindrome.pal(arr);
        if(result==true){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
        sc.close();
    }
}
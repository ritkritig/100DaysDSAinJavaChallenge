/*Problem: A secret system stores code names in forward order. To display them in mirror format, you must transform the given code name so that its characters appear in the opposite order.

Input:
- Single line: a lowercase string containing only alphabetic characters (no spaces)

Output:
- Print the transformed code name after applying the mirror operation
*/
import java.util.Scanner;
class Mirror{
    static void mir(char[] s){
        int left=0;
        int right = s.length-1;
        while(left<right){
            char temp = s[right];
            s[right]=s[left];
            s[left]=temp;
            left++;
            right--;
        }
    }
}
public class Day9{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the string: ");
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        Mirror.mir(arr);
        for(char i : arr) {
            System.out.print(i);
        }
        sc.close();
    }
}
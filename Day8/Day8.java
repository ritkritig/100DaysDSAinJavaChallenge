/*Problem: Given integers a and b, compute a^b using recursion without using pow() function.

Input:
- Two space-separated integers a and b

Output:
- Print a raised to power b*/
import java.util.Scanner;
class CalcPow{
    static int cal(int a, int b){
        if(b==0){
            return 1;
        }
        return a*cal(a, b-1);
    }
}
public class Day8{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter base number: ");
        int a= sc.nextInt();
        System.out.println("enter power number: ");
        int b= sc.nextInt();
        int result = CalcPow.cal(a,b);
        System.out.println(result);
        sc.close();
    }
}
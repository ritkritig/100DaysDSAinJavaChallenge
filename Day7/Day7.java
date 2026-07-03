/*Problem: Write a recursive function fib(n) to compute the n-th Fibonacci number where fib(0)=0 and fib(1)=1.

Input:
- Single integer n

Output:
- Print the n-th Fibonacci number*/
import java.util.Scanner;
class Fibonacci{
    static int fib(int n){
        if(n<=1){
            return n;
        }
        int prev1=1;
        int prev2=0;
        int curr=0;
        for(int i=2; i<=n; i++){
            curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}
public class Day7{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter a number: ");
        int n= sc.nextInt();
        int fibo=Fibonacci.fib(n);
        System.out.println(fibo);
        sc.close();
    }
}
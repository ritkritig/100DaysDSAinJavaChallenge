/*Problem: Given an array of n integers, reverse the array in-place using two-pointer approach.

Input:
- First line: integer n
- Second line: n space-separated integers

Output:
- Print the reversed array, space-separated*/
import java.util.Scanner;
class Reversearray{
    static int[] reverse(int[] arr){
        int n = arr.length;
        int temp=0;
        for (int i=0; i<n/2; i++){
            temp=arr[i];
            arr[i]=arr[n-i-1];
            arr[n-i-1]=temp;
        }
        return arr;
    }
}
public class Day4{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
       Reversearray.reverse(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
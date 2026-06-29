/* Problem: Write a program to delete the element at a given 1-based position pos from an array of n integers. Shift remaining elements to the left.

Input:
- First line: integer n
- Second line: n space-separated integers
- Third line: integer pos (1-based position to delete)

Output:
- Print the updated array with (n-1) elements, space-separated
*/
import java.util.Scanner;
class Delint {
    static int[] delete(int[] arr, int x){
        x=x-1;
        int[] newarr = new int[arr.length-1];
        for (int i=0; i<x; i++) {
            newarr[i] = arr[i];
        }

        for(int i=x; i<arr.length-1; i++){
            newarr[i]=arr[i+1];
        }
        return newarr;
    }
}
public class Day2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the position (1-based): ");
        int pos = sc.nextInt();

        int[] result = Delint.delete(arr, pos);

        System.out.println("Updated array:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
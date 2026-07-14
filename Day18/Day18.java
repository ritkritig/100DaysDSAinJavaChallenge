/*Problem: Given an array of integers, rotate the array to the right by k positions.

Input:
- First line: integer n
- Second line: n integers
- Third line: integer k

Output:
- Print the rotated array*/
import java.util.Scanner;
class Rotate{
    static void rot(int[] arr, int n) {
        n = n % arr.length;
        for (int j = 0; j < n; j++) {
                int temp = arr[arr.length-1];
            for (int i = arr.length-1; i >0; i--) {
                arr[i] = arr[i-1];
            }
                arr[0] = temp;

        }
    }
}
public class Day18 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int[] arr = new int[p];

        for (int i = 0; i < p; i++) {
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Rotate.rot(arr, n);
        for (int num : arr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
/*Problem: Write a program to find the maximum and minimum values present in a given array of integers.

Input:
- First line: integer n
- Second line: n integers

Output:
- Print the maximum and minimum elements*/
import java.util.Scanner;
class MaxMin {
    static void maxmin(int[] arr) {
        int largest = arr[0];
        int smallest = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (largest < arr[i]) {
                largest = arr[i];

            }
            if (smallest > arr[i]) {
                smallest = arr[i];

            }
        }
        System.out.println("max: "+ largest);
        System.out.println("min: "+ smallest);
    }
}
public class Day17{
    public static void main(String[] args ){
        Scanner sc = new Scanner(System.in);

        int p = sc.nextInt();
        int[] arr = new int[p];

        for (int i = 0; i < p; i++) {
            arr[i] = sc.nextInt();
        }
        MaxMin.maxmin(arr);
        sc.close();
    }
}
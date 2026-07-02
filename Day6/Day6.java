/*Problem: Given a sorted array of n integers, remove duplicates in-place. Print only unique elements in order.

Input:
        - First line: integer n
- Second line: n space-separated integers (sorted array)

Output:
        - Print unique elements only, space-separated*/
import java.util.Scanner;
class RemoveDuplicates{
    static int rem(int[] arr){
        int i=0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i]!=arr[j]) {
                i++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}
public class Day6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int unique=RemoveDuplicates.rem(arr);
        for (int i = 0; i < unique; i++) {
            System.out.print(arr[i] + " ");
        }
        sc.close();
    }
}
/*Problem: A system receives two separate logs of user arrival times from two different servers. Each log is already sorted in ascending order. Your task is to create a single chronological log that preserves the correct order of arrivals.

Input:
- First line: integer p (number of entries in server log 1)
- Second line: p sorted integers representing arrival times from server 1
- Third line: integer q (number of entries in server log 2)
- Fourth line: q sorted integers representing arrival times from server 2)

Output:
- Print a single line containing all arrival times in chronological order, separated by spaces*/
import java.util.Scanner;
class Mergearray{
    static int[] merge(int p, int[] arr1, int q, int[] arr2){
        int[] finalarr=new int[p+q];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < p && j < q) {

            if (arr1[i] <= arr2[j]) {
                finalarr[k] = arr1[i];
                i++;
            }
            else {
                finalarr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < p) {
            finalarr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < q) {
            finalarr[k] = arr2[j];
            j++;
            k++;
        }
        return finalarr;
    }
}
public class Day5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int p = sc.nextInt();
        int[] arr1 = new int[p];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < p; i++) {
            arr1[i] = sc.nextInt();
        }
        System.out.print("Enter the size of array: ");
        int q = sc.nextInt();
        int[] arr2 = new int[q];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < q; i++) {
            arr2[i] = sc.nextInt();
        }
        int[] finalarr= Mergearray.merge(p, arr1, q, arr2);
        for (int num : finalarr) {
            System.out.print(num + " ");
        }
        sc.close();
    }
}
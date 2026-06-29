/*Implement linear search to find key k in an array. Count and display the number of comparisons performed.

Input:
- First line: integer n (array size)
- Second line: n space-separated integers
- Third line: integer k (key to search)

Output:
- Line 1: "Found at index i" OR "Not Found"
Line 2: "Comparisons = c" */
import java.util.Scanner;
class LinearSearch {
    static void findele(int[] arr, int k){
        int count=0;
        boolean found = false;
        //int index=-1;
        for(int i=0; i<arr.length; i++){
            count++;
            if(arr[i]==k){
                found=true;
                //index=i;
                System.out.println("found at index: "+i);
                break;
            }
        }
        if (!found) {
            System.out.println("Not Found");
        }
        System.out.println("comparisons: "+count);
    }
}
public class Day3{
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element to be found: ");
        int k = sc.nextInt();
        LinearSearch.findele(arr, k);
        sc.close();
    }
}
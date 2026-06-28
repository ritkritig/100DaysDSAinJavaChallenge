/* Problem: Write a program to insert an element x at a given 1-based position pos in an array of n integers. Shift existing elements to the right to make space.

        Input:
        - First line: integer n
- Second line: n space-separated integers (the array)
- Third line: integer pos (1-based position)
- Fourth line: integer x (element to insert)

Output:
        - Print the updated array (n+1 integers) in a single line, space-separated
*/
import java.util.Scanner;
class Insertint {
    static int[] insert(int[] arr, int pos, int x){
        pos = pos-1;
        int[] newarr = new int[arr.length+1];
        for (int i=0; i<pos; i++) {
            newarr[i] = arr[i];
        }

        newarr[pos]=x;

            for(int i=pos; i<arr.length; i++){
                newarr[i+1]=arr[i];
            }
        return newarr;
            }
        }
public class Day1 {

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

        System.out.print("Enter the element to insert: ");
        int x = sc.nextInt();

        int[] result = Insertint.insert(arr, pos, x);

        System.out.println("Updated array:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}
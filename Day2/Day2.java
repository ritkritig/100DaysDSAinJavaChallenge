import java.util.Scanner;

class Deleteele {
    static int[] delete(int[] arr, int pos) {
        pos = pos - 1;  
        int[] newarr = new int[arr.length - 1];
        for (int i = 0; i < pos; i++) {
            newarr[i] = arr[i];
        }
        for (int i = pos + 1; i < arr.length; i++) {
            newarr[i - 1] = arr[i];
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

        System.out.print("Enter the position to delete (1-based): ");
        int pos = sc.nextInt();

        int[] result = Deleteele.delete(arr, pos);

        System.out.println("Updated array:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}

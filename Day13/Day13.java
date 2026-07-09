/*Problem: You are given a rectangular matrix of integers. Starting from the outer boundary, traverse the matrix in a clockwise manner and continue moving inward layer by layer until all elements are visited.

Input:
- First line: two integers r and c representing the number of rows and columns
- Next r lines: c integers each representing the matrix elements

Output:
- Print all visited elements in the order of traversal, separated by spaces*/
import java.util.*;
class Spiral{
    static void spiralOrder(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        List<Integer> list = new ArrayList<>();
        while (top <= bottom && left <= right){
            for (int j = left; j <= right; j++){
                list.add(matrix[top][j]);
            }
            top++;
            for (int i = top; i <= bottom; i++){
                list.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom){
                for (int j = right; j >= left; j--){
                    list.add(matrix[bottom][j]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
        }
        System.out.println(list);
    }
}
public class Day13{
    public static void main ( String[] args){
        System.out.println("enter the number of rows and columns: ");
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.println("enter the elements of the matrix: ");
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        Spiral.spiralOrder(matrix);
        sc.close();
    }
}
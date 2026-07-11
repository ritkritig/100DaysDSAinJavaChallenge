/*Problem: Given a matrix, calculate the sum of its primary diagonal elements. The primary diagonal consists of elements where row index equals column index.

Input:
- First line: two integers m and n
- Next m lines: n integers each

Output:
- Print the sum of the primary diagonal elements*/
import java.util.*;
class DiagonalSum{
    static int diagsum(int[][] matrix){
        int sum=0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                if(i==j){
                    sum+=matrix[i][j];
                }
            }
        }
        return sum;
    }
}
public class Day15{
    public static void main(String[] args){
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
        int result = DiagonalSum.diagsum(matrix);
        System.out.println(result);
        sc.close();
    }
}
/*Problem: Write a program to check whether a given square matrix is an Identity Matrix. An identity matrix is a square matrix in which all diagonal elements are 1 and all non-diagonal elements are 0.

Input:
- First line: integer n representing number of rows and columns
- Next n lines: n integers each representing the matrix elements

Output:
- Print "Identity Matrix" if the matrix satisfies the condition
- Otherwise, print "Not an Identity Matrix"*/
import java.util.*;
class Identity{
    static boolean id(int[][] matrix){
        for(int i=0;i<matrix.length;i++) {
            if (matrix.length != matrix[i].length) {
                return false;
            }
            if(matrix[i][i]!=1){
                return false;
            }
            for (int j=0; j<matrix.length; j++){
                if(i!=j){
                    if(matrix[i][j]!=0){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
public class Day14{
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
        boolean result = Identity.id(matrix);
        if(result==true){
            System.out.println("Identity Matrix");
        }
        else System.out.println("not an Identity Matrix");
        sc.close();
    }
}
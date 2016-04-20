package Matrix;

import java.util.Scanner;

/**
 * Created by AKHIL on 23-Mar-16.
 */
public class TurnImageByRightAngle {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter matrix Size:");
        int m = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        int matrix[][] = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
            sc.nextLine();
        }
        printRotateBy90(matrix,m,n);
        sc.close();
    }

    private static void printRotateBy90(int[][] matrix,int m,int n) {
        int [][] newArr = new int[n][m];
        for(int i=0,l=0;i<n && l<n;i++,l++){
            for(int j=0, k=m-1;j<m && k>=0;j++,k--){
                newArr[i][j] = matrix[k][l];
            }
        }

        //print the newArray
        for(int i=0;i<n;i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("%d ", newArr[i][j]);
            }
            System.out.println();
        }
        return;
    }
}
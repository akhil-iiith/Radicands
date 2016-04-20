package Matrix;

import java.util.Scanner;

/**
 * Created by AKHIL on 05-Apr-16.
 */
public class SumSubSquares {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter square matrix size:");
        int n = sc.nextInt();
        System.out.print("Enter sub square matrix size less than or equal to n:");
        int k = sc.nextInt();
        System.out.println("Enter matrix elements:");
        int arr[][] = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();
        findSumSquareSubMatrix(arr,n,k);
        sc.close();
    }

    private static void findSumSquareSubMatrix(int[][] arr, int n, int k) {
        int N = (int)Math.pow((int)n+1-k,2);
        int size = (int)Math.sqrt((int)N);
        int finalArr[][] = new int[N][N];
        int r=0,c=0;
        int sum = 0;
        while(r<k){
            c=0;
            while(c<k){
                sum = 0;
                for (int i = r; i < r+n-k+1; i++) {
                    for (int j = c; j < c+n-k+1; j++) {
                        sum += arr[i][j];
                    }
                }
                finalArr[r][c] = sum;
                c++;
            }
            r++;
        }

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                System.out.print(finalArr[i][j] + " ");
            }
            System.out.println();
        }
    }
}

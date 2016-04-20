package Matrix;

import java.util.Scanner;

/**
 * Created by AKHIL on 23-Mar-16.
 */
public class MakeAllCells1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //Size of Row
        int N = sc.nextInt(); //Size of Column
        int arr[][] = new int[M][N];
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++)
                arr[i][j] = sc.nextInt();
        int row[] = new int[M];
        for (int i = 0; i < M; i++)
            row[i] = 0;
        int col[] = new int[N];
        for (int i = 0; i < N; i++)
            col[i] = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
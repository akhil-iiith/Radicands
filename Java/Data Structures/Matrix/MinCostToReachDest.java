package Matrix;

import java.util.Scanner;

/**
 * Created by AKHIL on 04-Apr-16.
 */
public class MinCostToReachDest {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row size:");
        int M = sc.nextInt(); // Size of Row
        System.out.print("Enter column size:");
        int N = sc.nextInt(); // Size of Column
        System.out.print("Enter cost matrix:\n");
        int cost[][] = new int[M][N];
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
                cost[i][j] = sc.nextInt();
        // cost[][] = {{1,2,3}, {4,8,2}, {1,5,3}};

        int m,n;
        System.out.print("Enter valid path to reach coordinates:\n");
        m = sc.nextInt();
        n = sc.nextInt();

        int dp[][] = new int[M][N];
        dp[0][0] = cost[0][0];
        for(int j=1;j<N;j++)
            dp[0][j] = dp[0][j-1] + cost[0][j];
        for(int i=1;i<M;i++)
            dp[i][0] = dp[i-1][0] + cost[i][0];
        for(int i=1;i<M;i++){
            for(int j=1;j<N;j++){
                dp[i][j] = cost[i][j] + min(dp[i-1][j-1], dp[i-1][j],dp[i][j-1]);
            }
        }

        //For Debugging Purpose
        System.out.print("DP Matrix is\n");
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.printf("Total cost to reach (%d,%d) from (0,0) is %d\n",m,n,dp[m][n]);
        sc.close();
    }

    private static int min(int i, int i1, int i2) {
        if(i<i1 && i<i2)
            return i;
        else if(i1<i && i1<i2)
            return i1;
        else
            return i2;
    }
}
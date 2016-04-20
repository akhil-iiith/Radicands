package Matrix;

import java.util.*;

/**
 * Created by AKHIL on 05-Apr-16.
 */
public class PrintNoOfPaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter row size:");
        int m = sc.nextInt();
        System.out.print("Enter col size:");
        int n= sc.nextInt();
        System.out.println("No. of Paths Possible:" + numberOfPaths(m,n));
        sc.close();
    }

    private static int numberOfPaths(int m, int n) {
        if(m==1 || n==1)
            return 1;
        int dp[][] = new int[m][n];
        Arrays.fill(dp[0],1);
        for(int i=1;i<m;i++)
            dp[i][0] = 1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];

        return dp[m-1][n-1];
    }
}

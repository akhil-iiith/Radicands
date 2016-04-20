package Matrix;

import java.util.Scanner;

/**
 * Created by AKHIL on 23-Mar-16.
 */
public class SearchElemRowColumnWiseSortedMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //Size of Row
        int N = sc.nextInt(); //Size of Column
        int arr[][] = new int[M][N];
        for(int i=0;i<M;i++)
            for(int j=0;j<N;j++)
                arr[i][j] = sc.nextInt();
        System.out.println("Element to be found: ");
        int x = sc.nextInt();
        boolean isPresent = findElem(arr,M,N,x);
        if(isPresent)
            System.out.println("Element present in matrix");
        else
            System.out.println("Element not present");
        sc.close();
    }

    private static boolean findElem(int[][] arr, int m, int n, int x) {
        int i = m-1;
        int j = 0;
        while(i>=0 && j<n){
            if(arr[i][j] > x)
                i--;
            else if(arr[i][j] < x)
                j++;
            else
                return true;
        }
        return false;
    }
}

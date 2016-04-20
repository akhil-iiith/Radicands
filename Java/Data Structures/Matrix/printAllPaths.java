package Matrix;

/**
 * Created by AKHIL on 05-Apr-16.
 */
public class printAllPaths {
    public static void main(String[] args) {
        int mat[][] = { {1, 2, 3}, {4, 5, 6} };
        printAllPaths(mat, 2, 3);
    }
    private static void printArray(int[] arr,int pi){
        for(int i=0;i<pi;i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    private static void printAllPaths(int[][] M,int m,int n){
        int[] path = new int[m+n-1];
        int pi=0;
        printUtilPaths(M,0,0,m,n,path,pi);

    }
    private static void printUtilPaths(int[][]M, int i, int j, int m, int n, int[] path, int pi) {
        if(i==m-1){
            path[pi++] = M[i][j];
            for(int k=j+1;k<n;k++){
                path[pi]= M[i][k];
                pi++;
            }
            printArray(path,pi);
            return;
        }

        if(j==n-1){
            path[pi++] = M[i][j];
            for(int k=i+1;k<m;k++){
                path[pi]= M[k][j];
                pi++;
            }
            printArray(path,pi);
            return;
        }

        path[pi] = M[i][j];
        printUtilPaths(M,i+1,j,m,n,path,pi+1);
        printUtilPaths(M,i,j+1,m,n,path,pi+1);
    }

}

package Matrix;

/**
 * Created by AKHIL on 05-Apr-16.
 */
public class PrintDiagonalMatrix {
    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
            {17, 18, 19, 20},
        };
        diagonalOrder(arr);
    }

    private static void diagonalOrder(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;
        for(int k=0;k<R;k++){
            System.out.print(arr[k][0] + " ");
            int i=k-1;
            int j=1;
            while(IsValid(i,j,R,C)){
                System.out.print(arr[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }

        for(int k=1;k<C;k++){
            System.out.print(arr[R-1][k] + " ");
            int i= R-2;
            int j= k+1;
            while(IsValid(i,j,R,C)){
                System.out.print(arr[i][j] + " ");
                i--;
                j++;
            }
            System.out.println();
        }
    }

    private static boolean IsValid(int i, int j, int R,int C) {
        if(i<0 || i>=R || j<0 || j>=C){
            return  false;
        }
        return true;
    }
}

package Matrix;
/**
 * Created by AKHIL on 23-Mar-16.
 */
public class MaxSquareSubMatrix {
    private static final int R=6;
    private static final int C=5;
    public static void main(String []args){
        int [][]M = {{0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
        printMaxSubSquare(M);
    }

    private static void printMaxSubSquare(int[][] m) {
        int S[][] = new int[R][C];
        for(int i=0;i<R;i++)
            S[i][0] = m[i][0];
        for(int j=0;j<C;j++)
            S[0][j] = m[0][j];
        for(int i=1;i<R;i++){
            for(int j=1;j<C;j++){
                if(m[i][j]==1)
                    S[i][j] = min(S[i-1][j],S[i-1][j-1],S[i][j-1]) + 1;
                else
                    S[i][j] = 0;
            }
        }
        int max = Integer.MIN_VALUE;
        int index_r=0,index_c=0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(S[i][j] > max) {
                    max = S[i][j];
                    index_r = i;
                    index_c = j;
                }
            }
        }
        System.out.printf("Row ending is %d, Column ending is %d\n",index_r + 1,index_c + 1);
        for(int i=index_r; i >index_r - max; i--){
            for(int j=index_c; j >index_c - max; j--){
                System.out.printf("%d ",m[i][j]);
            }
            System.out.println();
        }
    }

    private static int min(int a,int b,int c){
        if(a<=b && a<=c)
            return a;
        else if(b<=a && b<=c)
            return b;
        else
            return c;
    }
}
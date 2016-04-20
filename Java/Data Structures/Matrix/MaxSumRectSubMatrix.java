package Matrix;

/**
 * Created by AKHIL on 04-Apr-16.
 */
public class MaxSumRectSubMatrix {
    static final int ROW = 4;
    static  final int COL = 5;
    static int startIndex=0,endIndex=0;
    public static void main(String[] args) {
        int M[][] = {{1, 2, -1, -4, -20},
            {-8, -3, 4, 2, 1},
            {3, 8, 10, 1, 3},
            {-4, -1, 1, 7, -6}
        };
        int maxSum = Integer.MIN_VALUE;
        int left,right,currSum,maxLeft=0,maxRight=0,maxUp=0,maxBottom=0;
        int temp[] = new int[ROW];
/*        for(int i=0;i<ROW;i++){
            temp[i] = 0;
        }*/
        for(left=0;left<COL;left++){
            for(int j=0;j<ROW;j++){
                temp[j] = 0;
            }
            for(right=left;right<COL;right++){
                for(int i=0;i<ROW;i++){
                    temp[i] = temp[i] + M[i][right];
                }
                currSum = findKadaneMaxSum(temp);
                if(currSum > maxSum){
                    maxSum = currSum;
                    maxLeft = left;
                    maxRight = right;
                    maxUp = startIndex;
                    maxBottom = endIndex;
                }
            }
        }

        for(int i=maxUp;i<=maxBottom;i++){
            for(int j=maxLeft;j<=maxRight;j++) {
                System.out.printf(M[i][j] + " ");
            }
            System.out.println();
        }
        System.out.printf("Starting index of Rectangle is: " + "(" + maxUp + "," + maxLeft + ")\n");
        System.out.printf("Ending index of Rectangle is: " + "(" + maxBottom + "," + maxRight + ")\n");
    }

    private static int findKadaneMaxSum(int[] temp) {
        int maxSum=Integer.MIN_VALUE;
        int currMax = temp[0];
        for(int i=1;i<temp.length;i++){
            maxSum = Max(temp[i],currMax + temp[i]);
            if(temp[i] > currMax + temp[i]){
                startIndex = i;
                endIndex = i;
            }
            else
            {
                endIndex = i;
            }
            currMax = maxSum;
        }
        return maxSum;
    }

    private static int Max(int i, int j) {
        return i>j?i:j;
    }
}

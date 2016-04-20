package Hackerrank;

/**
 * Created by AKHIL on 08-Apr-16.
 */
public class KthSubSequenceCount {
    public static void main(String[] args) {
        int[] num = {7, 8, 1, 3, 4};
        int k = 4;
        System.out.println(kSub(num,k));
    }

    private static long kSub(int []num, int k){
        long count = 0;
        for(int i=1;i<=k;i++)
            count += findSuch(num,i,k);
        return count;
    }

    private static long findSuch(int arr[], int size, int k){
        int left = 0;
        int right = size-1;
        int len = arr.length;
        long count = 0;
        int sum = 0;
        while (left<len && right<len && left<=right){
            sum = 0;
            for (int i=left;i<=left+size-1;i++){
                sum += arr[i];
            }
            if(sum%k==0){
                count++;
            }
            left++;
            right++;
        }
        return count;
    }
}
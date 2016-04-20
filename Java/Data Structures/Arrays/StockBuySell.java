package Arrays;

import java.util.Scanner;

/**
 * Created by AKHIL on 23-Mar-16.
 */
public class StockBuySell {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //Size of Array
        //Assuming input array consists of values in range of [Integer.MIN_VALUE, Integer.MAX_VALUE]
        int arr[] = new int[N];
        int max_profit = 0;
        int buy_index,sell_index;

        for(int i=0;i<N;i++)
            arr[i] = sc.nextInt();

        for(int i=0;i<N-1;){
            if(arr[i] >= arr[i+1]){
                i++;
                continue;
            }
            else{
                buy_index = i;
                while(i<N-1 && arr[i] < arr[i+1]){
                    i++;
                }
                sell_index = i;
            }
            max_profit += arr[sell_index] - arr[buy_index];
        }
        System.out.println(max_profit);
        sc.close();
    }
}
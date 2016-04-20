/* package whatever; // don't place package name! */
package Matrix;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Stockroom
{
    public static void main(String[] args) throws java.lang.Exception{
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-->0){
            int N = sc.nextInt();
            int Dzc = sc.nextInt();
            sc.nextLine();
            String array = sc.nextLine();



            //base case
            int Ls = array.length();
            if(Ls < N){
                System.out.println("abort mission: food");
                break;
            }

            String str = String.valueOf(Dzc);
            int Ld = str.length();


            int temp = N;
            int ld = Ld;
            int ls = Ls;
            int sum = 0;
            boolean toShow = false;
            while(temp>0){
                int currentMax = Integer.MIN_VALUE;
                int indexToRemove  = 0;
                int lenOfMax = 0;
                int maxLen = function(ls - (temp-1), Ld);
                boolean found = false;
                while(maxLen>=1) {
                    for (int i = 0; i <= ls - maxLen; i++) {
                        String substr = array.substring(i, i + maxLen);
                        int lVal = Integer.parseInt(substr);
                        if (lVal < Dzc) {
                            if (lVal > currentMax) {
                                found = true;
                                currentMax = lVal;
                                indexToRemove = i;
                                lenOfMax = maxLen;
                            }
                        }
                    }
                    maxLen--;
                    if(found){
//                        System.out.println("taking " + currentMax);
                        sum = sum + currentMax;
                        break;
                    }
                }


                if(!found){
                    toShow = true;
                    System.out.println("abort mission: food");
                    break;
                }
                StringBuilder st = new StringBuilder();
                if(indexToRemove>0) {
                    st.append(array.substring(0, indexToRemove));
                }
                st.append(array.substring(indexToRemove+lenOfMax, array.length()));
                array = st.toString();
                ls = array.length();
//                System.out.println("remaining arr "  +array);
                temp--;
            }
            if(!toShow)
                System.out.println(sum);
        }
    }

    private static int function(int ls, int ld) {
        int min = Math.min(ls,ld);
        if(min > 1){
            return min;
        }
        return 1;
    }

}

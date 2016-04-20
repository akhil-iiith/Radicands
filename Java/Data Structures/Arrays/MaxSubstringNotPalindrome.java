package Arrays;

/**
 * Created by AKHIL on 18-Apr-16.
 */

// Complexity = O(n,3)
// String is given need to print maximum length of string ( sub string) which is not palindrome
public class MaxSubstringNotPalindrome {
    private static boolean IsPalindrome(String arr,int start,int end){
        int mid = (end-start)/2;
        int j = end;
        boolean isPalind = false;
        for(int i=start;i<=mid && j>=mid;){
            if(arr.charAt(i)==arr.charAt(j)){
                isPalind = true;
                i++;
                j--;
            }
            else {
                isPalind = false;
                break;
            }
        }
        return isPalind;
    }

    public static void main(String[] args) {
        String arr="abcddcba";
        int max = Integer.MIN_VALUE;
        int l = arr.length();
        for(int i=0;i<l;i++){
            for(int j=i;j<l;j++){
                if(IsPalindrome(arr,i,j)){}
                else{
                    if(j-i+1>max)
                        max = j-i+1;
                }
            }
        }
        System.out.println("Maximum Substring Length which is not Palindrome is: " + max);
    }
}

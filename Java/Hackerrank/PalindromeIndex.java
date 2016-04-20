import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PalindromeIndex {

    private static boolean isPalindrome(String s){
        int len = s.length();
        boolean flag = false;
        char arr[] = s.toCharArray();
        for(int i=0,j=len-1;i<=j;i++,j--){
            if(arr[i] == arr[j]){
                flag = true;
            }
            else{
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        for(int i=0;i<T;i++){
            String s = sc.nextLine();
            boolean isThere = false;
            int len = s.length();
            boolean index = isPalindrome(s);
            if(index==true){
                System.out.println("-1");
                continue;
            }
            List<Character> list = new LinkedList<Character>();
            char arr[] = s.toCharArray();
            for(char c:arr)
                list.add(new Character(c));
            for(int j=0;j<len;j++){
                list.remove(new Character(arr[j]));
                StringBuilder result = new StringBuilder(list.size());
                for (Character c : list)
                    result.append(c);
                String output = result.toString();
                if(isPalindrome(output) == true){
                    System.out.println(j);
                    isThere = true;
                    break;
                }
                else {
                    list.add(j, new Character(arr[j]));
                }
            }
            if(isThere == false){
                System.out.println("-1");
            }
        }
        sc.close();
    }
}
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GemStones {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = N;
        int ans = 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        String str="abcdefghijklmnopqrstuvwxyz";
        int i=0;
        while(i<str.length()){
            map.put(str.charAt(i),0);
            i++;
        }
        sc.nextLine();
        while(N-- > 0){
            int j=0;
            String s = sc.nextLine();
            Set<Character> set = new HashSet<Character>();
            while(j<s.length()){
                set.add(s.charAt(j));
                j++;
            }
            Iterator<Character> it = set.iterator();
            while(it.hasNext()){
                char c = it.next();
                map.put(c,map.get(c)+1);
                if(map.get(c) == count){
                    ans++;
                }
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
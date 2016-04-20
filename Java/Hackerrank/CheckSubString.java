package Hackerrank;
public class CheckSubString {
    public static void main(String[] args) {
        String s1 = "abcdefghijklmnopqrstuvwxyz";
        String s2 = "lnop";
        int len1 = s1.length();
        int len2 = s2.length();
        int lastIndex = -1;
        boolean found = false;
        if(len2>len1){
            System.out.println("Substring length is more than original string length");
            System.exit(0);
        }

        for(int i=0;i<len1;){
            for(int j=0;j<len2;){
                if(s1.charAt(i++)==s2.charAt(j++)) {
                    lastIndex = i;
                    found = true;
                    continue;
                }
                else {
                    found = false;
                    break;
                }
            }
            if(found)
                break;
        }
        if(found)
            System.out.println("First Index of Substring is at:" + (lastIndex-len2+1) + "\nLast Index of Substring is at:" + lastIndex);
        else
            System.out.println("Substring: '" + s2 + "' is not present in Original String: '" + s1 + "'");
    }
}

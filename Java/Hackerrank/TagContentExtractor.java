import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TagContentExtractor{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            int first = line.indexOf('<');
            if(first==-1){
                System.out.println("None");
                continue;
            }
            int second = line.indexOf('>');
            if(second==-1) {
                System.out.println("None");
                continue;
            }
            if(first!=-1) {
                int third = line.lastIndexOf('<');
                if (third == first) {
                    System.out.println("None");
                    continue;
                }
            }
            if(second!=-1) {
                int four = line.lastIndexOf('>');
                if (four == second) {
                    System.out.println("None");
                    continue;
                }
            }

            System.out.println("Proceed Further");
            testCases--;
        }
        in.close();
    }
}
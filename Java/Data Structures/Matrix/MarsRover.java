package Matrix;

import java.util.Scanner;

/**
 * Created by AKHIL on 06-Apr-16.
 */
public class MarsRover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); //Length of Rectangle
        int N = sc.nextInt(); //Breadth of Rectangle
        int x1 = sc.nextInt(); //Position of x-coordinate of Rover1
        int y1 = sc.nextInt(); //Position of y-coordinate of Rover1
        char dir1 = sc.next().charAt(0);
        sc.nextLine();
        String s1 = sc.nextLine();
        int x2 = sc.nextInt(); //Position of x-coordinate of Rover2
        int y2 = sc.nextInt(); //Position of y-coordinate of Rover2
        char dir2 = sc.next().charAt(0);
        sc.nextLine();
        String s2 = sc.nextLine();
        myFunction(x1,y1,dir1,s1,M,N);
        myFunction(x2,y2,dir2,s2,M,N);
    }

    private static void myFunction(int x1,int y1,char dir1,String s1,int M,int N){
        int val=0;
        if(dir1 == 'N')
            val=1;
        if(dir1 == 'S')
            val=2;
        if(dir1 == 'E')
            val=3;
        if(dir1 == 'W')
            val=4;
        int index=0;
        while(index < s1.length())
        {
            switch(s1.charAt(index))
            {
                case 'L':
                    if(dir1=='N') {
                        val = 4;
                        dir1 = 'W';
                    }
                    else if(dir1=='S') {
                        val = 3;
                        dir1 = 'E';
                    }
                    else if(dir1=='E') {
                        val = 1;
                        dir1 = 'N';
                    }
                    else {
                        val = 2;
                        dir1 = 'S';
                    }
                    break;

                case 'R':
                    if(dir1=='N') {
                        val = 3;
                        dir1 = 'E';
                    }
                    else if(dir1=='S') {
                        val = 4;
                        dir1 = 'W';
                    }
                    else if(dir1=='E') {
                        val = 2;
                        dir1 = 'S';
                    }
                    else {
                        val = 1;
                        dir1 = 'N';
                    }
                    break;

                case 'M':
                    if(val==1) {
                        y1 = y1 + 1;
                        if(y1>N)
                            y1=N;
                    }
                    else if(val==2) {
                        y1 = y1 - 1;
                        if(y1<0)
                            y1=0;
                    }
                    else if(val==3) {
                        x1 = x1 + 1;
                        if(x1>M)
                            x1=M;
                    }
                    else {
                        x1 = x1 - 1;
                        if(x1<0)
                            x1=0;
                    }
                    break;
            }
            index++;
        }
        System.out.println(x1 + " " + y1 + " " + dir1);
    }
}
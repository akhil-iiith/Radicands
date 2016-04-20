package HashMap;

import java.util.*;
import java.io.*;
public class CreateProperty {
    public static void main(String[] args)throws Exception{

        Properties user=new Properties();
        user.setProperty("Name","Akhil Agrawal");
        user.setProperty("Email","akhil.kool28@gmail.com");

        user.store(new FileWriter("userInfo.properties"),"User Details Example");

    }
}

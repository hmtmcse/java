package com.miaisoft.conversion;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by touhid on 19/11/2014.
 */
public class TestLoop {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\touhid\\Desktop\\cache\\a.txt");
        System.out.println("Before Format : " + file.lastModified());
        Date date= new Date();
        System.out.println(date.getTime());
        System.out.println( 1 + date.getTime());

        System.out.println("touhid".hashCode());


        int j = 0;
        for (int i =0; i < 100; i++){
            j += i;
            if ((i % 10) == 0 ){
                System.out.println("Hi = " + i + "Total = " +  j);
            }

        }
    }


}

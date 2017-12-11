package com.hmtmcse.serializeObjectTester;

import java.io.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Tou on 5/03/2015.
 */
public class ExerciseSerializableNew {


    public static void main(String[] args) {


        try {       
            FileOutputStream f = new FileOutputStream("C:\\Users\\Tou\\Desktop\\test\\s.bin");
            ObjectOutput s = new ObjectOutputStream(f);
            s.writeObject("Today");
            s.writeObject(new Date());
            s.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        

        try {
            FileInputStream in = new FileInputStream("C:\\Users\\Tou\\Desktop\\test\\s.bin");
            ObjectInputStream s = new ObjectInputStream(in);
            String today = (String)s.readObject();
            Date date = (Date)s.readObject();
            System.out.println(today);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    
}

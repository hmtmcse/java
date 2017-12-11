package com.hmtmcse.basic;

import java.util.List;

/**
 * Created by hmtmc on 05/12/2016.
 */
public class ReadArrayList {

    public static void main(String[] args) {
        List<String> content = new java.util.ArrayList<String>();
//        content.add("A 1");
//        content.add("B 2");
//        content.add("C 3");
//        content.add("D 4");
//        content.add("E 5");
//        content.add("F 6");
//        content.add("G 7");
        content.add("H 8");
        content.add("I 9");

        Integer maxNumber = 5;
        Integer alreadyRead = 3;
        Integer maxRead = -1;
        Integer size = content.size() - 1;
        maxNumber -= alreadyRead;
        if (size > (maxNumber - 1)){
            maxRead = Math.abs(size - maxNumber);
        }
        for (int i = size; i > maxRead; i--){
            System.out.println(content.get(i));
        }



    }


}

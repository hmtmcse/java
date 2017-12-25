package com.hmtmcse.advance.collectionc.iIteratorc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterateExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Keyboard");
        list.add("Mouse");
        list.add("Monitor");
        list.add("Speaker");
        list.add("System Unit");

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        // Remove Test
        iterator = list.iterator();
        while (iterator.hasNext()){
            String currentValue = iterator.next();
            if (currentValue.equals("Keyboard")){
                iterator.remove();
            }
        }


        System.out.println("-------------------------------");
        iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }
}

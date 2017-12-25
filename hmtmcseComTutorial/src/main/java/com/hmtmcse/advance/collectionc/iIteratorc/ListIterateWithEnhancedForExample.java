package com.hmtmcse.advance.collectionc.iIteratorc;

import java.util.ArrayList;
import java.util.List;

public class ListIterateWithEnhancedForExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Keyboard");
        list.add("Mouse");
        list.add("Monitor");
        list.add("Speaker");
        list.add("System Unit");

        for (String item : list){
            System.out.println(item);
        }
    }
}

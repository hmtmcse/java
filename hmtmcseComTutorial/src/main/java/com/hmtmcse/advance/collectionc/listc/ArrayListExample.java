package com.hmtmcse.advance.collectionc.listc;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List<String> arrayListlist = new ArrayList<>();
        arrayListlist.add("Keyboard");
        arrayListlist.add("Mouse");
        arrayListlist.add("Monitor");
        arrayListlist.add("Speaker");
        arrayListlist.add("System Unit");
        arrayListlist.add("Motherboard");

        // Print Elements From the List
        for (String item : arrayListlist){
            System.out.println(item);
        }
    }
}

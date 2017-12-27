package com.hmtmcse.advance.collectionc.listc;

import java.util.LinkedList;
import java.util.Arrays;
import java.util.List;

public class LinkedListConversionExample {

    public static void main(String[] args) {
        List<String> LinkedList = new LinkedList<>();
        LinkedList.add("Keyboard");
        LinkedList.add("Mouse");
        LinkedList.add("Monitor");
        LinkedList.add("Speaker");
        LinkedList.add("System Unit");
        LinkedList.add("Motherboard");

        // Convert LinkedList to Array
        String[] array = new String[LinkedList.size()];
        array = LinkedList.toArray(array);


        // Print The Array
        System.out.println("-- Print Items from Array --");
        System.out.println(Arrays.toString(array));

        // Creating new Java Array
        String[] newArray = {"Laptop", "Printer", "WebCam"};

        // Cleaning Previous Items From the LinkedList
        LinkedList.clear();

        // Putting New Array Into LinkedList
        LinkedList = Arrays.asList(newArray);


        // Print Elements From the List
        System.out.println("");
        System.out.println("-- Print Items from LinkedList --");
        for (String item : LinkedList){
            System.out.println(item);
        }

    }
}

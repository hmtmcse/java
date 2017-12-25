package com.hmtmcse.advance.collectionc.listc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListConversionExample {

    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Keyboard");
        arrayList.add("Mouse");
        arrayList.add("Monitor");
        arrayList.add("Speaker");
        arrayList.add("System Unit");
        arrayList.add("Motherboard");

        // Convert ArrayList to Array
        String[] array = new String[arrayList.size()];
        array = arrayList.toArray(array);


        // Print The Array
        System.out.println("-- Print Items from Array --");
        System.out.println(Arrays.toString(array));

        // Creating new Java Array
        String[] newArray = {"Laptop", "Printer", "WebCam"};

        // Cleaning Previous Items From the ArrayList
        arrayList.clear();

        // Putting New Array Into ArrayList
        arrayList = Arrays.asList(newArray);


        // Print Elements From the List
        System.out.println("");
        System.out.println("-- Print Items from ArrayList --");
        for (String item : arrayList){
            System.out.println(item);
        }

    }
}

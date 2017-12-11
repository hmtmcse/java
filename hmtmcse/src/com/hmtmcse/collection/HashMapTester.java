package com.hmtmcse.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Tou on 4/03/2015.
 */
public class HashMapTester {

    public static void main(String args[]) {
        
        
        Map <String, String> map = new HashMap<String, String>();
        map.put("MIS","Mia Intelijent Software");
        map.put("MIS1","Mia Intelijent Software");

        


        System.out.println("  " + map.size());
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.printf("Key : %s and Value: %s", entry.getKey(), entry.getValue());
        }
//
//        System.out.println("Use Iterator and while loop, if you want to remove entries from HashMap during iteration");
//                Iterator<Map.Entry<Integer, String>> iterator = map.entrySet().iterator();
//        while(iterator.hasNext()){
//            Map.Entry<Integer, String> entry = iterator.next();
//            System.out.printf("Key : %s and Value: %s %n", entry.getKey(),
//                    entry.getValue());
//            iterator.remove();
//        }
    }


}

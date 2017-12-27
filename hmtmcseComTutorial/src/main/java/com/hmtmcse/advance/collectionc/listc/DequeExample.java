package com.hmtmcse.advance.collectionc.listc;

import java.util.Deque;
import java.util.LinkedList;

public class DequeExample {


    public static void main(String[] args) {

        // Instantiate The Deque
        Deque<String> deque = new LinkedList<>();

        // Adding Item in Deque
        deque.add("Keyboard");


        // Adding Item in First place of the Deque
        deque.addFirst("Mouse");

        // Adding Item in Last place of the Deque
        deque.addLast("Monitor");

        // Adding Item in First place of the Deque
        deque.addFirst("Speaker");

        // Adding Item in Last place of the Deque
        deque.addLast("System Unit");

        // Print The Deque
        System.out.println("-- Print Deque --");
        System.out.println(deque);

        // Remove Item from Last place of the Deque
        deque.removeLast();

        // Remove Item from First place of the Deque
        deque.removeFirst();

        // Print The Deque after remove item
        System.out.println("");
        System.out.println("-- Print The Deque after remove item --");
        System.out.println(deque);

        deque.getFirst();
        deque.getLast();
    }
}

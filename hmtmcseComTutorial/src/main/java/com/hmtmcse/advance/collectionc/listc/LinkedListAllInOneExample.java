package com.hmtmcse.advance.collectionc.listc;


import java.util.LinkedList;
import java.util.List;

public class LinkedListAllInOneExample {

    public static void main(String[] args) {

        // Full Sentence: The Quick Brown Fox Jumps Over The Lazy Dog

        // Instantiate The ArrayList
        List<String> sentence = new LinkedList<>();

        // Add Items into LinkedList
        sentence.add("The");
        sentence.add("Brown");


        // Print Elements From the LinkedList
        System.out.println("------------ Prints Items ------------");
        for (String word : sentence){
            System.out.print(word + " ");
        }

        // Added Item into specific Index.
        sentence.add(1, "Quick");


        // Print Elements From the LinkedList After Added Item into Specific Index
        System.out.println("\n");
        System.out.println("-- Prints Items After Added Item into Specific Index --");
        for (String word : sentence){
            System.out.print(word + " ");
        }


        // Created New Sentence LinkedList without specify Data type
        List partialSentence = new LinkedList();
        partialSentence.add("Over");
        partialSentence.add("The");
        partialSentence.add("Lazy");
        partialSentence.add("Dog");


        // Added Multiple items into LinkedList
        sentence.addAll(partialSentence);

        // Print Elements From the LinkedList After Added New Items
        System.out.println("\n");
        System.out.println("-- Prints Items After Added New Items --");
        for (String word : sentence){
            System.out.print(word + " ");
        }

        // Remove All items from the PartialSentence LinkedList
        partialSentence.clear();


        // Again Adding new items into PartialSentence LinkedList
        partialSentence.add("Fox");
        partialSentence.add("Jumps");


        // Append Items into specific Index.
        sentence.addAll(3, partialSentence);


        // Print Elements From the LinkedList After Added Item into Specific Index
        System.out.println("\n");
        System.out.println("-- Prints Items After Added Items into Specific Index --");
        for (String word : sentence){
            System.out.print(word + " ");
        }


        // Removed Items From LinkedList
        sentence.removeAll(partialSentence);

        // Print Items After Removed Multiple Items.
        System.out.println("\n");
        System.out.println("-- Print Items After Removed Multiple Items. --");
        System.out.println(sentence);


        // Remove Item by Name
        sentence.remove("Over");

        // Remove Item by Index
        sentence.remove(3);
        sentence.remove(3);
        sentence.remove(3);


        // Print Items After Removed Single item
        System.out.println("");
        System.out.println("-- Print Items After Removed Single item. --");
        System.out.println(sentence);
    }

}

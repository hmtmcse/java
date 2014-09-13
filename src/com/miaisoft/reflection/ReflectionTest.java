package com.miaisoft.reflection;

/**
 * Created by Touhid Mia on 12/09/2014.
 */
public class ReflectionTest {

    int intField;
    String stringField;
    float floatField;
    boolean booleanField;

    public ReflectionTest(){
        System.out.println("Empty Argument Constructor..");
    }

    public ReflectionTest(String name){
        System.out.println("My Name is " + name);
    }


    public int addition(int a, int b){
        return a + b;
    }
    public int intOneParams(int a){
        return a + 10;
    }


    public int subtraction(int a, int b){
        return a - b;
    }

    public void helloWorld(){
        System.out.println("Welcome to HMTM World!");
    }
    public void methodWithString(String name){
        System.out.println("Welcome to " + name + " World!");
    }

    public void exceptionTest(){
        System.out.println("Welcome to HMTM World!");
    }
}

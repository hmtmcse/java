package com.hmtmcse.generics;

public class CastingExample {

    public static <T> T convertInstanceOfObject(Object o, Class<T> clazz) {
        try {
            return clazz.cast(o);
        } catch(ClassCastException e) {
            return null;
        }
    }

    public static void main(String[] args) {
        String k = convertInstanceOfObject(345435.34, String.class);
        System.out.println(k);
    }



}

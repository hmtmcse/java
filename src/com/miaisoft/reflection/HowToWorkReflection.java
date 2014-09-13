package com.miaisoft.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Touhid Mia on 12/09/2014.
 */
public class HowToWorkReflection {

    public static void main(String[] args) {
        HowToWorkReflection howToWorkReflection = new HowToWorkReflection();
        howToWorkReflection.getClassFromString();

    }

    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * Experiment With Method
     * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
     */
    public void getAllMethod() {
        Method[] methods = ReflectionTest.class.getMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }
    }

    public void getAllDeclaredMethod() {
        Method[] methods = ReflectionTest.class.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method = " + method.getName());
        }
    }

    public void getConstructor() {
        Constructor[] constructors = ReflectionTest.class.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("constructor = " + constructor.getName());
        }
    }


    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * Experiment With Fields
     * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
     */

    public void getAllFields() {
        Field[] fields = ReflectionTest.class.getFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getName());
        }
    }

    public void getAllDeclaredFields() {
        Field[] fields = ReflectionTest.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field.getName());
        }
    }


    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * Experiment With Class
     * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
     */

    public void getAllClassInformation() {
        Class aClass = ReflectionTest.class;

        System.out.println("Class Full Name = " + aClass.getName());
        System.out.println("Class Name = " + aClass.getSimpleName());
        System.out.println("Class Package Name = " + aClass.getPackage());

        Package aPackage = aClass.getPackage();
        Class superclass = aClass.getSuperclass();
        Class[] interfaces = aClass.getInterfaces();
    }


    public void getClassFromString() {
        try {
            Class aClass = Class.forName("com.miaisoft.reflection.ReflectionTest");
            System.out.println("Class Name = " + aClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * Experiment With Method
     * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
     */

    public void methodInvoke() {
        try {
            Class aClass = Class.forName("com.miaisoft.reflection.ReflectionTest");



            System.out.println("Class Name = " + aClass.getSimpleName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * Experiment With Method
     * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
     */


}

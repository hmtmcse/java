package com.miaisoft.reflection;

import sun.security.jca.GetInstance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Touhid Mia on 12/09/2014.
 */
public class HowToWorkReflection {

    public static void main(String[] args) {
        HowToWorkReflection howToWorkReflection = new HowToWorkReflection();
        howToWorkReflection.methodInvokeWhitException();

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
     * How to invoke method by reflection?
     * 1. Get class from String
     * 2. Then get instance from that class
     * 3. Collect declared method from class
     * 4. Method invoke by object and with his paramerte
     */

    public void methodInvoke() {
        try {
            Class aClass = Class.forName("com.miaisoft.reflection.ReflectionTest");
            Object object = aClass.newInstance();

            // No parameter Method.
            Method method = aClass.getDeclaredMethod("helloWorld", null);
            method.invoke(object, null);

            //Call Method with Single String parameter
            method = aClass.getDeclaredMethod("methodWithString", String.class);
            method.invoke(object, "MIA");

            //Call Method with Multiple integer parameter
            Class[] paramInt = new Class[2];
            paramInt[0] = Integer.TYPE;
            paramInt[1] = Integer.TYPE;
            Object[] paramsObject = {1, 1};
            method = aClass.getDeclaredMethod("addition", paramInt);
            System.out.println(method.invoke(object, paramsObject));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void methodInvokeWhitException() {
        try {
            Class aClass = Class.forName("com.miaisoft.exceptionHandling.ExceptionTester");
            Object object = aClass.newInstance();
            Class[] params = new Class[]{Integer.TYPE};

            Method method = aClass.getDeclaredMethod("doException",params);
            method.invoke(object,1);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // Here Printing The Exception Message.
            System.out.println(e.getCause().getMessage());
        }
    }


    /**
     * >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
     * Experiment With Method
     * <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
     */


}

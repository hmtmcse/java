package com.hmtmcse.annotations.example2;

import java.lang.reflect.Method;

public class AnnotationTest {

    public static void main(String[] args) {

        AnnotationRunner runner = new AnnotationRunner();
        Method[] methods = runner.getClass().getMethods();

        for (Method method : methods) {
            CanRun annotations = method.getAnnotation(CanRun.class);
            if (annotations != null) {
                try {
                    method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

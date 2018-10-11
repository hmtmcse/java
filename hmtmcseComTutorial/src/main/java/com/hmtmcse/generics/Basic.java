package com.hmtmcse.generics;

public class Basic {


    public static void main(String[] args) {
        GenericShape<Box> boxGenericShape = new GenericShape<>();
        Double height = boxGenericShape.get().height;


        try {
            GenericShapeInstance<Box> boxGenericShapeInstance = new GenericShapeInstance<>(Box.class);
            height = boxGenericShapeInstance.shapeInstance.height;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

}

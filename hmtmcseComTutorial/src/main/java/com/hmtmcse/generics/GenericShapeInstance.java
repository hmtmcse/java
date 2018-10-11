package com.hmtmcse.generics;

public class GenericShapeInstance<T> {


    private Class<T> shapeClass;
    public T shapeInstance;

    public GenericShapeInstance(Class<T> shapeClass) throws IllegalAccessException, InstantiationException {
        this.shapeClass = shapeClass;
        this.shapeInstance = shapeClass.newInstance();
    }



}

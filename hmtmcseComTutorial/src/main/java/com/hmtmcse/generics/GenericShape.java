package com.hmtmcse.generics;

public class GenericShape<T> {

    private T shape;

    public void add(T shape) {
        this.shape = shape;
    }

    public T get() {
        return shape;
    }

}

package com.hmtmcse.annotations.example1;

public class AnnotationTest {

    public static void main(String[] args) {
        try {
            Car car = new Car("Ford", "F150", "2018");
            JsonSerializer serializer = new JsonSerializer();
            serializer.serialize(car);
        } catch (JsonSerializeException e) {
            e.printStackTrace();
        }
    }
}

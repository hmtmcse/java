package com.hmtmcse.basic.consoletable;

/**
 * Created by touhid on 7/01/2016.
 */
public class Employee {


    private String name;
    private int age;
    private String hobby;
    private boolean married;
    private double salary;

    public Employee(String name, int age, String hobby, boolean married, double salary) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
        this.married = married;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public boolean isMarried() {
        return married;
    }

    public void setMarried(boolean married) {
        this.married = married;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

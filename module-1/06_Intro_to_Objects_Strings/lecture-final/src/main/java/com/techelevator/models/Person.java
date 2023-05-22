package com.techelevator.models;

public class Person {

    //State (the data that we want to keep track of)
    private String firstName;
    private String lastName;
    private int age;
    private int phone;
    private String email;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Behavior
    public void introduceSelf(){
        System.out.println("Hello, my name is "+ firstName + " " + lastName);
    }
}

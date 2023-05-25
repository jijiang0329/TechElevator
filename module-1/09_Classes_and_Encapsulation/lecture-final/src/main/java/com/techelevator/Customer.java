package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    //state
    //as a best practice, we always make class variables
    //private and then only allow access through getters and setters
    private String name;
    private int age;
    private List<BankAccount> bankAccounts = new ArrayList<>();

    //constructor
    public Customer(){

    }

    public Customer(String name, int age){
        this.name = name;
        this.age = age;
    }


    //getters and setters
    //getters - methods that will return the value of our variables
    //no creativity in naming, it's always getVariableName
    public String getName(){
        return name;
    }

    //setters - methods that will receive a new value to update our variables with
    //typically no return type, which means we just use void
    public void setName(String newName){
        //this is a keyword that refers to the class itself
        //name represents the parameter being passed in
        //this.name represents the class variable
        name = newName;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    //when writing a getter for a boolean
    //instead of saying getMinor we say isMinor for readability
    //Derived property - when instead of storing a variable in the background
    //we calculate on the fly each time
    public boolean isMinor(){
        return age < 18;
    }

    //behavior
    //methods that we write to let our class manipulate data or calculate something, anything we want to DO
    public void introduceSelf(){
        System.out.println("Hi my name is " + name);
    }

    public void addAccount(BankAccount account){
        this.bankAccounts.add(account);
    }

    public void listAccounts(){
        for(BankAccount account : this.bankAccounts){
            System.out.println(account.getName() + "-" + account.getAccountNumber());
        }
    }

    public static void helloWorld(){
        System.out.println("Hello World");
    }

}

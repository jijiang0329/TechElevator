package com.techelevator;

public class BankAccount {

    public static final String CHECKING = "Checking";
    public static final String SAVINGS = "Savings";

    private String name;
    private String accountNumber;
    private String ssn;

    //Constructors: always the same name as the class, can have multiple if we
    //accept different parameters(overloading), and they only run once
    public BankAccount(String name, String accountNumber){
        this.name = name;
        this.accountNumber = accountNumber;
    }

    public BankAccount(String name, String accountNumbers, String ssn){
        this.name=name;
        this.accountNumber = accountNumbers;
        this.ssn = ssn;
    }

    public BankAccount(){

    }

    public String getName(){
        return name;
    }

    //getter for the accountNumber
    //we can manipulate the data to only expose what we want
    public String getAccountNumber(){

        return "**********" + accountNumber.substring(accountNumber.length()-4);
    }

    //Notice I am intentionally not writing a setter for the account number
    //because I don't want anyone else to update it. It is what it is, and I only
    //want people to see the last 4 digits;
}

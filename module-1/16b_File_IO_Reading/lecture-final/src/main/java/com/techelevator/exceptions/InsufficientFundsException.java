package com.techelevator.exceptions;

public class InsufficientFundsException extends Exception{

    //state
    private int currentBalance;

    //constructor
    public InsufficientFundsException(String message){
        super(message);


    }

    //getters and setters
    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }
}

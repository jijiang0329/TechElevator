package com.techelevator;

import java.math.BigDecimal;

public class Transaction {

    //static variables
    public static final String WITHDRAWAL = "W";
    public static final String DEPOSIT = "D";

    //state
    //private variables
    private String type;
    private BigDecimal amount = BigDecimal.ZERO;
    private boolean promotion;

    //Constructor - determines how to initialize the class
    //            - we can have multiple so long as the parameters ar
    //            e different (overloading)
    public Transaction(){
        Main main = new Main();
    }

    public Transaction(String type, BigDecimal amount){
        this.type = type;
        this.amount = amount;

    }

    //getters and setters
    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    //when we are retrieving a boolean we use "is" instead of "get"
    public boolean isPromotion(){
        return promotion;
    }

    public void setPromotion(boolean promotion){
        this.promotion = promotion;
    }

    //behavior
    public void print(){
        System.out.println("Type: " + type + " Amount: " + amount);
    }

    public static BigDecimal addTransactions(Transaction t1, Transaction t2){
        return t1.getAmount().add(t2.getAmount());
    }
}

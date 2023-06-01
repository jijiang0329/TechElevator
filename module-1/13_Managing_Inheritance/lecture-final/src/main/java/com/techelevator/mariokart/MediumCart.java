package com.techelevator.mariokart;

public class MediumCart extends Racer{

    private static final int MAX_SPEED = 125;

    public MediumCart(String name){
        super(name, Racer.MEDIUM_CART);
    }

    public int getSpeed(){
        return (int)(MAX_SPEED * Math.random());
    }
}

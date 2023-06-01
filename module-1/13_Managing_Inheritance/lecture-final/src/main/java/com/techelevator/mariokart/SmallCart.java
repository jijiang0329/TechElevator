package com.techelevator.mariokart;

public class SmallCart extends Racer{

    private static final int MAX_SPEED = 175;

    public SmallCart(String name) {
        super(name, Racer.SMALL_CART);
    }


    @Override
    public int getSpeed(){
        return (int)(MAX_SPEED * Math.random());
    }
}

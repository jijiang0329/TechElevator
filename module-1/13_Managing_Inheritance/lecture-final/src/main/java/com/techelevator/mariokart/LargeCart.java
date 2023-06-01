package com.techelevator.mariokart;

public class LargeCart extends Racer{

    private static final int MAX_SPEED = 90;

    public LargeCart(String name){
        super(name, Racer.LARGE_CART);
    }

    @Override
    public int getSpeed() {
        return (int)(MAX_SPEED * Math.random());
    }
}

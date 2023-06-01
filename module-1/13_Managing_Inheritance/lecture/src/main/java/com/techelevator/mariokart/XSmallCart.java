package com.techelevator.mariokart;

public class XSmallCart extends Racer{
    private static final int MAX_SPEED = 225;
    public XSmallCart(String name) {
        super(name, Racer.EXTRA_SMALL_CART);
    }
    @Override
    public int getSpeed() {
        return (int) (MAX_SPEED * Math.random());
    }


}

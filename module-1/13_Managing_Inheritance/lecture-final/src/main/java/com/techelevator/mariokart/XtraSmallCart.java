package com.techelevator.mariokart;

public class XtraSmallCart extends Racer{

    private static final int MAX_SPEED = 225;

    public XtraSmallCart(String name){
        super(name , Racer.XTRA_SMALL_CART);
    }

    @Override
    public int getSpeed(){
        return (int)(MAX_SPEED * Math.random());
    }

    public void onWin(){
        System.out.println("Weeeee!");
    }
}

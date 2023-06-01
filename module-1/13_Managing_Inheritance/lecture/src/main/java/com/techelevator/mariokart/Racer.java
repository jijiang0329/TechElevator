package com.techelevator.mariokart;

public abstract class Racer implements Raceable{

    public static final String SMALL_CART = "S";
    public static final String MEDIUM_CART= "M";
    public static final String LARGE_CART="L";

    public static final String EXTRA_SMALL_CART = "XS";

    private String name;
    private String size;

    public Racer(String name, String size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return name;
    }
    public boolean isWin() {
        if (Racer racer )
    }

    public abstract int getSpeed();
}

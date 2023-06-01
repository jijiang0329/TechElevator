package com.techelevator.mariokart;

public abstract class Racer implements Raceable, Comparable<Racer>{

    public static final String SMALL_CART = "S";
    public static final String MEDIUM_CART= "M";
    public static final String LARGE_CART="L";
    public static final String XTRA_SMALL_CART = "XSMALL";

    private static final int MAX_SPEED = 90;

    private String name;
    private String size;

    public Racer(String name, String size){
        this.name = name;
        this.size = size;
    }

    public String getName(){
        return name;
    }

    public abstract int getSpeed();

    public int compareTo(Racer racer){

        return getSpeed() - racer.getSpeed();

    }

}

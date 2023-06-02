package com.techelevator;

public class Guitarist extends Person implements Musician{

    public Guitarist(String name){
        super(name);
    }

    @Override
    public String getInstrument() {
        return "Guitar";
    }

    @Override
    public String playInstrument() {
        return "Smoke On The Water";
    }
}

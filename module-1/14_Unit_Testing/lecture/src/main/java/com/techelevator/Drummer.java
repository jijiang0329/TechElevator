package com.techelevator;

public class Drummer extends Person implements Musician{

    public Drummer(String name){
        super(name);
    }

    @Override
    public String getInstrument() {
        return "Drums";
    }

    @Override
    public String playInstrument() {
        return "In The Air Tonight";
    }
}
package com.techelevator;

public class Drummer extends Person implements Musician{

    private int numYearsExperience;

    private String song;

    public Drummer(String name){
        super(name);
        song = "In The Air Tonight";
    }

    public Drummer(String name, String song){

        super(name);
        this.song = song;
    }

    @Override
    public String getInstrument() {
        return "Drums";
    }

    @Override
    public String playInstrument() {
        return song;
    }

    public int getNumYearsExperience(){
        return numYearsExperience;
    }

    public void setNumYearsExperience(int num){
        this.numYearsExperience = num;
    }

    //if you have 10 years or more experience, you are a superstar
    public boolean isSuperstar(){

        if(numYearsExperience >= 10){
            return true;
        }

        return false;

    }
}
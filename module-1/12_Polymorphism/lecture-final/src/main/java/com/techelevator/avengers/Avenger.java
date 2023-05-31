package com.techelevator.avengers;

public class Avenger {

    //class variables
    private String name;
    private String skill;
    private boolean flier;

    //constructor
  /*  public Avenger(){

    } */

    public Avenger(String name, String skill){
        this.name = name;
        this.skill = skill;
    }

    public boolean isFlier() {
        return flier;
    }

    //getters and setters
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getSkill(){
        return skill;
    }

    public void setSkill(String skill){
        this.skill = skill;
    }

    //behavior
    public void assemble(){
        System.out.println("I am an Avenger "+name+" and I can " + skill + "!");
    }


}

package com.techelevator.avengers;

public class Avenger {

    //class variables
    private String name;
    private String skill;
    private int health;

    //constructor
  /*  public Avenger(){

    } */

    public Avenger(String name, String skill){
        this.name = name;
        this.skill = skill;
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

    public int getHealth(){
        return health;
    }

    //behavior
    public void assemble(){
        System.out.println("I am an Avenger and I can " + skill + "!");
    }

    public int addToHealth(int boost){
        health += boost;
        return health;
    }

    public int deductFromHealth(int deduction){
        health -= deduction;
        return health;
    }

}

package com.techelevator.avengers;

import java.io.Serializable;

public class IronMan extends Avenger implements Flyable {

    private int durability;

    public IronMan(){
        super("Iron Man", "Super suit, billionaire, philanthropist");

    }

    public int getDurability(){
        return durability;
    }
    public void setDurability(int durability){
        this.durability = durability;
    }

    @Override
    public void assemble(){
        System.out.println("I am " + getName());
        super.assemble();
    }

    public void fly(){
        System.out.println("I'm flying using jets!");
    }

}

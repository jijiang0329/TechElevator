package com.techelevator.avengers;

public class IronMan extends Avenger{

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

}

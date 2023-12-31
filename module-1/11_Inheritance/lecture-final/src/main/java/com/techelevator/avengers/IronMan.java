package com.techelevator.avengers;

public class IronMan extends Avenger{

    private static final int EXTRA_DAMAGE = 5;

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


    @Override
    public int deductFromHealth(int deduction){

        //if we are below 50 then shields are down and we take
        //an additional 5 points of damage
        super.deductFromHealth(deduction);
        if(getHealth() < 50 ) {
            super.deductFromHealth(EXTRA_DAMAGE);
        }

        return getHealth();

    }

}

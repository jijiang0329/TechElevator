package com.techelevator.avengers;

public class Thor extends Avenger implements Flyable{

    private boolean worthy;

    public Thor(boolean worthy){
        super("Thor", "Wield The Mighty Hammer");
        this.worthy = worthy;
    }

    @Override
    public void assemble(){

        if(worthy){
            super.assemble();
        } else {
            System.out.println("I cannot lift my hammer. *Cries*");
        }
    }

    public void fly(){
        if(worthy){
            System.out.println("I am flying with my hammer!");
        } else {
            System.out.println("I cannot lift my hammer. *Cries*");
        }
    }
}

package com.techelevator.avengers;

public class Thor extends Avenger{

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


}

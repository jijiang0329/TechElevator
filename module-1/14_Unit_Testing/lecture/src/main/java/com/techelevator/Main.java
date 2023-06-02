package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Band myBand = new Band("");

        List<Person> myFriends = new ArrayList<>();
        myFriends.add(new Person("Joe"));
        myFriends.add(new Guitarist("Ken"));
        myFriends.add(new Drummer("Bill"));

        for(Person p : myFriends){
            if(p instanceof Musician){
                myBand.joinBand((Musician)p);
            }
        }

        System.out.println("Band Members:");
        for(Musician m : myBand.getMembers()){
            System.out.println(m.getName() + " plays " + m.getInstrument() + " and rocks " + m.playInstrument());
        }

    }

}

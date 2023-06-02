package com.techelevator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*

        BigDecimal Overview:
         */
        int balance = 0;
        balance += 1;
        balance -= 1;

        // A few different ways to declare big decimal:

        //Sometimes it may be a constant we can use, for instance ZERO
        BigDecimal balance2 = BigDecimal.ZERO;

        //Or we can use BigDecimal.valueOf and pass in a number that way,
        //but this can still result in strange rounding issues
        BigDecimal balance3 = BigDecimal.valueOf(3.14);

        //Or I prefer using the constructor and passing a string, that way it avoids
        //all possibility of weird double rounding issues
        BigDecimal balance4 = new BigDecimal("3.14");

        //To add to a big decimal we use the add method
        balance4 = balance4.add(balance3);

        //To subtract from a big decimal we use the .subtract
        balance4 = balance4.subtract(balance3);


        //To check if a big decimal is larger, smaller, or equal to another big decimal use compare
        if(balance4.compareTo(balance3) == 0){
            System.out.println("They are equal");
        } else if (balance4.compareTo(balance3) > 0) { //or we can check that it equals exactly 1
            System.out.println("Balance 4 is greater than balance 3");
        } else if (balance4.compareTo(balance3) < 0) { //or we can check that it equals exactly -1
            System.out.println("Balance 3 is greater than balance 4");
        }




        Band myBand = new Band("Christopher & The Coders");

        List<Person> myFriends = new ArrayList<>();
        myFriends.add(new Person("Joe"));
        myFriends.add(new Guitarist("Ken"));
        myFriends.add(new Drummer("Bill"));
        myFriends.add(new Drummer("Jill", "Back In Black"));

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

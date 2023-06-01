package com.techelevator.mariokart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        //Data Type(Racer)
        //Variable Name (myRacer)
        //The value (instantiating / initializing an object)
        Racer myRacer = new SmallCart("Baby Mario");
       // myRacer.


        /**
         * Implement a new extra small cart for baby mario and baby luigi
         * and add them to the list of racers below.
         *
         * 1. They should be able to go 225 mph
         * 2. A large cart will bump them
         * 3. When an extra small cart wins, have it declare "weeeee!"
         */


        List<Racer> racers = new ArrayList<>();

        racers.add(new XtraSmallCart("Baby Mario"));
        racers.add(new XtraSmallCart("Baby Luigi"));

        racers.add(new SmallCart("Yoshi"));
        racers.add(new SmallCart("Toadstool"));

        racers.add(new MediumCart("Mario"));
        racers.add(new MediumCart("Luigi"));
        racers.add(new MediumCart("Princess Peach"));

        racers.add(new LargeCart("Bowser"));
        racers.add(new LargeCart("Wario"));


        for(int i=0; i < 3; i++){

            System.out.println("");
            System.out.println("Round " + (i+1));

            Collections.sort(racers);
            Collections.reverse(racers);
            racers.get(0).compareTo(racers.get(1));

            for(int j = racers.size()-1; j >= 0; j--){

                Racer currentRacer = racers.get(j);

                if(currentRacer instanceof LargeCart && j > 0) {

                    Racer racerGettingPassed = racers.get(j-1);
                    if(racerGettingPassed instanceof SmallCart
                    || racerGettingPassed instanceof XtraSmallCart) {
                        racers.remove(j);
                        racers.add(j - 1, currentRacer);
                        System.out.println(currentRacer.getName() + " is bumping aside " + racerGettingPassed.getName());
                    }
                }

                System.out.println("In " + (j+1) + " place is " + racers.get(j).getName());
            }

            if(racers.get(0) instanceof XtraSmallCart){
               XtraSmallCart x = (XtraSmallCart) racers.get(0);
               x.onWin();
            }
        }

        System.out.println("");
        System.out.println(racers.get(0).getName() + " Wins!");



    }
}

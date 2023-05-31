package com.techelevator.mariokart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Raceable> racers = new ArrayList<>();

        racers.add(new SmallCart("Yoshi"));
        racers.add(new SmallCart("Toadstool"));

        racers.add(new MediumCart("Mario"));
        racers.add(new MediumCart("Luigi"));
        racers.add(new MediumCart("Princess Peach"));

        racers.add(new LargeCart("Bowser"));
        racers.add(new LargeCart("Wario"));

        racers.add(new BlueShell());

        for(int i=0; i < 3; i++){

            System.out.println("");
            System.out.println("Round " + (i+1));

            Collections.shuffle(racers);
            for(int j = racers.size()-1; j >= 0; j--){

                Raceable currentRacer = racers.get(j);

                if(currentRacer instanceof LargeCart && j > 0) {

                    Raceable racerGettingPassed = racers.get(j-1);
                    if(racerGettingPassed instanceof SmallCart) {
                        racers.remove(j);
                        racers.add(j - 1, currentRacer);
                        System.out.println(currentRacer.getName() + " is bumping aside " + racerGettingPassed.getName());
                    }
                }

                System.out.println("In " + (j+1) + " place is " + currentRacer.getName());
            }

        }

        System.out.println("");
        System.out.println(racers.get(0).getName() + " Wins!");



    }
}

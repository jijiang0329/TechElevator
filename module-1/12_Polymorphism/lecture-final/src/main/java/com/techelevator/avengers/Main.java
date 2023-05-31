package com.techelevator.avengers;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Thor thor = new Thor(true);
        IronMan ironMan = new IronMan();
        SheHulk sheHulk = new SheHulk();
        IncredibleHulk incredibleHulk = new IncredibleHulk();

        List<Avenger> team = new ArrayList<>();
        team.add(ironMan);
        team.add(sheHulk);
        team.add(incredibleHulk);
        team.add(thor);

        for(Avenger avenger : team){
            avenger.assemble();

            if(avenger instanceof Flyable){
                Flyable flier = (Flyable) avenger;
                flier.fly();
            }

        }

    }
}

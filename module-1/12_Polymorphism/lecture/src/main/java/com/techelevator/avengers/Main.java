package com.techelevator.avengers;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Thor thor = new Thor(false);
        thor.assemble();


        IronMan ironMan = new IronMan();
        ironMan.assemble();

        SheHulk sheHulk = new SheHulk();
        sheHulk.smash();
        sheHulk.assemble();

        IncredibleHulk incredibleHulk = new IncredibleHulk();
        incredibleHulk.smash();
        incredibleHulk.assemble();

        //Object obj = new Object();

        List<Avenger> team = new ArrayList<>();
        team.add(ironMan);
        team.add(sheHulk);
        team.add(incredibleHulk);
        Team superheros = new Team(team);

    }
}

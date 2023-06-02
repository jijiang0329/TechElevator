package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Band {

    private String bandName;
    private List<Musician> members = new ArrayList<>();

    public Band(String bandName){
        this.bandName = bandName;
    }

    public String getBandName() {
        return bandName;
    }

    public void setBandName(String bandName) {
        this.bandName = bandName;
    }

    public List<Musician> getMembers() {
        return members;
    }

    public void setMembers(List<Musician> members) {
        this.members = members;
    }

    public void joinBand(Musician musician){
        this.members.add(musician);
    }
}

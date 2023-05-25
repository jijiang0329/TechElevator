package com.techelevator;

public class Elevator {
    private int currentFloor = 1;
    private int numberOfFloors;
    private boolean doorOpen;

    public Elevator(int numberOfLevels) {
        numberOfFloors = numberOfLevels;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public void openDoor() {
        doorOpen = true;
    }
    public void closeDoor() {
        doorOpen = false;
    }
    public void goUp(int desiredFloor) {
        if (!doorOpen &&  desiredFloor <= getNumberOfFloors() && desiredFloor > getCurrentFloor()) {
            currentFloor = desiredFloor;
        }
    }
    public void goDown(int desiredFloor) {
        if (!doorOpen &&  desiredFloor > 0 && desiredFloor < getCurrentFloor()) {
            currentFloor = desiredFloor;
        }
    }
}

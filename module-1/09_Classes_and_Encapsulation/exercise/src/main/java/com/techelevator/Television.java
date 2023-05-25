package com.techelevator;

public class Television {
    private boolean isOn = false;
    private int currentChannel = 3;
    private int currentVolume = 2;

    public boolean isOn() {
        return isOn;
    }

    public int getCurrentChannel() {
        return currentChannel;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

   public void turnOff() {
        isOn = false;
   }
    public void turnOn() {
        isOn = true;
        currentChannel = 3;
        currentVolume = 2;
    }
    public void changeChannel(int newChannel) {
        if (isOn && newChannel>=3 && newChannel <= 18) {
            currentChannel = newChannel;
        } else
            currentChannel = 18;
    }
    public void channelUp() {
        changeChannel(currentChannel + 1);
    }
    public void channelDown() {
        changeChannel(currentChannel - 1);
    }
    public void raiseVolume() {
        if (isOn && currentVolume>=0 && currentVolume < 10) {
            currentVolume++;
        }

    }
    public void lowerVolume() {
        if (isOn && currentVolume>0 && currentVolume <= 10) {
            currentVolume--;
        }
    }

}

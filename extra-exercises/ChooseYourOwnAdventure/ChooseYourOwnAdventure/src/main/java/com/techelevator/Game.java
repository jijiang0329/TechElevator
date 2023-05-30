package com.techelevator;

import com.techelevator.menu.MenuDisplay;
import com.techelevator.rooms.BlueRoom;
import com.techelevator.rooms.GreenRoom;
import com.techelevator.rooms.RedRoom;

public class Game {

    private static final String INTRO = "You are in the lobby of a haunted mansion!";

    private static final String OPTION_RED = "Go to red room";
    private static final String OPTION_BLUE = "Go to blue room";
    private static final String OPTION_GREEN = "Go to green room";
    private static final String OPTION_EXIT = "Exit";
    private static final String[] OPTIONS = {OPTION_RED, OPTION_BLUE, OPTION_GREEN, OPTION_EXIT};

    private BlueRoom blueRoom = new BlueRoom();
    private RedRoom redRoom = new RedRoom();
    private GreenRoom greenRoom = new GreenRoom();

    public static void main(String[] args) {


        Game game = new Game();
        game.beginGame();

    }

    public void beginGame() {

        Player player = new Player();

        while(true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_RED)){
                redRoom.onEnterRoom(player);
            }else if(selectedOption.equals(OPTION_BLUE)){
                blueRoom.onEnterRoom(player);
            }else if(selectedOption.equals(OPTION_GREEN)){
                greenRoom.onEnterRoom(player);
            } else {
                System.out.println("Goodbye!");
                break;
            }


        }

    }

}

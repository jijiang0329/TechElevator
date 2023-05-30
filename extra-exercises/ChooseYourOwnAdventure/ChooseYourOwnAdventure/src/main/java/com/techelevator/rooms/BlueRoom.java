package com.techelevator.rooms;

import com.techelevator.menu.MenuDisplay;
import com.techelevator.Player;
import com.techelevator.constants.GameConstants;

public class BlueRoom {

    private static final String INTRO = "Welcome to the blue room! There is a box sitting on a table. Do you open it?";

    private static final String OPTION_1 = "Yes, open the box";
    private static final String OPTION_2 = "Leave room";
    private static final String[] OPTIONS = {OPTION_1, OPTION_2};

    public void onEnterRoom(Player player) {

        while(true) {

            System.out.println(INTRO);

            String selectedOption = MenuDisplay.prompt(OPTIONS);
            if(selectedOption.equals(OPTION_1)){
                onOpenBox(player);
            }else if(selectedOption.equals(OPTION_2)){
                System.out.println("You exit the room");
                break;
            }


        }

    }

    private void onOpenBox(Player player) {
        System.out.println("Congratulations! You found a red key!");
        player.addItem(GameConstants.RED_KEY);
    }

}

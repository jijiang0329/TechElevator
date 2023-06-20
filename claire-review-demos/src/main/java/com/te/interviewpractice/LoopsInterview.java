package com.te.interviewpractice;

public class LoopsInterview {




    // Tell me what it's doing
    public static void spicyForLoop2(){
        for(int i = 49; i < 100; i++) {
            System.out.println(i + " - " + (char)(i));
        }
    }






    // Challenge - Tell me what it's doing
    public static void spicyForLoop3(){
        for(char i = 'a'; (int)i < 100; i = (char)(((int)i) + 1 ))  {
            System.out.println(i);
        }
    }





    // Turn this into a while loop
    public static void spicyForLoop1() {
        String[] lyrics = {"never", "gonna", "give", "you", "up"};
        for(int i = 0; i < lyrics.length; i++) {
            System.out.println(lyrics[i].toUpperCase());
        }
    }

    // Challenge
    public static void calculateChessHorse() {

    }
}

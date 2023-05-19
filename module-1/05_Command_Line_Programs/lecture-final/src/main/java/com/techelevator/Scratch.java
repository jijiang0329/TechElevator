package com.techelevator;

import java.util.Scanner;

public class Scratch {

    public static void main(String[] args) {

        System.out.println("Hello World!");

        //The scanner is subscribing to a streaming service, in this case System.in
        //which represents streaming data from the console
        Scanner scanner = new Scanner(System.in);

        System.out.print("What's your name?");
        String name = scanner.nextLine(); //the application is going to pause and wait for the user
                                            //to enter some text in the console
                                          //nextLine() will always pull in a string and take care of a newline character
                                            //nextInt() and others don't handle the newline character, so avoid

        System.out.println("Hello, " + name + "!");

        System.out.println("How old are you?");
        String strAge = scanner.nextLine();

        int age = Integer.parseInt(strAge);
        int birthYear = 2023 - age;
        System.out.println("You were born in " + birthYear);

        System.out.println("What are some of your numbers? (Comma separated)");

        //The Ring,Everything Everywhere All At Once,Batman Begins

        String movies = scanner.nextLine();
        String[] moviesArray = movies.split(",");
        for(int i = 0; i < moviesArray.length; i++){
            int num = Integer.parseInt(moviesArray[i]);
            System.out.println(num + " is a great movie, you have great taste!");
        }

        System.out.println("Do you like Marvel movies? (Y or N)");
        String response = scanner.nextLine();

        //Because a string is considered an object in java, we cannot do == instead use .equals or .equalsIgnoreCase for case insensitive
        if(response.equalsIgnoreCase("Y") ) {
            System.out.println("Good for you");
        }

    }
}

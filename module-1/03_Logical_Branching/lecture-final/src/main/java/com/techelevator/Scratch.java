package com.techelevator;

public class Scratch {

    static String name = "Christopher";

    //psvm
    public static void main(String[] args) {

        //sout
       //System.out.println();


        //Comparison operators will compare two values (equal to, not equal to, less than, greater than, less than or equal, and greater than or equal)
        // They will result in a boolean value
        int age = 10;
        boolean eligibleToDrive = age >= 16;

        int pinNumber = 9876;
        boolean canAccessAccount = pinNumber == 1234;

        int floorNumber = 10;
        boolean isFloorSafe = floorNumber != 13;

        //THIS DOES NOT WORK FOR STRINGS
        String myName = "Christopher";
       // boolean isAnInstructor = myName == "Christopher"; //the == does not work on strings because they are objects.
                                                            //Comparison operators should only be used with primitives
        boolean isAnInstructor = myName.equals("Christopher");


        //Logical Operators compare two boolean values and also result in a boolean value
        boolean hasPermit = true;

        // && means AND, which means that all the booleans on either side must be true for the result to be true
        boolean canDrive = (age >= 15) && hasPermit;

        boolean hasUber = true;

        // || means OR, which means that at least one of the booleans on either side must be true for the result to be true
        boolean isGoingToTheParty = hasUber || canDrive;

        // if we want to find the opposite value of a boolean then we use !
        boolean isNotGoingToTheParty = !isGoingToTheParty;


        //Scope
        //Brackets will define the scope of a variable
        //You can nest brackets inside of other brackets
        //Once you reach the closing bracket, all the variables declared in that scope will be forgotten
        //We call these code blocks, or just blocks
        {
           String spiderman = "Andrew Garfield";
            {
                String greenGoblin = "Willem Dafoe";
                System.out.println("Spiderman in scope:" + spiderman);
                System.out.println("Green Goblin:" + greenGoblin);
                System.out.println("My name is " + name);
            }
            // greenGoblin is out of scope at this point
           // System.out.println(greenGoblin);
        }
        {
            String spiderman = "Tom Holland";
        }
        {
            String spiderman = "Toby McGuire";
        }

        // Conditional Logic
        //If statements: Only run this code if something is true
        if ( true ) {
            //code block only runs if condition inside parentheses is true
        }

        //if-else statement: Only run this code if something is true, otherwise do something else
        if ( true ) {
            //code block only runs if condition inside parentheses is true
        } else {
            //run this code block if nothing else was true up until this point
        }

        //if-else if-else: We can check if multiple things are true, and if none of them are true we run the else
        if ( true ) {
            //code block only runs if condition inside parentheses is true
        } else if ( true ) {
            //code block only runs if condition inside parentheses is true
        } else if ( true ) {
            //code block only runs if condition inside parentheses is true
        }
        else {
            //run this code block if nothing else was true up until this point
        }


        //In an if statement, as soon as one condition is true and a code block runs, it does not look at any others

        //Fizz Buzz
        //if a number is divisible by 3 we print fizz
        //if a number is divisible by 5 we print buzz
        //if a number is divisible by 3 and 5 we print fizz buzz

        int number = 15;
        boolean divisibleBy3 = number % 3 == 0;
        boolean divisibleBy5 = number % 5 == 0;

        if (divisibleBy3  && divisibleBy5) {
            System.out.println("FizzBuzz");
        }
        else if(divisibleBy3) { //this checks if the number is divisible by three by verifying there is no remainder
            System.out.println("Fizz");
        }

       else if (divisibleBy5) { //this checks if the number is divisible by 5
            System.out.println("Buzz");
        }


    }
}

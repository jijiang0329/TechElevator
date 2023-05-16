package com.techelevator;

public class HelloWorld {

    public static void main(String[] args){

        //To declare a variable we indicate the
        //datatype variableName = value
        String firstName = "Christopher";

        //for variable names with mulitple words in it
        //we do camel casing which is where the first word
        //is lower case and all the words after start with a capital
        int numberOfMarvelMovies;
        numberOfMarvelMovies = 1000000;

        //We can also make a variable a constant by using the keyword final
        //constants are useful because we can indicate this value will never change
        //and prevent any developers from accidentally assigning a new value to it later
        //its variable name does not follow camel case but instead all caps with underscores
        final int NUM_OF_MONTHS_IN_YEAR = 12;


        //This will result in 2, because an int cannot hold a decimal
        int intResult = 5/2;

        //This will still be 2, because 5 and 2 are ints. An int divided by an int will result in an int
         // because the result of 5/2 is an int but the datatype is double, an implicit cast is occuring
        //changing the int to a data type of double
        double dblResult = 5/2;

        //In order for the decimal to come through, we need to make one of the values a double
        double result = 5.0/2;
        System.out.println("Our result is " + result);

        //if I want to change the result above from a double to an integer, I can explicitly cast it
        intResult = (int)result;

        float myFloat = 2.5f;
        double dblValue = myFloat;
        float floatValue = (float)dblValue;

        int remainder = 10 % 7;
        System.out.println("Our remainder is " + remainder);

        /*
        This is a
        multiline
        comment
         */
        System.out.println("Hello World");
        System.out.println("Hi my name is " + firstName);
        System.out.println(5);
    }

}

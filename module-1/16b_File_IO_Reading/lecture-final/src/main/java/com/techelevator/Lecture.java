package com.techelevator;

import com.techelevator.exceptions.InsufficientFundsException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.techelevator.exceptions.*;

public class Lecture {

    public static void main(String[] args) throws Exception {

        /*
        Integer myInt = null;
        int myPrimitiveInt = 0;

        //String fileName = ""; empty string is still a value

         */

        String fileName = null;

       // fileName.toLowerCase();

        System.out.println("Before try catch");

        //The code we are concerned about we can wrap in this try, and then the catches below will
        //catch any exception that gets thrown
        try {
            System.out.println("At beginning of try");
            List<String> myValues = new ArrayList<>();
            myValues.add("A");

           // myValues.get(10);

            System.out.println("At end of try");

        }
        //We can have multiple catches, the first one that our exception matches will run that code block and no others. Similar
        // to a if-else if- else
        //    Datatype                  variable
        catch(IndexOutOfBoundsException ex){
            System.out.println("You are trying to pull from an index that does not exist.");
        }
        //Exception is the parent class to all exceptions. A child class IS-A parent, so all exceptions are type Exception.
        //This catch will catch anything that goes wrong if it hasn't already been caught
        catch(Exception ex) {
            System.out.println("Something went wrong");

        }
        finally{
            System.out.println("This runs whether there was an exception or not");
        }

        System.out.println("Outside of try catch");



        ///Instead of using if-else for the withdraw logic like we did last week
        int balance = 10;
        int amountToWithdraw = 20;
        try{
            int newBalance = balance - amountToWithdraw;
            if(newBalance < 0 && newBalance > -100){
                //we can explicitly throw exceptions too
                throw new OverdraftException("Your new balance is negative", newBalance);
            } else if(newBalance <= -100){
                throw new InsufficientFundsException("You are withdrawing too much");
            }
        }
        catch(OverdraftException ex) {
            System.out.println("You've incurred a fee for overdrawing");
            //withdraw(ex.getOverdraftAmount() + 10);
        }
        catch(Exception ex){
            System.out.println("Something went wrong");
        }

        demonstrateException(false);


    }


    public static void demonstrateException(boolean throwException) throws OverdraftException, InsufficientFundsException {

        if(throwException){
            throw new InsufficientFundsException("Demonstrating an exception");
        } else {
            throw new OverdraftException("Demonstrating a second exception", 0);
        }

    }
}

package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CancelCheck {

    public static void main(String[] args) {

        List<String> checks = new ArrayList<>();

        //When we are reading from a file, there are a few steps

        //1. First, get the string of the file path (either hardcoded, or prompt from console)
        String filePath = "rtn.txt";

        //2. Create a file object from the file path
        File file = new File(filePath);

        //3. Create a scanner to read the file just like we created a scanner to read from the console
        //   We can use a try-with-resources block
        try(Scanner fileScanner = new Scanner(file)) {

            //4. To keep reading each line of the file one at a time, in a loop
            //   keep checking if there is a new line to read
            int counter = 1;
            while(fileScanner.hasNextLine()){

                //5. Actually read the line from the file
                String line = fileScanner.nextLine();
                checks.add(line);
                System.out.println(counter + ") " + line);
                counter++;
            }

        } catch(Exception ex){
            System.out.println("Error reading from file");
        }

        System.out.println("Which check do you need to cancel?");

        Scanner consoleInput = new Scanner(System.in);
        String checkNumStr = consoleInput.nextLine();

        try {
            int checkNum = Integer.parseInt(checkNumStr);
            String check = checks.get(checkNum - 1); //we subtract 1 so that it corresponds to the index
            System.out.println("Check " + check + " has been cancelled");
        } catch(NumberFormatException ex){
            System.out.println("PLease enter the digit corresponding to the check - only numbers");
        } catch(IndexOutOfBoundsException ex){
            System.out.println("Please enter a valid number");
        } catch(Exception ex){
            System.out.println("Something went wrong, and I blame you");
        }

    }
}

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Budget {

    public static void main(String[] args) {

        Map<String, Integer> budgetMap = new HashMap<>();

        System.out.println("Please enter the file path");

        //To read from a file, there are a few steps we always take:
        //1. Store the filePath as a string
        Scanner consoleInput = new Scanner(System.in);
        String filePath = consoleInput.nextLine();

        //2. Create a new file object from the file path
        File file = new File(filePath);

        //3. Declare a scanner that will read the file
        //    this is typically done in a try-with-resources
        try(Scanner fileScanner = new Scanner(file)){

            //4. Loop through the file and keep reading as long as there
            //are lines to read
            while(fileScanner.hasNextLine()){

                //5. Read the line from the file
                String line = fileScanner.nextLine();

                String[] lineParts = line.split(" ");

                //get the category from the first part
                String category = lineParts[0].toLowerCase();

                //get teh amount from the second
                String amountStr = lineParts[1];
                int amount = Integer.parseInt(amountStr);

                if(budgetMap.containsKey(category)) {
                    int currentAmount = budgetMap.get(category);
                    budgetMap.put(category, currentAmount + amount);
                } else {
                    budgetMap.put(category, amount);
                }

            }

        } catch(FileNotFoundException ex){
            System.out.println("Unable to find file");
        } catch(Exception ex){
            System.out.println("Something went wrong");
        }

        for(Map.Entry<String, Integer> entry : budgetMap.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}

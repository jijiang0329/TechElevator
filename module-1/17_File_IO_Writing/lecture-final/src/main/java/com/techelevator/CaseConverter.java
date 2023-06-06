package com.techelevator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.PrintWriter;

public class CaseConverter {

    public static void main(String[] args) {

        System.out.println("Please enter the file name you want to convert:");

        Scanner consoleInput = new Scanner(System.in);
        String fileName = consoleInput.nextLine();

        System.out.println("Indicate if you want to convert to (U)ppercase or (L)owercase");
        String caseConvert = consoleInput.nextLine();

        File inputFile = new File(fileName);
        File outputFile = new File(caseConvert + fileName);

        //We can use multiple resources in our try-with-resources block
        //we just have to separate them with semi-colons
        //NOTE: We can read from one file and write to another, but DO NOT read and write from the same file
        try(PrintWriter writer = new PrintWriter(outputFile);
            Scanner fileScanner = new Scanner(inputFile);
        ){

            while(fileScanner.hasNextLine()){

                String line = fileScanner.nextLine();

                if(caseConvert.equalsIgnoreCase("U")){
                    writer.println(line.toUpperCase());
                } else {
                    writer.println(line.toLowerCase());
                }

            }

        } catch(Exception ex){
            System.out.println("Something went wrong");
        }
    }
}

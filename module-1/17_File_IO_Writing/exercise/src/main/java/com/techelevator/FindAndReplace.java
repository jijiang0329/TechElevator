package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        try {
            findAndReplace.run();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() throws FileNotFoundException {
        /* Your code goes here */
        System.out.println("What is the search word?");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?");
        String replaceWord = userInput.nextLine();

        System.out.println("What is the source file?");
        String filePath = userInput.nextLine();
        File inputFile = new File(filePath);

        System.out.println("What is the destination file?");
        File outputFile = new File(userInput.nextLine());


        try(Scanner fileSource = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile)) {

            while (fileSource.hasNextLine()) {
                String lineText = fileSource.nextLine();
                if (lineText.contains(searchWord))
                    writer.println(lineText.replace(searchWord, replaceWord));
                else
                    writer.println((lineText));
            }

        } catch (FileNotFoundException ex) {
            System.out.println("You are wrong!");
        }

    }

}

package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner userInput = new Scanner(System.in);
//        System.out.print("File name: ");
//        String filePath = userInput.nextLine();
//        File file = new File(filePath);
//
//        try(PrintWriter writer = new PrintWriter(file)) {
//
//            writer.println("apple Bacon coconut bacon");
//            writer.println("bread bacon Apple cherry");
//
//        } catch (Exception ex) {
//            System.out.println("You are so wrong!");
//        }

//        Scanner userInput = new Scanner(System.in);
//        System.out.print("File name: ");
//        String filePath = userInput.nextLine();
//        File file = new File(filePath);
//
//        try(PrintWriter writer = new PrintWriter(file)) {
//
//            writer.println("3");
//            writer.println("15");
//
//        } catch (Exception ex) {
//            System.out.println("You are so wrong!");
//        }

        FizzWriter fizz = new FizzWriter();
        fizz.run();
    }
}

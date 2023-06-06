package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Encrypt {

    public static void main(String[] args) {

        Map<String, Integer> encryptionMap = new HashMap<>();
        encryptionMap.put(" ", 0);
        encryptionMap.put("A", 1);
        encryptionMap.put("B", 2);
        encryptionMap.put("C", 3);
        encryptionMap.put("D", 4);
        encryptionMap.put("E", 5);
        encryptionMap.put("F", 6);
        encryptionMap.put("G", 7);
        encryptionMap.put("H", 8);
        encryptionMap.put("I", 9);
        encryptionMap.put("J", 10);
        encryptionMap.put("K", 11);
        encryptionMap.put("L", 12);
        encryptionMap.put("M", 13);
        encryptionMap.put("N", 14);
        encryptionMap.put("O", 15);
        encryptionMap.put("P", 16);
        encryptionMap.put("Q", 17);
        encryptionMap.put("R", 18);
        encryptionMap.put("S", 19);
        encryptionMap.put("T", 20);
        encryptionMap.put("U", 21);
        encryptionMap.put("V", 22);
        encryptionMap.put("W", 23);
        encryptionMap.put("X", 24);
        encryptionMap.put("Y", 25);
        encryptionMap.put("Z", 26);

        System.out.println("PLease enter a file name");

        Scanner consoleInput = new Scanner(System.in);
        String fileName = consoleInput.nextLine();

        File fileInput = new File(fileName);
        File fileOutput = new File("encoded_"+fileName);

        try(Scanner fileScanner = new Scanner(fileInput); PrintWriter writer = new PrintWriter(fileOutput)){

            while(fileScanner.hasNextLine()){
                String line = fileScanner.nextLine().toUpperCase();

                for(char currentChar : line.toCharArray()){

                    Integer code = encryptionMap.get(String.valueOf(currentChar));
                    writer.print(String.format("%02d",code) + " ");

                }

                writer.println("");

            }

        } catch(Exception ex){
            System.out.println("Something's gone wrong");
        }

    }

}

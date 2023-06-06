package com.techelevator;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Decrypt {

    public static void main(String[] args) {

        Map<Integer, String> encryptionMap= new HashMap<>();
        encryptionMap.put(0, " ");
        encryptionMap.put(1, "A");
        encryptionMap.put(1,"A");
        encryptionMap.put(2,"B");
        encryptionMap.put(3,"C");
        encryptionMap.put(4,"D");
        encryptionMap.put(5,"E");
        encryptionMap.put(6,"F");
        encryptionMap.put(7,"G");
        encryptionMap.put(8,"H");
        encryptionMap.put(9,"I");
        encryptionMap.put(10,"J");
        encryptionMap.put(11,"K");
        encryptionMap.put(12,"L");
        encryptionMap.put(13,"M");
        encryptionMap.put(14,"N");
        encryptionMap.put(15,"O");
        encryptionMap.put(16,"P");
        encryptionMap.put(17,"Q");
        encryptionMap.put(18,"R");
        encryptionMap.put(19,"S");
        encryptionMap.put(20,"T");
        encryptionMap.put(21,"U");
        encryptionMap.put(22,"V");
        encryptionMap.put(23,"W");
        encryptionMap.put(24,"X");
        encryptionMap.put(25,"Y");
        encryptionMap.put(26,"Z");

        System.out.println("Please enter a filename");

        Scanner consoleInput = new Scanner(System.in);
        String fileName = consoleInput.nextLine();

        File fileInput = new File(fileName);
        File fileOutput = new File("decoded_"+fileName.replace("encoded_", ""));

        try(Scanner fileScanner = new Scanner(fileInput); PrintWriter writer = new PrintWriter(fileOutput)){

            while(fileScanner.hasNextLine()){

                String line = fileScanner.nextLine();

                String[] lineParts = line.split(" ");
                for(String str : lineParts){
                    Integer code = Integer.parseInt(str);
                    String letter = encryptionMap.get(code);
                    writer.print(letter);
                }

                writer.println("");
            }

        } catch(Exception ex){
            System.out.println("Something's gone wrong");
        }

    }
}

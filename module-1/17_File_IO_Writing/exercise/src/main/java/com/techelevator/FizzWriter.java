package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */

//		System.out.println("Please provide a number: ");
//		int keyNumber = Integer.parseInt(userInput.nextLine());

		System.out.println("Please provide the destination file: ");
		String fileName = userInput.nextLine();
		File outputFile = new File(fileName);


		try (PrintWriter writer = new PrintWriter(outputFile)) {
			for(int keyNumber = 1; keyNumber<=300;keyNumber++) {

				if (keyNumber % 3 == 0 && keyNumber % 5 == 0)
					writer.println("FizzBuzz");
				else if (keyNumber % 3 == 0)
					writer.println("Fizz");
				else if (keyNumber % 5 == 0)
					writer.println("Buzz");
				else
					writer.println(keyNumber);
			}
		} catch (FileNotFoundException ex) {
			throw new RuntimeException("You are wrong!");
		}
	}

}

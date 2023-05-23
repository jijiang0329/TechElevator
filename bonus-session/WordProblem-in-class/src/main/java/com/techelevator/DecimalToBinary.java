package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String input = userInput.nextLine();

		// Split the string
		String[] numbersAsStrings = input.split(" ");

		for (int i = 0; i < numbersAsStrings.length; i++) {
			//System.out.println(numbersAsStrings[i]);

			int decimalNumber = Integer.parseInt(numbersAsStrings[i]);
			String binaryAnswer = "";

			while(decimalNumber > 0){
				int remainder = (decimalNumber % 2);
				binaryAnswer = Integer.toString(remainder) + binaryAnswer;

				decimalNumber = decimalNumber / 2;
			}
			System.out.println(numbersAsStrings[i] + " : " + binaryAnswer);
		}


	}

	public static void curriculumAnswer(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String input = userInput.nextLine();

		// Split the string
		String[] numbersAsStrings = input.split(" ");

		for (int ix = 0; ix < numbersAsStrings.length; ix++) {
			int decimal = Integer.parseInt(numbersAsStrings[ix]);

			String binary = "";
			for (; decimal >= 0; decimal = decimal / 2) { // the first and last section of the for loop are optional.  Here, we do not do anything before the for loop begins.
				binary = (decimal % 2) + binary;
				if (decimal == 0) {
					break;
				}
			}

			System.out.println(numbersAsStrings[ix] + " in binary is " + binary);
		}
	}
}

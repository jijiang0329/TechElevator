package com.techelevator;

public class Fibonacci {

	public static void main(String[] args) {

//		The Fibonacci numbers are the integers in the following sequence:
//
//		0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
//
//		By definition, the first two numbers in the Fibonacci sequence are 0 and 1, and each subsequent number is the sum of the previous two:
//
//		0 + 1 = 1
//		1 + 1 = 2
//		1 + 2 = 3
//		2 + 3 = 5
//		3 + 5 = 8
//
//		Write a command-line program which prompts the user for an integer value and display the Fibonacci sequence leading up to that number:
//

		int stoppingPoint = 10000;
		int previousNumber = 0;
		int currentNumber = 1;

		System.out.print("0");

		while (currentNumber <= stoppingPoint){
			int nextNumber = previousNumber + currentNumber;

			System.out.print("," + currentNumber);

			previousNumber = currentNumber;
			currentNumber = nextNumber;
		}

		System.out.println(	);
		System.out.println();

		 previousNumber = 0;
		 currentNumber = 1;

		System.out.print("0");
		while (currentNumber <= stoppingPoint){
			int nextNumber = previousNumber + currentNumber;

			System.out.print(", ");
			if (currentNumber % 3 == 0){
				System.out.print("Fizz");
			}
			if (currentNumber % 5 == 0 ){
				System.out.print("Buzz");
			}

			if( (currentNumber % 3 != 0) && (currentNumber % 5 != 0 ) ) {
				System.out.print(currentNumber);
			}
			previousNumber = currentNumber;
			currentNumber = nextNumber;
		}
		
	}
}

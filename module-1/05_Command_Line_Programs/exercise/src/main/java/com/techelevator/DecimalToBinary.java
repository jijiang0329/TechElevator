package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String strList = scanner.nextLine();
		String[] strItem = strList.split(" ");
		for (int i = 0; i < strItem.length; i++) {

			int num = Integer.parseInt(strItem[i]);
			String numBinary = Integer.toBinaryString(num);
			System.out.printf( num + " in binary is " + numBinary);
		}


	}

}

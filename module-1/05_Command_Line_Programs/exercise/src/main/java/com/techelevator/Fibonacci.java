package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter a number: ");
		String strLimit = scanner.nextLine();
		int limit = Integer.parseInt(strLimit);

		int fabFirst = 0;
		int fabSecond = 1;
		int fabNext = 0;
		if (limit < 1) {
			System.out.print(fabFirst + ", " + fabSecond);

		} else {
			System.out.print(fabFirst + ", " + fabSecond);
			while (fabNext <= limit) {

				fabNext = fabFirst + fabSecond;
				if (fabNext<= limit) {
					String next = Integer.toString(fabNext);
					System.out.print(", " + next);
				}
				fabFirst = fabSecond;
				fabSecond = fabNext;
			}
		}
	}



}

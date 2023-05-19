package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Temperature: ");
		String temp = scanner.nextLine();

		System.out.print("Is the temperature in Celsius, or Fahrenheit?");
		String tempType = scanner.nextLine();

		if (tempType.equalsIgnoreCase("c")) {
			int temperatureFarenheit = (int)(Double.parseDouble(temp) * 1.8 + 32);
			System.out.println(temp + "C" + " is " + temperatureFarenheit + "F");
		} else {
			int temperatureCelsius = (int)((Double.parseDouble(temp) - 32) / 1.8);
			System.out.println(temp + "F" + " is " + temperatureCelsius + "C");
		}

	}

}

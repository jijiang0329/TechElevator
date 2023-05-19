package com.techelevator;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Please enter the length: ");
		String strLength = scanner.nextLine();

		System.out.print("Is the measurement in (m)eter, or (f)eet:");
		String lengthType = scanner.nextLine();

		if (lengthType.equalsIgnoreCase("f")) {
			int lengthInMeters = (int)(Double.parseDouble(strLength) * 0.3048);
			System.out.println(strLength + "f" + " is " + lengthInMeters + "m");
		} else {
			int lengthInFeets = (int)(Double.parseDouble(strLength) * 3.2808399);
			System.out.println(strLength + "m" + " is " + lengthInFeets + "f");
		}

	}

}

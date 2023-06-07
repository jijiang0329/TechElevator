package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.SQLOutput;
import java.util.Scanner;

public class FileSplitter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FileSplitter fileSplitter = new FileSplitter();
		try {
			fileSplitter.run();
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public void run() throws FileNotFoundException {
		/* Your code goes here */
		System.out.print("Where is the input file (please include the path to the file)?");
		String filename = userInput.nextLine();
		File file = new File(filename);

		System.out.print("How many lines of text (max) should there be in the split files?");
		int maxLines = Integer.parseInt(userInput.nextLine());

		int count = 0;
		int files = 1;
		File fileOutput = new File(filename+ "-" + files);
		try(Scanner scanner = new Scanner(file);
			PrintWriter writer = new PrintWriter(fileOutput)) {

			while (scanner.hasNextLine()) {
				scanner.nextLine();
				count++;
			}

			System.out.print("The input file has " + count +" lines of text.");

			double temp = (count/maxLines);

			int numberOfFiles=0;
			if(count % maxLines==0)
				numberOfFiles= (int) temp;
			else
				numberOfFiles= (int) (temp+1);
			System.out.println("For a "+ count +" line input file "+file.getName()+", this produces "+numberOfFiles+" output files.");
			System.out.println("**GENERATING OUTPUT**");
			for(int i = 1; i < count; i+= maxLines) {

				System.out.println("Generating " + files);
				String lineText = null;
				for (int j = 1; j <= maxLines; j++)
					lineText = scanner.nextLine();
					writer.println(lineText);

				files++;
			}
	}}

}

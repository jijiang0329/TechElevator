package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class QuizMaker {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		QuizMaker quizMaker = new QuizMaker();
		quizMaker.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.print("Please provide the quiz file: ");
		String filePath = userInput.nextLine();
		File file = new File(filePath);

		try(Scanner fileSource = new Scanner(file)){

			while(fileSource.hasNextLine()){
				String line = fileSource.nextLine();

				String[] lineParts = line.split("\\|");
				System.out.println(lineParts[0]);

				for (int i = 1; i < lineParts.length; i++) {
					System.out.println(i + ")" + lineParts[i].replace("*", ""));
				}


			}
		} catch(FileNotFoundException ex) {
			System.out.println("Something is wrong!");
			throw new RuntimeException();
		}
	}

}

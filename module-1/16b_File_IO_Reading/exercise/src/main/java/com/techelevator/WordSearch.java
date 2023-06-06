package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() {
		/* Your code goes here */

		System.out.println("What is the fully qualified name of the files that should be searched?");
		String filePath = userInput.nextLine();
		File file = new File (filePath);

		System.out.println("What is the search words you are looking for?");
		String keyWord = userInput.nextLine();

		System.out.println("Should the search be case sensitive? (Y/N");
		String caseChoice = userInput.nextLine();


		try (Scanner fileSource = new Scanner(file)) {

			int lineCount = 1;
			while(fileSource.hasNextLine()) {

				String lineText = fileSource.nextLine();
				if(caseChoice.equalsIgnoreCase("y") && lineText.contains(keyWord)) {
					System.out.println(lineCount + ") " + lineText);
				} else if (caseChoice.equalsIgnoreCase("n") && lineText.toLowerCase().contains(keyWord.toLowerCase())){
					System.out.println(lineCount + ") " + lineText);
				}
				lineCount++;
			}
		} catch(FileNotFoundException ex) {
			System.out.println("Something is wrong");
		}

	}




}







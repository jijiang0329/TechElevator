package com.techelevator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		/*
		System.out.println("Please enter the full file path and name");

		String filePath = userInput.nextLine();

		File file = new File(filePath);

		if(file.exists()){
			System.out.println("File exists");

			System.out.println("The size of our file is: " + file.length());
			System.out.println("The absolute path of our file is: " + file.getAbsolutePath());
			System.out.println("The file was created: " + file.lastModified());

		} else {
			System.out.println("File does not exist");
			System.out.println("So we will create it");

			file.createNewFile();
		}

		System.out.println("Let's create a directory:");
		File directory = new File(userInput.nextLine());
		if(directory.exists()){
			System.out.println("Directory exists");
		} else {
			System.out.println("Creating directory...");
			directory.mkdir();
		}

		 */

		System.out.println("Please enter the file name");

		String filePath = userInput.nextLine();

		File file = new File(filePath);

		//If the file does not yet exist, the PrintWriter will create it
		try(PrintWriter writer = new PrintWriter(file)){

			writer.println("Hello World");

		} catch(Exception ex){
			System.out.println("Something went wrong");
		}

		try(PrintWriter writer = new PrintWriter(new FileOutputStream(file, true))) {

			writer.println("We are appending content without overwriting old content");
			writer.println("Line 1");
			writer.println("Line 2");
			writer.println("LIne 3");

			for(int i = 1; i <= 100; i++){
				writer.println(i);
			}

		} catch(Exception ex){
			System.out.println("Something went wrong");
		}


	}

}

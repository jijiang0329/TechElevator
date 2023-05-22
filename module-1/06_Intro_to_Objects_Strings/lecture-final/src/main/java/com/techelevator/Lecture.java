package com.techelevator;

import com.techelevator.models.Person;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		int x = 100;
		Person christopher = new Person("Christopher","Guarnera");
		christopher.introduceSelf();

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		String company = "Tech Elevator";



		/* create an new instance of String using a literal */

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		boolean startsWithTech = company.startsWith("Tech");
		System.out.println("Starts with 'Tech':" + startsWithTech);

		boolean startsWithLowerTech = company.startsWith("tech");
		System.out.println("Starts with 'tech':" + startsWithLowerTech);

		//if we want to check something regardless of case, we can force the entire string
		//to be either upper case or lower case
		startsWithLowerTech = company.toLowerCase().startsWith("tech");
		System.out.println("Starts with 'tech' case insensitive:" + startsWithLowerTech);

		//Notice above we called company.toLowerCase().startsWith all at once, we are able to chain methods like that
		// because each of those methods returns a string. It is equivalent to:
		String lowerCaseCompany = company.toLowerCase();
		startsWithLowerTech = lowerCaseCompany.startsWith("tech");

		//We can get the same effect of case insensitivity using upper case
		boolean startsWithTechUpper = company.toUpperCase().startsWith("TECH");
		System.out.println("Starts with 'TECH' case insensitive:" + startsWithTechUpper);

		boolean endsWithElevator = company.endsWith("Elevator");
		System.out.println("Ends with 'Elevator': " + endsWithElevator);

		//we can check how long our string is
		int length = company.length();
		System.out.println("Length of company: " + length);

		//charAt - thinking of a string as an array of chars
		char lastChar = company.charAt(company.length()-1);
		System.out.println("Last Char: " + lastChar);


		char firstChar = company.charAt(0);
		System.out.println("First char: "+ firstChar);

		//if we wanted to loop through each letter in the string
		for(int i = 0; i < company.length(); i++){
			char currentLetter = company.charAt(i);
			System.out.println(currentLetter);
		}

		//we can get the location of a substring - if it doesn't find it, it returns -1
		int indexOfEl = company.indexOf("Elevator");
		System.out.println("Location of 'Elevator':" + indexOfEl);

		//it will find only the first index
		int indexOfE = company.indexOf("e");
		System.out.println("Location of e: " + indexOfE);

		int lastIndexOfE = company.lastIndexOf("e");
		System.out.println("Last location of e:" + lastIndexOfE);

		//if you only want to check that it exists but don't care where
		boolean containsElevator = company.contains("Elevator");
		System.out.println("Contains elevator: " + containsElevator);

		String companyWithSpaces = "      Tech Elevator       ";
		System.out.println(companyWithSpaces);
		System.out.println(companyWithSpaces.trim());

		//replace
		String newCompany = company.replace("Elevator", "Escalator");
		System.out.println(newCompany);

		//substring
		//it has two variations

		//variation 1: provide both a start and an end
		//the end will go up to but not include the index we specify

		String substring1 = company.substring(0,4);
		System.out.println(substring1);

		//variation 2: provide only a start, and by default it will go all the way to the end
		int indexOfElevator = company.indexOf("Elevator");
		String substring2 = company.substring(indexOfElevator);
		System.out.println(substring2);

		String[] splitString = company.split(" ");
		System.out.println("First element:" + splitString[0]);
		System.out.println("Second element:" + splitString[1]);

		String allCombinedAgain = String.join(",", splitString);
		System.out.println("Combined: " + allCombinedAgain);

		System.out.println(String.format("Hello %s", company));


		String text = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity, it was the season of Light, it was the season of Darkness, it was the spring of hope, it was the winter of despair, we had everything before us, we had nothing before us, we were all going direct to Heaven, we were all going direct the other way – in short, the period was so far like the present period, that some of its noisiest authorities insisted on its being received, for good or for evil, in the superlative degree of comparison only";

		//anytime that we declare an object, if we don't assign anything then by default it's null
	/*	String lineFragment;
		final int LINE_LENGTH = 50;
		for(int i = 0; i < text.length(); i+=LINE_LENGTH){

			//make sure that the string length has at least 25
			int endIndex = i + LINE_LENGTH;

			if(endIndex < text.length()) {
				lineFragment = text.substring(i, i + LINE_LENGTH);
			} else {
				lineFragment = text.substring(i);
			}
			System.out.println(lineFragment);

		}
*/
		text = text.replace("," , ",\n");
		System.out.println(text);

		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}

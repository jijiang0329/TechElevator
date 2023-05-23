package com.techelevator;


import java.util.*;


public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");

		//List is an interface, so we have to choose a specific implementation
		//we typically will always use ArrayList
		//We indicate what the data type is inside the <> on left hand side of the =
		List<String> avengers = new ArrayList<>();

		//We cannot make a list of primitives, we have to use objects
		//List<int> numbers = new ArrayList<>(); we cannot do this
		List<Integer> numbers = new ArrayList<>();
		List<Double> doubles = new ArrayList<>();
		List<Character> characters = new ArrayList<>();
		List<Boolean> booleans = new ArrayList<>();


		//To add values to our list, we just call add
		avengers.add("Iron Man");
		avengers.add("Scarlet Witch");
		avengers.add("Black Widow");
		avengers.add("Captain America");
		avengers.add("Thor");

		numbers.add(5);

		doubles.add(3.14);

		characters.add('X');

		booleans.add(true);


		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		/*
		for(int i = 0; i < avengers.size(); i++){

			//instead of referencing an individual value using brackets []
			//we can use get()
			String currentValue = avengers.get(i);
			System.out.println(currentValue);
		} */

		//If we are starting at the beginning of a list/array/collection
		//and iterating through its entirety one at a time
		//then we can use something called a foreach loop
		for(String currentValue : avengers){
			System.out.print(currentValue +",");
		}

		/*
		for(Integer i : numbers) {
			System.out.println(i + ",");
		}*/

		System.out.println("");
		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		avengers.add("Captain America");
		for(String avenger : avengers){
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		String avengerAt2 = avengers.get(2);
		avengers.add(2, "Hulk");

		for(String avenger : avengers){
			System.out.println(avenger);
		}

		System.out.println("Avenger formerly at 2: " + avengerAt2);
		System.out.println("Avenger currently at 2: " + avengers.get(2));

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");

		//we can remove by index
		avengers.remove(4);
		for(String avenger : avengers){
			System.out.println(avenger);
		}

		//or instead of by index, remove the first instance that matches this value
		avengers.remove("Captain America");

		//if we want to remove all
		while(avengers.contains("Captain America")){
			avengers.remove("Captain America");
		}

		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");

		if(avengers.contains("Captain America")){
			System.out.println("Captain America is in the list");

		}else {
			System.out.println("Captain America is not in the list");
		}

		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");

		int firstIndexOfHulk = avengers.indexOf("Hulk");
		int lastIndexOfHulk = avengers.lastIndexOf("Hulk");

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");


		String[] avengersArr = avengers.toArray(new String[avengers.size()]);

		//and we can use a foreach loop with arrays as well
		for(String avenger : avengersArr){
			System.out.println(avenger);
		}

		//If we want to go from an array to a list
		String[] newAvengersArray = {"Spiderman", "Dr. Strange", "Captain Marvel"};
		List<String> newAvengersList = Arrays.asList(newAvengersArray);

		List<Integer> myNumberList = Arrays.asList(new Integer[]{1,2,3,4,5});


		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");


		Collections.sort(avengers);
		for(String avenger : avengers){
			System.out.println(avenger);
		}

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(avengers);
		for(String avenger: avengers){
			System.out.println(avenger);
		}


		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();


		////// Stack //////
		// LIFO - last in first out
		// think of stacking books on the floor, you can only pick up the most recent book you placed on top of the pile
		Stack<String> stack = new Stack<>();

		stack.push("The Shining");
		stack.push("It");
		stack.push("Salem's Lot");

		System.out.println( stack.pop() );
		System.out.println( stack.pop() );
		System.out.println( stack.pop() );

		////Queue //////
		//FIFO - first in first out
		//think of this like the DMV, you take a number and your number is called before someone who came in after you
		Queue<String> queue = new LinkedList<>();

		queue.offer("Joe");
		queue.offer("Jane");
		queue.offer("Ben");


		System.out.println( queue.poll());
		System.out.println( queue.poll());
		System.out.println( queue.poll());


	}
}

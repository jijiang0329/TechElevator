package com.techelevator;


import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//a map where the key is an integer and the value is a string
		Map<Integer, String> mallDirectory = new HashMap<>();

		//a map where the key is a string and the value is an integer
		Map<String, Integer> map1 = new HashMap<>();

		Map<String, String> stringMap = new HashMap<>();

		Map<Integer, Double> doubleMap = new HashMap<>();

		Map<String, Boolean> boolMap = new HashMap<>();

		//!!!!!!
		//HashMaps do not keep order, so whatever order we insert values as we do not have a guarantee that they will stay in that order
		//the only thing we can count on is that whatever key we associate with a value we can use that key later to find the same value

		//Java does have some collections that are less efficient but will preserve order. For instance:

		//Instead of using a hashmap - we could use a treemap, and that will sort alphabetically/numerically
		Map<String, String> treeMap = new TreeMap<>();

		//If we want to preserve the order that we insert things into a map, we can use a LinkedHashMap
		Map<String, String> linkedMap = new LinkedHashMap<>();

		//In the case above, we declare the interface but instantiate the actual class we are using
		//similar to saying Car myCar = new ToyotaYaris  (less expensive, efficient) vs Car myOtherCar = new BMW   (more expensive, more bells and whistles)


		//!!! KEYS MUST BE UNIQUE but values can be duplicated.

		//if we want to insert new values:
		mallDirectory.put(118, "Gamestop");
		mallDirectory.put(120, "Macy's");
		mallDirectory.put(122, "Starbucks");
		mallDirectory.put(124, "Starbucks");

		//If we want to retrieve a value
		System.out.println("Store at 122 is: " + mallDirectory.get(122));


		//if we want the size of the map
		mallDirectory.size();

		//it's going to automatically know what data type it should expect for the key. So above we passed an integer
		//below we can pass in a string
		stringMap.put("Hello", "World");
		System.out.println(stringMap.get("Hello"));

		//If we want to update an existing value, for instance if Macy's goes out of business
		mallDirectory.put(120, "Starbucks");

		//if we want to remove an entry entirely
		mallDirectory.remove(118);

		//We can iterate through a map looking at both key and value pairs:
		List<Integer> starbucks = new ArrayList<>();
		for(Map.Entry<Integer, String> entry : mallDirectory.entrySet()){
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key is " + key + " and value is " + value);

			if(value.equals("Starbucks")){
				starbucks.add(key);
			}

		}

		//we can iterate through a map looking at only the keys
		for(Integer key : mallDirectory.keySet()) {
			System.out.println(key);
		}

		//if we want to iterate through the values
		for(String value : mallDirectory.values()){
			System.out.println(value);
		}

		//if we just want to see if a key exists:
		boolean has122 = mallDirectory.containsKey(122);

		//if we just want to see if a value exists
		boolean hasStarbucks = mallDirectory.containsValue("Starbucks");

		Map<String, Integer> people = new HashMap<>();
		people.put("Joe", 100);
		people.put("Jane", 22);
		people.put("Ben", 50);

		//to calculate average age
		int sum = 0;
		for(int age : people.values()){
			sum += age;
		}
		int averageAge = sum / people.size();
		System.out.println("Average age is " + averageAge);

		System.out.println("Dark Matter is " + getBookGenre("Dark Matter"));

		System.out.println("Dark Matter is " + getBookGenre("dark matter"));

		System.out.println("Cosmos is " + getBookGenre("COSMOS"));

		System.out.println("Null is " + getBookGenre(null));


		Map<String, Integer> friesMap = new HashMap<>();
		friesMap.put("Cori", 100);
		friesMap.put("Violet", 51);

	//	friesMap = makeFairShare(friesMap);

		friesMap = makeFairShareWDadTax(friesMap);

		countComics();

		System.out.println("End");



	}

	public static Map<String, Integer> countComics(){

		List<String> comics = new ArrayList<>();
		comics.add("Spiderman");
		comics.add("Spiderman");
		comics.add("Batman");
		comics.add("Thor");
		comics.add("Spiderman");

		Map<String, Integer> results = new HashMap<>();

		for(int i = 0; i < comics.size(); i++){

			String comic = comics.get(i);
			if(results.containsKey(comic)){
				//update
				int currentCount = results.get(comic);
				currentCount++;
				results.put(comic, currentCount);
			} else {
				//insert
				results.put(comic, 1);
			}

		}


		return results;
	}


	public static Map<String, Integer> makeFairShareWDadTax(Map<String, Integer> originalFriesMap) {

		int fries1 = originalFriesMap.get("Cori");
		int fries2 = originalFriesMap.get("Violet");

		int difference = fries2 - fries1;

		if(Math.abs(difference) > 10) {

			int totalFries = fries1 + fries2;

			int half = totalFries/2;

			int newFries1 = half;
			int newFries2 = half;
			int dadTax = totalFries - (newFries1 + newFries2);

			originalFriesMap.put("Cori", newFries1);
			originalFriesMap.put("Violet", newFries2);
			originalFriesMap.put("Dad", dadTax);

		}

		return originalFriesMap;
	}

	public static Map<String, Integer> makeFairShare(Map<String, Integer> originalFriesMap) {

		int fries1 = originalFriesMap.get("Cori");
		int fries2 = originalFriesMap.get("Violet");

		int difference = fries2 - fries1;

		if(Math.abs(difference) > 10) {

			int totalFries = fries1 + fries2;

			int half = totalFries/2;

			int newFries1 = half;
			int newFries2 = totalFries - half;

			originalFriesMap.put("Cori", newFries1);
			originalFriesMap.put("Violet", newFries2);

		}

		return originalFriesMap;
	}





	private static String getBookGenre(String title){

		Map<String, String> bookMap = new HashMap<>();
		bookMap.put("the shining", "Horror");
		bookMap.put("dark matter", "Sci-Fi");
		bookMap.put("the fault in our stars", "Drama");
		bookMap.put("the great reset", "Non-Fiction");
		bookMap.put("the demon awakens", "Fantasy");

		if(title == null || !bookMap.containsKey(title.toLowerCase())) {
			return "Does not exist in our collection";
		}

		return bookMap.get(title.toLowerCase());

	}

}

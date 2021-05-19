package com.techelevator;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Declaring and initializing a Map
		Map<String, String> nameToZip = new HashMap<String, String>();

		// Adding an item to a Map
		nameToZip.put("David", "44120");
		nameToZip.put("Dan", "44124");
		nameToZip.put("Elizabeth", "44012");

		// Retrieving an item from a Map
		System.out.println("David lives in " + nameToZip.get("David"));
		System.out.println("Dan lives in " + nameToZip.get("Dan"));
		System.out.println("Elizabeth lives in " + nameToZip.get("Elizabeth"));
		System.out.println();

		// Retrieving just the keys from a Map
		System.out.println("We can also retrieve a list of keys and iterate over them using a for loop:");

		//*** Note to instructor:
		//*** The return type of `Map<String, String>.keySet()` is a `Set<String>`. Keys are required to be unique 
		//*** and sets guarantee uniqueness.
		Set<String> keys = nameToZip.keySet(); // returns a Collection of all of the keys in the Map
		for (String name : keys) {
			System.out.println(name + " lives in " + nameToZip.get(name));
		}
		System.out.println();

		// Check to see if a key already exists
		if (nameToZip.containsKey("David")) {
			System.out.println("David exists");
		}
		System.out.println();

		System.out.println("set 12345 for key David");
		nameToZip.put("David", "12345"); // If key already exists, value is updated, otherwise key-value added

		// Iterate through the key-value pairs in the Map
		for (Map.Entry<String, String> nameZip : nameToZip.entrySet()) {
			System.out.println(nameZip.getKey() + " lives in " + nameZip.getValue());
		}
		System.out.println();

		// Remove an element from the Map
		nameToZip.remove("David");
		System.out.println("removed David");
		System.out.println();

		// loop through again to show David was removed
		for (Map.Entry<String, String> nameZip : nameToZip.entrySet()) {
			System.out.println(nameZip.getKey() + " lives in " + nameZip.getValue());
		}
		System.out.println();

	}

}

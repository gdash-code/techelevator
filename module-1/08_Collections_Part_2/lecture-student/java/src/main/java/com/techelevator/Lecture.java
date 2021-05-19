package com.techelevator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		// Declare and Initialize a Map<T,T>
		//Type comma Type
		Map<String, String> nameToZip = new HashMap<>();

		//Add Key Value Pairs to my map
		nameToZip.put("David", "44578");
		nameToZip.put("Peter", "90210");
		nameToZip.put("Michael", "62175");
		nameToZip.put("Bob", null);
		//Get values from my Map

		System.out.println(nameToZip.get("Peter"));
		//Note that Paul is not a Key in our Map's KeySet
		System.out.println(nameToZip.get("Paul"));
		//But Bob is, and he has that pesky null value assigned
		System.out.println(nameToZip.get("Bob"));
		if (nameToZip.get("Bob") == (null)) {
			System.out.println("Bob either does not exist as a key or has no vale set");

			//.equals is an object equality check
		}

		//Retrieving just the keys from a Map and showing off Set declaration and assignment
		Set<String> nameKeys = nameToZip.keySet();

		//Print out all the keys
		for (String nameKey : nameKeys) {
			System.out.println(nameKey + " lives in zipcode " + nameToZip.get(nameKey));
		}
		if (nameToZip.containsKey("David")) {
			System.out.println("David has a zip code");    //Does an entry exist? Check for the Key!
		}
		System.out.println("David lives in" + nameToZip.get("David"));
		nameToZip.put("David", "19101");
		System.out.println("The put **Updated** David's entry to 19101");

		System.out.println("David lives in " + nameToZip.get("David"));

		//Ternary sidebar: Assign a value to doesJerryExist using a ternary

		String doesJerryExist;
		doesJerryExist = (nameToZip.containsKey("Jerry")) ? "Yes" : "No";
		System.out.println("Does Jerry exist? " + doesJerryExist);

		//Hack to sort a map... well, you can't but you can simulate it


	}



}

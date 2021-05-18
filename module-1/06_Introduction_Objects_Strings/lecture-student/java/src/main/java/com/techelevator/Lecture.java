package com.techelevator;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */
		String greeting = "Hello, World!";
		System.out.println("greeting is: " + greeting);

		String greeting2 = new String("Hello to you too!");
		System.out.println("CTOR Method: " + greeting2);
		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		//System.out.println();

		System.out.println("\n--- charAt(int)---");
		String myName = "Ash Williams";
		char first = myName.charAt(0);
		char last = myName.charAt(myName.length()-1);

		System.out.println("First and last characters are:  " + first + last);

		System.out.println("\n--- contains(String)---");

		Boolean myNameContainsSh = myName.contains("sh");
		System.out.println("Does myName contain 'sh'? : " + myNameContainsSh );
		System.out.println("Strings are immutable: " + myName);

		myNameContainsSh = myName.contains("sh");
		System.out.println("Does myName contain 'sh' ?: " +myNameContainsSh);

		System.out.println("\n--- Other Methods ---");
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
		String hello1 = "";
		String hello2 = "";


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

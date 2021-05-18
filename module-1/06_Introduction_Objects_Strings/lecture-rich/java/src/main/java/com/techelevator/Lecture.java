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

		/* create an instance of a string with the formal constructor */

		String greeting2 = new String("Hello to you too!");
		System.out.println("CTOR Method: " + greeting2);

		
		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");

		System.out.println("\n---- charAt(int) ----");
		String myName = "Richard Seeds";
		char first = myName.charAt(0);
		char last = myName.charAt(myName.length() -1);

		System.out.println("First and last characters are: " + first + last);

		System.out.println("\n---- contains(String) ----");

		Boolean myNameContainsIch = myName.contains("ich");

		System.out.println("Does myName contain 'ich'?: " + myNameContainsIch);
		System.out.println("Strings are immutable: " + myName);

		myNameContainsIch = myName.contains("Ich");
		System.out.println("Does myName contain 'Ich'?: " + myNameContainsIch);

		System.out.println("\n---- Other Methods ----");

		/* Other commonly used methods:
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

		System.out.println("endsWith('x'): " + myName.endsWith("x"));
		System.out.println("startsWith('Ri'): " + myName.startsWith("Ri"));
		System.out.println("FIRST indexOf 'ch': " + myName.indexOf("ch"));
		System.out.println("FIRST indexOf 's': " + myName.toLowerCase().indexOf("s"));
		System.out.println("Strings are immutable: " + myName);
		System.out.println("FIRST indexOf 's': " + myName.toLowerCase().lastIndexOf("s"));
		System.out.println("Strings are STILL immutable: " + myName);

		/* GET ALL THE CHARACTERS BEGIN THE FIRST AND LAST OCCURRENCE OF 's'*/

		int firstS = myName.toLowerCase().indexOf("s");
		int lastS = myName.toLowerCase().lastIndexOf("s");

		String stuffBetweenS = myName.substring(firstS + 1, lastS);

		String everythingAfterFristS = myName.substring(firstS + 1);

		System.out.println("The characters between s's are: " + stuffBetweenS);
		System.out.println("The characters after the first 's' are: " + everythingAfterFristS);

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

		System.out.println("\n****** EQUALITY WITH DIRECT ASSIGNMENT OF LITERALS (INTERNING) ******");

		String hello1 = "Hello";
		String hello2 = "Hello";

		System.out.println("hello1: " + hello1);
		System.out.println("hello2: " + hello2);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		System.out.println("Equality with interned behavior from direct assignment of values");
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}


		System.out.println("\n == Equality with reference assignment StringX = StringY ");
		String hello3 = hello1;

		System.out.println("hello1: " + hello1);
		System.out.println("hello3: " + hello2);


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

		System.out.println("\n****** EQUALITY WITHOUT DIRECT ASSIGNMENT OF LITERALS: OBJECT BEHAVIOR ******");

		String helloX = "Hello";
		String helloY = "Hell";

		helloY += "o";

		System.out.println("helloX ('Hello'): " + helloX);
		System.out.println("helloY ('Hell' + 'o'): " + helloY);

		if (helloX == helloY) {
			System.out.println("They are '==' equal!");
		} else {
			System.out.println(helloX + " is not '==' equal to " + helloY);
		}

		System.out.println(" ...but... ");

		if (helloX.equals(helloY)) {
			System.out.println("They are '.equals()' equal!");
		} else {
			System.out.println(helloX + " is not '.equals()' equal to " + helloY);
		}

		System.out.println("\nLet's try reassigning helloY to 'Hello'");

		helloY = "Hello";


		if (helloX == helloY) {
			System.out.println("They are '==' equal!");
		} else {
			System.out.println(helloX + " is not '==' equal to " + helloY);
		}


	}
}

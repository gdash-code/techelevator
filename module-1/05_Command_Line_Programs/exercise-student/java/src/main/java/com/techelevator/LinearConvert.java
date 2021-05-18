package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
	Scanner userInput = new Scanner(System.in);

		System.out.print("Hello, please enter your length: ");
		String lengthInput = userInput.nextLine();
		int newLength = Integer.parseInt(lengthInput);

		System.out.print("Great! is your length 'M' or 'F': " );
		String feetOrMeters = userInput.nextLine();

		if(feetOrMeters.equals("M")){
			System.out.println(newLength + "M is: " + (int)(newLength * 3.2808399) + "F");
		}else if(feetOrMeters.equals("F")){
			System.out.println(newLength + "F is: " + (int)(newLength * 0.3048) + "M");
		}
	}

}

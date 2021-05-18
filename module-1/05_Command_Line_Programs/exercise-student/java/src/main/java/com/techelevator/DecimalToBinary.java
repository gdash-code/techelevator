package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);


		System.out.println("Please enter several decimals separated by a space: ");
		String decimalInput = userInput.nextLine();
		String[] decimalArray = decimalInput.split(" ");

		for(int i=0; i<decimalArray.length; i++){
			int convertedDecimalInput = Integer.parseInt(decimalArray[i]);
			System.out.println(decimalArray[i] + " to binary is: " + Integer.toBinaryString(convertedDecimalInput));
		}

	}

}

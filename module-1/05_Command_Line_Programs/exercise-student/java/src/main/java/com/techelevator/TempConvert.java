package com.techelevator;

import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {



		Scanner userInput = new Scanner(System.in);

		System.out.print("Is the temperature in (C)elsius, or (F)ahrenheit?: ");
		String celsiusOrFahrenheit = userInput.nextLine();

		System.out.print("Enter Temperature:");
		String userTempInput = userInput.nextLine();

		double newTemp = Double.parseDouble(userTempInput);

		if(celsiusOrFahrenheit.equals("C")){
			System.out.println((int)(newTemp) + " C is: " + (int)(newTemp-32 / 1.8) + " F");
		} else if(celsiusOrFahrenheit.equals("F")){
			System.out.println((int)newTemp + "F is: " + (int)((newTemp * 1.8) + 32) + " C");
		}





















	}

}

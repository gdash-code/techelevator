package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {


		//What we learned on Day 11: Inheritance
		FarmAnimal[] farmAnimals = new FarmAnimal[] { new Cow(), new Chicken() };

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		//What about an interface approach
		System.out.println("\n******************");
		System.out.println("*****An Interface Approach *******");
		System.out.println("******************\n");

		List<Singable> singableThings = new ArrayList<>();

		singableThings.add(new Cow());
		singableThings.add(new Chicken());
		singableThings.add(new Tractor("Big Green", "Vroom Vroom"));
		singableThings.add(new Horse("Bojack"));

		for(Singable thing : singableThings){
			String name = thing.getName();
			String sound = thing.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		System.out.println("\n******************");
		System.out.println("*****Multiple Interfaces*******");
		System.out.println("******************\n");

		//Start

		List<Rideable> rideableThings = new ArrayList<>();

		rideableThings.add(new Horse("Brian"));
		rideableThings.add(new Tractor("Big Green", "chug"));

		for (Rideable thing : rideableThings){

			thing.Ride();

		}

		System.out.println("\n******************");
		System.out.println("*****A Dual Interface Approach *******");
		System.out.println("******************\n");

	}
}
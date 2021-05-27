package com.techelevator.farm;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	public static void main(String[] args) {

		BarnCat kitty = new BarnCat("Fred", "Greow");
		kitty.sleep(true); //set in farmAnimal class

		Cow bessie = new Cow();
		Chicken cluckers = new Chicken();
		Pig porky = new Pig();
		Tractor bigGreen = new Tractor();

		List<FarmAnimal> farmAnimals = new ArrayList<>();

		farmAnimals.add(kitty);
		farmAnimals.add(bessie);
		farmAnimals.add(cluckers);
		farmAnimals.add(porky);

		List<Singable> singables = new ArrayList<>();

		

		singables.addAll(farmAnimals);
		singables.add(bigGreen);

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		System.out.println("\n Time to feed the farm...");
		for(FarmAnimal hungryAnimal : farmAnimals){
			hungryAnimal.feed();
		}
	}
}
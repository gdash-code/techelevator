package com.techelevator.farm;

public abstract class FarmAnimal implements Singable { //cannot instantiate this superclass farm animal
	private String name;
	private String sound;
	private boolean isAsleep = false;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	public String getName() {
		return name;
	}

	public final String getSound() { //those subclasses may not modify this behavior
		if (isAsleep) { //need a private member
			return "Zzzzzz...";
		} else {
			return sound;
		}

	}

	//need a setter or isAsleep
	public void sleep(boolean isAsleep){ //takes parameter is asleep
	this.isAsleep = isAsleep;
	}

	public abstract void feed(); //generic action
		//this is way different for every specialized subclass, how do I do this in a generic way?
	//the need to have a way to feed a subclass of this generic type
	//must define a feed method


}
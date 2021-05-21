package com.techelevator.cardexample;

public class MainProgram {

	public static void main(String[] args) {

		// Create a new Game, which sets up the appropriate deck
		Game game = new Game();
		
		// Display the unshuffled deck
		System.out.println("Unshuffled deck:");
		System.out.println(game.getDeck().deckString());
		
		// Shuffle the deck and redisplay
		game.getDeck().shuffle();
		System.out.println("Shuffled deck:");
		System.out.println(game.getDeck().deckString());
		
	}

}

package com.techelevator.cardexample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
	
	private List<Card> listOfCards = new ArrayList<>();

	/**
	 * Construct a deck of cards with suits and ranks
	 * 
	 * @param suits
	 * @param ranks
	 */
	public Deck(int[] suits, int[] ranks) {
		this(suits, ranks, new Card[] {});
	}
	
	/**
	 * Overload of Deck(int[], int[]) which accepts an
	 * additionalCards array of instantiated Card objects.
	 * 
	 * Useful for adding one-offs that lie outside of
	 * the standard cards that are instantiated as part
	 * of the normal construction of the deck.
	 * 
	 * @param suits
	 * @param ranks
	 * @param additionalCards
	 */
	public Deck(int[] suits, int[] ranks, Card[] additionalCards) {
		
		// Standard set of cards based upon suits and ranks
		for (int suit : suits) {
			for (int rank : ranks) {
				listOfCards.add(new Card(suit, rank));
			}
		}
		// Additional, one-off cards
		for (Card card : additionalCards) {
			listOfCards.add(card);
		}
	}

	/**
	 * Deals a card from the deck.
	 * 
	 * @return the top card from the deck, or null if deck is empty
	 */
	public Card dealOne() {

		if (listOfCards.size() != 0) {
			return listOfCards.remove(0);
		} else {
			return null;
		}
	}

	/**
	 * Shuffles the deck of cards randomly. 
	 */
	public void shuffle() {

		/*
		 * Recommended solution:
		 * 
		 * If you prefer not to distract students with a discussion
		 * of shuffle algorithms, or you're just pressed for time,
		 * simply use Collections.shuffle().
		 * 
		 * It's good practice to reuse code written and thoroughly
		 * tested by the folks at Java. The students' managers will
		 * love them for it.
		 */
		Collections.shuffle(listOfCards);

//		/*
//		 * Alternative solution:
//		 * 
//		 * If there is time, and interest from students,
//		 * here's a simple shuffle implementation you 
//		 * could use as the basis for discussion and
//		 * presentation.
//		 * 
//		 * Loop through the deck, on each iteration, 
//		 * swap the current card with a randomly chosen 
//		 * one.
//		 * 
//		 * Fisher-Yates shuffle. Based on code from 
//		 * https://stackoverflow.com/a/1150699/1034308
//		 */ 
//		Random rand = new Random();
//        for (int n = listOfCards.size() - 1; n > 0; --n) {
//            int k = rand.nextInt(n + 1);
//            Card temp = listOfCards.get(n);
//            listOfCards.set(n, listOfCards.get(k));
//            listOfCards.set(k, temp);
//        }

	}

	/**
	 * Build string representation of the deck in lieu of 
	 * toString() which needs to wait for inheritance and
	 * override to be introduced to students.
	 * 
	 * @return a simple string representation of the cards in the deck
	 */
	public String deckString() {
		String string = "";
		for (Card card : listOfCards) {
			// Note, cardString(false) returns the card face-up.
			string += card.cardString(false) + "\n";
		}
		return string;
	}

}

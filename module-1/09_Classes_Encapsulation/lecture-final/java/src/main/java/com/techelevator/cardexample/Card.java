package com.techelevator.cardexample;

public class Card {
	
	private int suit;
	private int rank;
	private boolean faceDown = true; // Cards are usually initially face down, so set to true

	/**
	 * Construct a Card object of suit and rank
	 * 
	 * @param suit
	 * @param rank
	 */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Flip (toggle set) face-down / face-up.
	 * Since faceDown is private, flip is the 
	 * only way to toggle between face-down
	 * and face-up.
	 */
	public void flip() {
		faceDown = !faceDown;
	}

	/**
	 * Get card's suit.
	 * 
	 * @return suit
	 */
	public int getSuit() {
		return this.suit;
	}

	/**
	 * Get card's  rank.
	 * 
	 * @return rank
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Get whether card is face-down.
	 * 
	 * @return true (face-down) / false (face-up)
	 */
	public boolean isFaceDown() {
		return faceDown;
	}

	/**
	 * Builds string presentation of a card depending
	 * upon the value of the instance variable, faceDown.
	 * 
	 * @return string representation of card
	 */
	public String cardString() {
		return cardString(this.faceDown);
	}
	
	/**
	 * Overload of cardString() which uses the faceDown
	 * parameter rather than the instance variable
	 * to determine which string representation of the
	 * card to return, the face or the back.
	 * 
	 * @param faceDown, if true, then card is face-down, otherwise face-up
	 * 
	 * @return string presentation of card
	 */
	public String cardString(boolean faceDown) {
		if (faceDown) {
			return "##";
		} else {
			return Game.getRankName(rank) + " of " + Game.getSuitName(suit)+ " - " + Game.getSuitSymbol(suit);
		}
	}
}

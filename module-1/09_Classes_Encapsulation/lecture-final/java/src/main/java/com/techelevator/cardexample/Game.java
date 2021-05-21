package com.techelevator.cardexample;

public class Game {

	private Deck deck;
	
	/**
	 * Construct a game and its deck of cards.
	 * 
	 * Three decks have been defined in code, but only one 
	 * should be uncommented at a time.
	 */
	public Game() {
		
		// Poker deck
		int[] pokerSuits = new int[] { SPADES, DIAMONDS, CLUBS, HEARTS };
		int[] pokerRanks = new int[] { ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING };
		deck = new Deck(pokerSuits, pokerRanks);
		
//		// Pinochle deck, two copies of each 9, 10, jack, queen, king, and ace cards of all four suits (48 total)
//		int[] pinochleSuits = new int[] { SPADES, DIAMONDS, CLUBS, HEARTS };
//		int[] pinochleRanks = new int[] { NINE, TEN, JACK, QUEEN, KING, ACE, NINE, TEN, JACK, QUEEN, KING, ACE };
//		deck = new Deck(pinochleSuits, pinochleRanks);
		
//		// Euchre deck is the same as Pinochle, plus a single Joker
//		int[] euchreSuits = new int[] { SPADES, DIAMONDS, CLUBS, HEARTS };
//		int[] euchreRanks = new int[] { NINE, TEN, JACK, QUEEN, KING, ACE, NINE, TEN, JACK, QUEEN, KING, ACE };
//		Card[] additionalCards = new Card[] { new Card(Game.NIL, Game.JOKER) };
//		deck = new Deck(euchreSuits, euchreRanks, additionalCards );
		
	}
	
	/**
	 * Get the underlying deck of the game.
	 * 
	 * @return deck
	 */
	public Deck getDeck() {
		return this.deck;
	}
	
	/**
	 * Get the name of the suit using suit parameter
	 * as index into suitNames array.
	 * 
	 * @param suit
	 * 
	 * @return name of the suit
	 */
	public static String getSuitName(int suit) {
		return suitNames[suit];
	}
	
	/**
	 * Get the symbol of the suit using suit parameter
	 * as index into suitSymbols array.
	 * 
	 * @param suit
	 * 
	 * @return Unicode character (symbol) of the suit
	 */
	public static char getSuitSymbol(int suit) {
		return suitSymbols[suit];
	}
	
	/**
	 * Get the name of the rank using rank parameter
	 * as index into rankNames array.
	 * 
	 * @param rank
	 * 
	 * @return name of the rank
	 */
	public static String getRankName(int rank) {
		return rankNames[rank];
	}
	
	public static final int NIL = 0;
	public static final int SPADES = 1;
	public static final int DIAMONDS = 2;
	public static final int CLUBS = 3;
	public static final int HEARTS = 4;

	public static final int JOKER = 0;
	public static final int ACE = 1;
	public static final int TWO = 2;
	public static final int THREE = 3;
	public static final int FOUR = 4;
	public static final int FIVE = 5;
	public static final int SIX = 6;
	public static final int SEVEN = 7;
	public static final int EIGHT = 8;
	public static final int NINE = 9;
	public static final int TEN = 10;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	
	private static String[] suitNames = new String[] { "Nil", "Spades", "Diamonds", "Clubs", "Hearts" };
    private static char[] suitSymbols = new char[] { '\u0000', '\u2660', '\u2666', '\u2663', '\u2665' };
    private static String[] rankNames = new String[] { "Joker", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
    													    "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

}

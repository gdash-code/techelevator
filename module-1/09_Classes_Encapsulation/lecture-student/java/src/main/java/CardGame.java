public class CardGame {
    public static final int HEARTS = 4;
    public static final int THREE = 3;

    private static String[] suitNames = new String[] {"Nil", "Spades", "Diamonds", "Clubs", "Hearts"};

    private static String[] rankNames = new String[]{"Joke", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
    "Nine", "Ten", "Jack", "Queen", "King"};

    private Deck deck;

    public Deck getDeck(){
        return this.deck;
    }

    public CardGame() {
        int[] pokerSuits = new int[] {HEARTS};
        int[] pokerRanks = new int[] {THREE};

        this.deck = new Deck(pokerRanks, pokerSuits);
    }
    public static String getSuitName(int suit){
        return suitNames[suit];
    }

    public static String getRankName(int rank) {
        return rankNames[rank];
    }
}

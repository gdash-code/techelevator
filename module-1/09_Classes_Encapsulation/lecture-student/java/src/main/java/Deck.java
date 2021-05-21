//We forgot to declare the package when creating the project...but it should be here as com.techelevator.cardgame


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {

    //Declare Private Members
    private int cardCount;

    private List<Card> listOfCards = new ArrayList<>();
    //Declare Public Members

    //Declare Accessor

    //Declare constructors

    public Deck(){
        //Default Constructor - allows for instantiation
        this(new int[]{}, new int[]{});
    }

    public Deck(int[] cardRanks, int[] cardSuits){

        this(cardRanks, cardSuits, new Card[]{});
    }

    public Deck(int[] cardRanks, int[] cardSuits, Card[] additionalCards){

        for(int suit : cardSuits){
            for(int rank : cardRanks){
                //make that card!

                listOfCards.add(new Card(rank, suit));
            }
        }

        for(Card extraCard : additionalCards){
            listOfCards.add(extraCard);
        }
        this.shuffle();

    }
    //Declare Private Methods

    //Declare Public Methods

    //TODO: DEAL
    public Card dealOne(){

        if(listOfCards.size() != 0){
            return listOfCards.remove(0);
        }else{
            return null;
        }
    }
    //TODO: SHUFFLE

    public String reportDeck(){
        String result = "";
        for( Card c : this.listOfCards){
            result += c.toString() + "\n";
        }
        return result;
    }

    public void shuffle (){
        Collections.shuffle(listOfCards);
    }

    public void shuffle

    //Declare Default Object Methods

    public String toString(){
       return this.reportDeck();
    }
}

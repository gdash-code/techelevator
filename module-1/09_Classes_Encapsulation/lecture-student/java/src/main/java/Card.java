//We forgot to declare the package when creating the project...but it should be here as com.techelevator.cardgame

public class Card {

    //Define the attributes of a card... card properties (Mind Encapsulation)

    private int rank;
    private int suit;
    private boolean faceDown = true;

    //Define the public accessors
    public int getRank(){
        return this.rank;
    }
    public int getSuit(){
        return this.suit;
    }

    public boolean isFaceDown(){      //use isName for booleans
        return this.faceDown;
    }

    //Create a constructor so that I can instantiate a card


    public Card(int cardRank, int cardSuit){
        this.rank = cardRank;
        this.suit = cardSuit;
    }

    //Define the things that a card do...Card Methods...It's behaviors
    public void flip(){
        this.faceDown = !this.faceDown;
    }

    //TODO: Finished the method to return the friendly name - such as Two of Diamonds
    public String cardDisplay(){

        if(this.faceDown){
            return "Bicycle";
        }else{
            return CardGame.getRankName(this.rank) + " of " + CardGame.getSuitName(this.suit);
        }

    }

    // Default Object Methods

    public String toString(){
        return this.getRank() + " of " + this.getSuit() + " it is " + ((this.faceDown)?"face down":"face up");
    }
}

//We forgot to declare the package when creating the project...but it should be here as com.techelevator.cardgame


public class MainProgram {

    // The main application for working with cards, decks, and games

    public static void main(String[] args) {

       /* Card myCard = new Card(2,1);

        System.out.println(myCard.toString());

        myCard.flip();

       // System.out.println(myCard); still kind of confused*/

        CardGame myPokerGame = new CardGame();

        int handCount = 0;

        while (handCount < 5) {


            Card nextCard = myPokerGame.getDeck().dealOne();

            System.out.println(nextCard.cardDisplay());

            nextCard.flip();

            System.out.println(nextCard.cardDisplay());

            handCount++;
        }
    }

}

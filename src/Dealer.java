/**
 * @author Reuben  on 9/10/2014.
 * This class gets an ordered deck from the DeckBuilder class, then shuffles it in a user specified way.
 * inputs: shuffleMethod, playerCount, HandSize(an integer for a specific amount, "max" for even distribution)
 * outputs: the distributed hands
 */
public class Dealer {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: shuffle method, player count, desired hand size");
            return;
        }
        //gets shuffle method, player count, and hand size
        String shuffleMethod = args[0];
        int playerCount = Integer.parseInt(args[1]);
        String desiredHandSize = args[2];
        int handSize;
        int draw;
        boolean error = false;
        //gets ordered deck
        String[] deck = DeckBuilder.build();
        //makes array for shuffled deck
        String[] shuffledDeck = new String[deck.length];
        //shuffles with switch shuffle
        if (shuffleMethod.equals("SwitchShuffle")) {
            shuffledDeck = SwitchShuffle.shuffle(deck);
        }
        //calculates each players hand size + size of draw pile
        if (desiredHandSize.equals("max")) {
            draw = (shuffledDeck.length % playerCount);
            handSize = (shuffledDeck.length - draw) / playerCount;
        } else {
            handSize = Integer.parseInt(desiredHandSize);
            //checks for error in hand size * player count
            if (handSize * playerCount > shuffledDeck.length) {
                error = true;
            }
            draw = shuffledDeck.length - (playerCount * handSize);
        }
        if (!error) {
            //divides the cards up among the players as an array where each row is player and each column is a card
            String[][] dealtHands = new String[playerCount][(shuffledDeck.length - draw) / playerCount];
            for (int player = 0; player < playerCount; player++) {
                for (int i = 0; i < handSize; i++) {
                    dealtHands[player][i] = shuffledDeck[i + player * handSize];
                }
            }
            //handles draw pile
            String[] drawpile = new String[draw];
            for (int i = 0; i < draw; i++) {
                drawpile[i] = shuffledDeck[playerCount * handSize + i];
            }
            //prints divided hands and checks for equality
            for (int i = 0; i < playerCount; i++) {
                System.out.println("Player " + (i + 1) + "'s hand.");
                for (int n = 0; n < handSize; n++) {
                    System.out.println(dealtHands[i][n]);
                }
                System.out.println();
                System.out.println();
            }
            System.out.println(draw + " cards in draw pile.");
            for (int i = 0; i < drawpile.length; i++) {
                System.out.println(drawpile[i]);
            }
        } else {
            System.out.println("Not enough cards for desired game!");
        }
    }
}
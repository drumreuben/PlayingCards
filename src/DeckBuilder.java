/**
 * Created by Reuben on 9/10/2014.
 * This class returns a string containing 52 ordered playing cards
 */
public class DeckBuilder {
    public static String[] build(){
        String[] rank = {
                "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"
        };
        String[] suit = {
                "Spades", "Diamonds", "Clubs", "Hearts"
        };
        String[] deck = new String[rank.length*suit.length];
            for(int indexSuit = 0; indexSuit < suit.length; indexSuit++){
                for(int indexRank = 0; indexRank < rank.length; indexRank++){
                    deck[indexRank+(13*indexSuit)] = (rank[indexRank] + " of " + suit[indexSuit]);
                }
            }
    return deck;
    }
}
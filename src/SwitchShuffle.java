/**
 * Created by Reuben on 9/10/2014.
 * This class takes a array of strings, then shuffles it by switching each value, in order, with another random value in the deck.
 */
public class SwitchShuffle {
    public static String[] shuffle(String[] shuffledDeck){
        //loop runs as many times as there are values in the array
        for(int i = 0; i < shuffledDeck.length; i++){
            //picks a random spot in the array
            int indexA = (int)(Math.random()*shuffledDeck.length);
            //exchanges the value in the current array position with the value in the randomly chosen position
            String t = shuffledDeck[indexA];
            shuffledDeck[indexA] = shuffledDeck[i];
            shuffledDeck[i] = t;
        }
    //returns the shuffled array
    return shuffledDeck;
    }
}
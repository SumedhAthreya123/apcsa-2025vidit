package cards;

import java.util.Random;
import java.util.random;

public class Deck {
    private Card[] allCards;
    private int nextCardIndex;

    public Deck() {
        allCards = new Card[52];
        nextCardIndex = 0;

        int pos = 0;
        for (int suitNum = 0; suitNum < 4; suitNum++) {
            for (int val = 0; val < 13; val++) {
                allCards[pos] = new Card(suitNum, val);
                pos = pos + 1;
            }
        }
    }

    public void shuffle() {
        Random rng = new Random();

        for (int idx = 51; idx > 0; idx = idx - 1) {
            int swapPos = rng.nextInt(idx + 1);
            Card temp = allCards[idx];
            allCards[idx] = allCards[swapPos];
            allCards[swapPos] = temp;
        }
    }
}

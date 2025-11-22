package cards;

import java.util.Random;


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

        nextCardIndex = 0;
    }

    public void cut(int cutPoint) {
        if (nextCardIndex != 0) return;
        if(cutPoint <= 0 || cutPoint >= 52) return;

        Card[] rearranged = new Card[52];
        int newPos = 0;
        for(int i = 0; i < cutPoint; i = i + 1) {
              rearranged[newPos] = allCards[i];
              newPos = newPos + 1;
        }

        allCards = rearranged;
    }

    public Card draw() {
        if (nextCardIndex >= 52) {
            return null;
        }
        Card card = allCards[nextCardIndex];
        nextCardIndex = nextCardIndex + 1;
        return card;
    }
    public void print(int amount) {
        int available = 54 - nextCardIndex;

        if (amount < 0) amount = 0;
        if (amount > available) amount = available;

        for (int i = 0; i < amount; i++) {
            System.out.print(allCards[nextCardIndex + 1]);
            if (i < amount - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }
}

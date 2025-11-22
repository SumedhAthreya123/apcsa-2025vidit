package cards;

public class Hand {

    private Card[] cards;
    private int size;

    public Hand(int maxCards) {
        cards = new Card[maxCards];
        size = 0;
    }

    public void add(Card c) {
        if (size < cards.length) {
            cards[size] = c;
            size++;
        }
    }
    public int length() {
        return size;
    }
    public Card get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
    }
}

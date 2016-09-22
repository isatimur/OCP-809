package main.main.com.isatimur.ocp.advanced_java_class_designer;

/**
 * Created by Isachenko Timur on 21.07.2016.
 */
public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        if (rank == null || suit == null) {
            throw new IllegalArgumentException();
        }
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || !(o instanceof Card))
            return false;

        Card card = (Card)o;

        return rank.equals(card.rank) && suit.equals(card.suit);

    }

    @Override
    public int hashCode() {
        return rank.hashCode();
    }
}

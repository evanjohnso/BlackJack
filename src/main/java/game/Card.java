package game;

/**
 * Created by Guest on 8/3/17.
 */
public class Card {
    private String number;
    private String suit;
    private int value;
    private String image;



    public Card(String number, String suit, int value) {
        this.number = number;
        this.suit = suit;
        this.value = value;
        image = suit + value + ".png";
    }

    public String getNumber() {
        return number;
    }
    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        return (number + " of " + suit);

    }
}
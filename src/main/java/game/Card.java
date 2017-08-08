package game;

/**
 * Created by Guest on 8/3/17.
 */
public class Card {
    private String number;
    private String suit;

    public int getValue() {
        return value;
    }
    private int value;
    public String getNumber() {return number;}

    public Card(String number, String suit, int value) {
        this.number = number;
        this.suit = suit;
        this.value = value;
    }
    @Override
    public String toString() {
        return (number +" of "+suit);

    }
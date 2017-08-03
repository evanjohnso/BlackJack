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

    public Card(String number, String suit, int value) {
        this.number = number;
        this.suit = suit;
        this.value = value;
    }
    @Override
    public String toString() {
        return (number +" of "+suit);

    }
}



//for (int i = 0; i < 10; i ++) {
//        Character letter = values[i].charAt(0);
//        cardValues.put(letter, (1 + i));
//        }
//        for (int j = 9; j < 13; j++) {
//        Character letter = values[j].charAt(0);
//        cardValues.put(letter, 10);
//        }
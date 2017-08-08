package game;


import java.util.*;

/**
 * Created by Guest on 8/3/17.
 */
public class BlackJack {
    private String[] suits = {"♠","♣","♥","♦"};
    private String[] values = {"Ace", "2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private Integer[] scoreValue = {11,2,3,4,5,6,7,8,9,10,10,10,10};
    private int cardsLeft;
    private List<Card> deck = new ArrayList<Card>();
    Random cardNum = new Random();
    //Constructor merely creates a fresh deck
    public BlackJack() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j ++) {
                deck.add( new Card(values[j], suits[i], scoreValue[j]) );
            }
        }
        cardsLeft = deck.size();
    }
    //Method merely dishes out a card from the remaining deck one at a time
    public Card getRandomCard() {
        Card nextCard = null;

        int cardSpot = cardNum.nextInt(cardsLeft - 1);
        nextCard = deck.get(cardSpot);
        deck.remove(cardSpot);
        cardsLeft--;
        return nextCard;
    }
    //GETTERS
    public List<Card> getDeck() {
        return deck;
    }
    public int getCardsLeft() {
        return cardsLeft;
    }

}

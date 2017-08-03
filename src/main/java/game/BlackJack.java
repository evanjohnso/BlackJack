package game;


import java.util.*;

/**
 * Created by Guest on 8/3/17.
 */
public class BlackJack {
    private String[] suits = {"♠","♣","♥","♦"};
    private String[] values = {"Ace", "2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private Integer[] scoreValue = {1,2,3,4,5,6,7,8,9,10,10,10,10};

    private int cardsLeft;
    private List<Card> deck = new ArrayList<Card>();

    public BlackJack() {
        for (int i = 0; i < suits.length; i++) {
            for (int j = 0; j < values.length; j ++) {
                deck.add( new Card(values[j], suits[i], scoreValue[j]) );
            }
        }
        cardsLeft = deck.size();
    }



    public Card getRandomCard(int cardsToDeal) {
        Random cardNum = new Random();
        Card nextCard = null;
        for (int i = 0; i < cardsToDeal; i++) {
            int cardSpot = cardNum.nextInt(cardsLeft - 1);
            nextCard = deck.get(cardSpot);

            deck.remove(cardSpot);
        }
        cardsLeft = cardsLeft - cardsToDeal;
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

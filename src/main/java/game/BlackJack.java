package game;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Guest on 8/3/17.
 */
public class BlackJack {
    private String[] suits = {"Spades","Clubs","Hearts","Diamonds"};
    private String[] values = {"Ace", "2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private int cardsLeft;
    private List<String> deck = new ArrayList<String>();
    private List<String> currentCards = new ArrayList<String>();

    public BlackJack() {
        for (String suit: suits) {
            for (String value: values) {
                deck.add(value + " of " + suit);
            }
        }
        cardsLeft = deck.size();
    }
    public List<String> getRandomCard(int cardsToDeal){

        Random cardNum = new Random();
        for (int i = 0; i < cardsToDeal; i++) {
            int cardSpot = cardNum.nextInt(cardsLeft);
            String nextCard = deck.get(cardSpot);
            currentCards.add(nextCard);
            deck.remove(cardSpot);

        }
        cardsLeft = cardsLeft - cardsToDeal;
        return currentCards;
    }

    //GETTERS
    public List<String> getDeck() {
        return deck;
    }
    public List<String> getCurrentCards() {
        return currentCards;
    }
    public int getCardsLeft() {
        return cardsLeft;
    }
}

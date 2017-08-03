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
    private int deckSize;
    private List<String> Deck = new ArrayList<String>();
    private List<String> currentCards = new ArrayList<String>();

    public BlackJack() {
        for (String suit: suits) {
            for (String value: values) {
                Deck.add(value + " of " + suit);
            }
        }
    }
    public List<String> getRandomCard(int deckSize, int cardsToDeal){

        Random cardNum = new Random();
        for (int i = 0; i < cardsToDeal; i++) {
            int cardSpot = cardNum.nextInt(deckSize);
            String nextCard = Deck.get(cardSpot);
            currentCards.add(nextCard);
            Deck.remove(cardSpot);
            System.out.println(nextCard);
        }return currentCards;
    }


    //GETTERS
    public List<String> getDeck() {
        return Deck;
    }
    public List<String> getCurrentCards() {
        return currentCards;
    }
}

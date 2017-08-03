package game;


import java.util.*;

/**
 * Created by Guest on 8/3/17.
 */
public class BlackJack {
    private String[] suits = {"Spades","Clubs","Hearts","Diamonds"};
    private String[] values = {"Ace", "2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private int cardsLeft;
    private List<String> deck = new ArrayList<String>();
    private List<String> currentCards = new ArrayList<String>();
    private Map<Character, Integer> cardValues = new HashMap<Character, Integer>();
    private int handTotal = 0;

    public int getHandTotal() {
        for (int i = 0; i < currentCards.size(); i++) {
            Character pointer = currentCards.get(i).charAt(0);
            handTotal += cardValues.get(pointer);
        }
        return handTotal;
    }

    public BlackJack() {
        for (String suit: suits) {
            for (String value: values) {
                deck.add(value + " of " + suit);
            }
        }
        cardsLeft = deck.size();
        for (int i = 0; i < 10; i ++) {
            Character letter = values[i].charAt(0);
            cardValues.put(letter, (1 + i));
        }
        for (int j = 9; j < 13; j++) {
            Character letter = values[j].charAt(0);
            cardValues.put(letter, 10);
        }
    }
    public List<String> getRandomCard(int cardsToDeal){

        Random cardNum = new Random();
        for (int i = 0; i < cardsToDeal; i++) {
            int cardSpot = cardNum.nextInt(cardsLeft-1);
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
    public Map<Character, Integer> getCardValues() {
        return cardValues;
    }
}

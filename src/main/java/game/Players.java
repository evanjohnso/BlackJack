package game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guest on 8/3/17.
 */
public class Players {
    private List<Card> currentCards = new ArrayList<Card>();
    private int handTotal = 0;
    private long bankAccount = 0;

    public Players (long buyIn) {
        this.bankAccount = buyIn;
    }

    //Setters
    public void setCurrentCards(Card currentCards) {
        this.currentCards.add(currentCards);
    }
    public void setHandTotal(int handTotal) {
        this.handTotal = handTotal;
    }
    public void setBankAccount(long bankAccount) {
        this.bankAccount = bankAccount;
    }
    public void wonRound(long bet) {this.bankAccount += bet;}
    public void lostRound(long bet) {this.bankAccount -= bet;}
    public void resetHand() {this.currentCards.clear();}
    //Getters
    public int getHandTotal() {
        handTotal = 0;
        int aces = 0;
        for (int i = 0; i < currentCards.size(); i++) {
            int thisValue = currentCards.get(i).getValue();
            //Refactor ace value
//            String findAce = currentCards.get(i).getNumber();
//            if (findAce.equals("Ace") && handTotal > 21) {
//
//            }

            if(thisValue == 1){
                handTotal += 11;
                aces++;
            }else{
                handTotal += thisValue;
            }
        } while(handTotal > 21 && aces > 0){
            handTotal -=10;
            aces --;
        }
        return handTotal;
    }

    public String getCurrentCards() {
        return currentCards.toString();
    }
    public long getBankAccount() {
        return bankAccount;
    }
}

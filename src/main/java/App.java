import game.BlackJack;
import game.Card;
import game.Players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.BufferPoolMXBean;
import java.util.List;

/**
 * Created by Guest on 8/3/17.
 */
public class App {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\nWelcome to BlackJack!\n");
        try {
            System.out.println("Buy in: $500, limit 10k. Throw down what you will.");
            long startCash = Long.parseLong(bufferedReader.readLine());
            if (startCash > 10001 || startCash < 500) {
                System.out.println("Please adhere to the buy in.");

            }
            //Instantiate player1 with cash
            Players player1 = new Players(startCash);
            boolean blackjack = true;
            boolean playing = true;
            do {
                //Remove the deal a fresh hand line
                System.out.println("Deal a fresh hand?");
                System.out.println("Cash: $" + player1.getBankAccount());
                //Remove
//                System.out.println("Place a bet(Enter bet) or cash in(cashIn)");
                String response = bufferedReader.readLine();
//                if (!"cashIn".equals(response)) {
                if ("yes".equals(response)) {
                    System.out.println("Gotta pay to play, hombre. Place bet:");
                    //Check to see if the bet amount is available in their current balance
                    long bet = Long.parseLong(bufferedReader.readLine());

                    //Create new deck with fresh hands
                    BlackJack casino = new BlackJack();
                    //Player Gets two
                    player1.resetHand();
                    Card playerCard = casino.getRandomCard();
                    Card playerCard2 = casino.getRandomCard();
                    player1.setCurrentCards(playerCard);
                    player1.setCurrentCards(playerCard2);
                    System.out.println("################################");
                    System.out.println("Your hand: " + player1.getCurrentCards());
                    System.out.println("Total: " + player1.getHandTotal());
                    //Dealer Gets two
                    Card dealerCard = casino.getRandomCard();
                    Card dealerCard2 = casino.getRandomCard();
                    Players dealer = new Players(0);
                    dealer.setCurrentCards(dealerCard);
                    dealer.setCurrentCards(dealerCard2);
                    System.out.println("\n################################\n");
                    System.out.println("Dealer: " + dealerCard2 + ", " + "│░░░░░░░░░│");
                    System.out.println("################################\n");
                    //If player is dealt casino, don't allow betting options..offer new deal
                    if (player1.getHandTotal() == 21) {
                        System.out.println("BlackJack!!!! ");
                        player1.wonRound(bet);
                        playing = false;
                    }
                    boolean gambling = true;
                    //If player1 not dealt casino, start gambling
                    if (playing) {
                        do {
                            System.out.println("Hit?");
                            String input = bufferedReader.readLine().toLowerCase();
                            if (input.equals("yes")) {
                                player1.setCurrentCards(casino.getRandomCard());
                                System.out.println("Your cards: " + player1.getCurrentCards());
                                System.out.println("Your hand: " + player1.getHandTotal());
                                if ((player1.getHandTotal() > 21)) {
                                    System.out.println("You've busted mate..Maybe you'll have better luck at the ponies\n");
                                    player1.lostRound(bet);
                                    System.out.println("####################################################################\n");
                                    gambling = false;
                                } else if (player1.getHandTotal() == 21) {
                                    System.out.println("BlackJack!!!! ");
                                    player1.wonRound(bet);
                                    gambling = false;
                                }
                            } else if (input.equals("no")) {
                                //If player stays, dealer hits while < 17
                                while (dealer.getHandTotal() < 17) {
                                    dealer.setCurrentCards(casino.getRandomCard());
                                }
                                System.out.println("Your total: " + player1.getHandTotal());
                                System.out.println("Dealer total: " + dealer.getHandTotal());
                                //If dealer busts || player1 has greater hand
                                if (dealer.getHandTotal() > 21) {
                                    System.out.println("\nDealer busted!!");
                                    player1.wonRound(bet);
                                } else if (dealer.getHandTotal() < player1.getHandTotal()) {
                                    System.out.println("\nYou beat the dealer!");
                                    player1.wonRound(bet);
                                } else {
                                    System.out.println("\nSorry friend, dealer wins!");
                                    player1.lostRound(bet);
                                }
                                System.out.println("################################");
                                gambling = false;
                            }
                        } while (gambling);
                    }
                } else if ("no".equals(response)) {
                    System.out.println("See ya later!");
                    System.out.println("Walking cash: $" + player1.getBankAccount());
                    blackjack = false;
                }
            } while (blackjack);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
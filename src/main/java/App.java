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
            System.out.println("Buy in is 500, limit 10k. Throw down what you will. How much?");
            long startCash = Long.parseLong(bufferedReader.readLine());
            if (startCash > 10001 || startCash < 500) {
                System.out.println("Please adhere to the buy in.");
            }
            boolean blackjack = true;
            boolean playing = true;
            do {
                System.out.println("Deal a fresh hand?");
                String response = bufferedReader.readLine();
                if ("yes".equals(response)) {
                    //Create new deck with fresh hands
                    BlackJack casino = new BlackJack();
                    //Player Gets two
                    Card playerCard = casino.getRandomCard();
                    Card playerCard2 = casino.getRandomCard();
                    Players player1 = new Players(playerCard);
                    player1.setCurrentCards(playerCard2);
                    System.out.println("################################");
                    System.out.println("Your hand: " + player1.getCurrentCards());
                    System.out.println("Total: " + player1.getHandTotal());
                    //dealer Gets two
                    Card dealerCard = casino.getRandomCard();
                    Card dealerCard2 = casino.getRandomCard();
                    Players dealer = new Players(dealerCard);
                    dealer.setCurrentCards(dealerCard2);
                    System.out.println("\n################################\n");
                    System.out.println("dealer: " + dealerCard2 + ", " + "│░░░░░░░░░│");
                    System.out.println("################################\n");
                    //If player is dealt casino, don't allow betting options..offer new deal
                    if (player1.getHandTotal() == 21) {
                        System.out.println("casino!!!! ");
                        playing = false;
                    }
                    boolean gambling = true;
                    //If player1 not dealt casino, start gambling
                    if (playing) {
                        do {
                            System.out.println("Hit?");
                            System.out.println("cards left: "+ casino.getCardsLeft());
                            String input = bufferedReader.readLine().toLowerCase();
                            if (input.equals("yes")) {
                                player1.setCurrentCards(casino.getRandomCard());
                                System.out.println("Your cards: " + player1.getCurrentCards());
                                System.out.println("Your hand: " + player1.getHandTotal());
                                if ((player1.getHandTotal() > 21)) {
                                    System.out.println("You've busted mate..Maybe you'll have better luck at the ponies");
                                    System.out.println("####################################################################\n");
                                    gambling = false;
                                } else if (player1.getHandTotal() == 21) {
                                    System.out.println("casino!!!! ");
                                    gambling = false;
                                }
                            } else if (input.equals("no")) {
                                //If player stays, dealer hits while < 17
                                while (dealer.getHandTotal() < 17) {
                                    dealer.setCurrentCards(casino.getRandomCard());
                                }
                                System.out.println("Your total: " + player1.getHandTotal());
                                System.out.println("dealer total: " + dealer.getHandTotal());
                                //If dealer busts || player1 has greater hand
                                if (dealer.getHandTotal() > 21)
                                    System.out.println("\ndealer busted!!");
                                else if (dealer.getHandTotal() < player1.getHandTotal())
                                    System.out.println("\nYou win!");
                                else
                                    System.out.println("\ndealer wins!");
                                System.out.println("################################");
                                gambling = false;
                            }
                        } while (gambling);
                    }
                } else if ("no".equals(response)) {
                    System.out.println("See ya later!");
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

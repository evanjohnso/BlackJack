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
            boolean blackjack = true;
            System.out.println("Buy in is 500, limit 10k. Throw down what you will. How much?");
            long startCash = Long.parseLong(bufferedReader.readLine());
            if (startCash > 10001 || startCash < 500) {
                System.out.println("Please adhere to the buy in.");
                blackjack = false;
            }
            while (blackjack) {
                System.out.println("Deal?");
                String response = bufferedReader.readLine();





                if ("yes".equals(response)) {

                    BlackJack newGame = new BlackJack();
                    System.out.println("\nHere are your first two cards\n");
                    //Dealer Gets two
                    Card dealerCard = newGame.getRandomCard(1);
                    Card dealerCard2 = newGame.getRandomCard(1);
                    Players Dealer = new Players(dealerCard);
                    Dealer.setCurrentCards(dealerCard2);
                    //Player Gets two
                    Card playerCard = newGame.getRandomCard(1);
                    Card playerCard2 = newGame.getRandomCard(1);
                    Players User = new Players(playerCard);
                    User.setCurrentCards(playerCard2);
                    //Display on terminal
                    System.out.println("################################");
                    System.out.println("Your hand: " + User.getCurrentCards());
                    System.out.println("Total: " + User.getHandTotal());
                    System.out.println("\n################################\n");
                    System.out.println("Dealer: " + dealerCard2 + ", " + "│░░░░░░░░░│");
                    System.out.println("################################\n");

                    boolean gambling = true;
                    while (gambling) {
                        if (User.getHandTotal() == 21) {
                            System.out.println("BLACKJACK!!!! ");
                            gambling = false;
                        }
                        System.out.println("Want to hit this shit, son?");
                        String input = bufferedReader.readLine().toLowerCase();
                        if (input.equals("yes")) {
                            User.setCurrentCards(newGame.getRandomCard(1));
                            System.out.println("Your cards: " + User.getCurrentCards());
                            System.out.println("Your hand: " + User.getHandTotal());
                            if ((User.getHandTotal() > 21)) {
                                System.out.println("You've busted mate..Maybe you'll have better luck at the ponies");
                                System.out.println("####################################################################\n");
                            } else if (User.getHandTotal() == 21)
                                System.out.println("BLACKJACK!!!! ");
                            //Both should end the hand
                            gambling = false;
                        }

                        //GAMBLING LOOP NEEDS TO END HERE I THINK

                        else if (input.equals("no")) {
                            while (Dealer.getHandTotal() < 17) {
                                Dealer.setCurrentCards(newGame.getRandomCard(1));
                            }
                            System.out.println("\nYour hand: " + User.getCurrentCards());
                            System.out.println("Total: " + User.getHandTotal());
                            System.out.println("################################");
                            System.out.println("\nDealers hand: " + Dealer.getCurrentCards());
                            System.out.println("Dealer total: \n" + Dealer.getHandTotal());

                            boolean winner = Dealer.getHandTotal() < User.getHandTotal();
                            if (winner || (Dealer.getHandTotal() >= 21))
                                System.out.println("\nYOU WINNNNNN!!!");
                            else
                                System.out.println("\nDealer took ya for a ride! YA got no ♥...probably...cuz ya lost");
                            gambling = false;
                        }
                    }
                }






                else if("no".equals(response)) {
                    System.out.println("See ya later!");
                    blackjack = false;
                    break;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

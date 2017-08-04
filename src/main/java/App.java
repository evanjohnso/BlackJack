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
        System.out.println("Welcome to BlackJack! Would you like to play? Yes or No!");

        try {

            boolean blackjack= true;
            String response = bufferedReader.readLine();
            System.out.println("Buy in is 500, feel free to throw down what you will. How much?");
            long startCash = Long.parseLong(bufferedReader.readLine());
            if (startCash > 10001) {
                System.out.println("We don't have that kind of cash on hand. Keep in your pants");
                blackjack = false;
            }
            while (blackjack) {
                if(response == "yes"){
                    blackjack =true;
                }else if(response == "no"){
                    blackjack = false;
                }
                BlackJack newGame = new BlackJack();
                System.out.println("Here are your first two cards\n");
                boolean gambling = true;
                //Dealer Gets two
                Players Dealer = new Players(dealerCard);
                Dealer.setCurrentCards(dealerCard2);
                Card dealerCard = newGame.getRandomCard(1);
                Card dealerCard2 = newGame.getRandomCard(1);
                //Player Gets two
                Card playerCard = newGame.getRandomCard(1);
                Card playerCard2 = newGame.getRandomCard(1);
                Players User = new Players(playerCard);
                User.setCurrentCards(playerCard2);
                //Display on terminal
                System.out.println("################################\n");
                System.out.println("Your hand: " + User.getCurrentCards());
                System.out.println("Total: " + User.getHandTotal());
                System.out.println("################################\n");
                System.out.println("Dealer: " + dealerCard2 + "," + "\t\uD83C\uDCC3\t\uD83C\uDCC3\t\uD83C\uDCC3\t\uD83C\uDCC3 ##\n");
                System.out.println("################################\n");

                while (gambling) {
                    System.out.println("Want to hit this shit, son?");
                    String input = bufferedReader.readLine().toLowerCase();
                    if (input.equals("y")) {
                        User.setCurrentCards(newGame.getRandomCard(1));
                        System.out.println("Your hand: " + User.getCurrentCards());
                        System.out.println("Total: " + User.getHandTotal());
                        if ((User.getHandTotal() > 21)) {
                            System.out.println("You've been beat old top..Maybe you'll have better luck at the ponies");
                            System.out.println("####################################################################");
                            System.out.println("Why would you even listen to me? I don't have the capacity to love!");
                            gambling = false;
                        } else if (User.getHandTotal() == 21) {
                            System.out.println("Wahooo You've won! BLACKJACK!!!! Take me somewhere nice! It's cold in here!");

                            gambling = false;
                        }
                    } else if (input.equals("n")) {
                        while (Dealer.getHandTotal() < 17) {
                            Dealer.setCurrentCards(newGame.getRandomCard(1));
                        }
                        System.out.println("Your hand: " + User.getCurrentCards());
                        System.out.println("Total: " + User.getHandTotal());
                        System.out.println("################################");
                        System.out.println("Dealers hand: " + Dealer.getCurrentCards());
                        System.out.println("Dealer total: " + Dealer.getHandTotal());
                        boolean winner = Dealer.getHandTotal() < User.getHandTotal();
                        if (winner || (Dealer.getHandTotal() >= 21)) {
                            System.out.println("YOU WINNNNNN!!!");
                        } else {
                            System.out.println("Clearly you shouldn't be playing, Buckaroo! YA got no ♥...probably...cuz ya lost");
                        }
                        gambling = false;
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

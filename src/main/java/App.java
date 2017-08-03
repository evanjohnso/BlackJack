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

        try {
            BlackJack newGame = new BlackJack();

            System.out.println("Welcome to BlackJack!");
            System.out.println("Here are your first two cards");
            boolean gambling = true;

            Card dealerCard = newGame.getRandomCard(1);
            Card dealerCard2 = newGame.getRandomCard(1);
            Card playerCard = newGame.getRandomCard(1);
            Card playerCard2 = newGame.getRandomCard(1);
            Players Dealer = new Players(dealerCard);
            Dealer.setCurrentCards(dealerCard2);
            Players User = new Players(playerCard);
            User.setCurrentCards(playerCard2);

            System.out.println("Your hand: " + User.getCurrentCards() );
            System.out.println("Total: " + User.getHandTotal());

            while (gambling) {
                System.out.println("Want to hit this shit son?");
                String input = bufferedReader.readLine().toLowerCase();
                if (input.equals("y")) {
                    User.setCurrentCards( newGame.getRandomCard(1) );
                    System.out.println("Your hand: " + User.getCurrentCards() );
                    System.out.println("Total: " + User.getHandTotal());
                    if((User.getHandTotal() > 21)){
                        System.out.println("You've been beat old top..Maybe you'll have better luck at the ponies");

                        gambling = false;
                    } else if(User.getHandTotal() == 21){
                        System.out.println("Wahooo You've won! Take me somewhere nice! It's cold in here!");

                        gambling = false;
                    } else{
                        System.out.println("I'd hit again if I were you...who knows what lady luck'll bring!");
                    }
                } else if(input.equals("n")){
                    System.out.println("Clearly you shouldn't be playing, Buckaroo! YA got no ♥...probably");
                    System.out.println("Your hand: " + User.getCurrentCards() );
                    System.out.println("Total: " + User.getHandTotal());
                    gambling = false;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}

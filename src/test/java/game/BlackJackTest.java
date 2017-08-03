package game;

import org.junit.*;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Guest on 8/3/17.
 */
public class BlackJackTest {
        @Test
        public void runBlackJack_createCardDeck_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getDeck();
            assertEquals(52, testBlackJack.getDeck().size());
        }
        @Test
        public void runBlackJack_getRandomCard_2 () {
            BlackJack testBlackJack = new BlackJack();
            boolean expectedOutput = false;
            List<String> nextCard = testBlackJack.getRandomCard(1);
            if (testBlackJack.getDeck().contains(nextCard))
                expectedOutput = true;
            assertFalse(expectedOutput);
        }
        @Test
        public void runBlackJack_changeDeckSize_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getRandomCard(2);
            assertEquals(50, testBlackJack.getDeck().size());
        }
        @Test
        public void runBlackJack_currentHand_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getRandomCard(2);
            assertEquals(2, testBlackJack.getCurrentCards().size());
        }
        @Test
        public void runBlackJack_workingDeckChangesSize_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getRandomCard(2);
            assertEquals(50, testBlackJack.getCardsLeft());
        }
        @Test
        public void runBlackJack_assignValues_1 () {
            BlackJack testBlackJack = new BlackJack();
            int output = testBlackJack.getCardValues().get("4");
            assertEquals(8, output);
    }
}
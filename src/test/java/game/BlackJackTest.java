package game;

import org.junit.*;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


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
            List<String> nextCard = testBlackJack.getRandomCard();
            if (testBlackJack.getDeck().contains(nextCard))
                expectedOutput = true;
            assertFalse(expectedOutput);
        }
        @Test
        public void runBlackJack_changeDeckSize_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getRandomCard();
            assertEquals(51, testBlackJack.getDeck().size());
        }
        @Test
        public void runBlackJack_currentHand_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getRandomCard();
            assertEquals(2, testBlackJack.getCurrentCards().size());
        }
        @Test
        public void runBlackJack_workingDeckChangesSize_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getRandomCard();
            assertEquals(51, testBlackJack.getCardsLeft());
        }
        @Test
        public void runBlackJack_assignValues_1 () {
            BlackJack testBlackJack = new BlackJack();
            int output = testBlackJack.getCardValues().get('4');
            assertEquals(4, output);
        }
        @Test
        public void runBlackJack_cardTotalAsInteger_1 () {
            BlackJack testBlackJack = new BlackJack();
            testBlackJack.getRandomCard();
            testBlackJack.getRandomCard();
            System.out.println(testBlackJack.getCurrentCards());
            assertEquals(2, testBlackJack.getHandTotal());
        }
    }
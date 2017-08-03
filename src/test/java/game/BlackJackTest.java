package game;

import org.junit.*;

import java.util.List;

import static org.junit.Assert.*;


/**
 * Created by Guest on 8/3/17.
 */
public class BlackJackTest {
    @Test
    public void runBlackJack_createCardDeck_1() {
        BlackJack testBlackJack = new BlackJack();
        testBlackJack.getDeck();
        assertEquals(52, testBlackJack.getDeck().size());
    }

    @Test
    public void runBlackJack_getRandomCard_2() {
        BlackJack testBlackJack = new BlackJack();
        boolean expectedOutput = false;
        List<String> nextCard = testBlackJack.getRandomCard(52, 1);
        if (testBlackJack.getDeck().contains(nextCard)) {
            expectedOutput = true;
            System.out.println(nextCard);
        }
        assertFalse(expectedOutput);
    }

    @Test
    public void runBlackJack_changeDeckSize_1() {
        BlackJack testBlackJack = new BlackJack();
        testBlackJack.getRandomCard(52, 2);
        assertEquals(51, testBlackJack.getDeck().size());
    }
}
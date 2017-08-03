package game;

import org.junit.*;
import static org.junit.Assert.*;


/**
 * Created by Guest on 8/3/17.
 */
public class BlackJackTest {
    @Test
    public void runBlackJack_createCardDeck_1(){
        BlackJack testBlackJack = new BlackJack();
        testBlackJack.getDeck();
        assertEquals(true, testBlackJack.getDeck());
    }


}
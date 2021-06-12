package com.example.cardgames;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class Test_DrawPile {

    @Test
    public void test_DeckGeneration() {
        Deck deck = new Deck();

        int egg = 0;
        assertEquals(52, deck.getNumOfRemainingCards());
    }

    @Test
    public void test_DrawFromDeck() {

        Deck deck = new Deck();

        for (int i = 52; i >= 0; i--) {
            if (i == 0) {
                assertNull(deck.drawCard());
            } else {
                ICard card = deck.drawCard();
                assertNotNull(card);
                assertEquals(i - 1, deck.getNumOfRemainingCards());
            }

        }

    }

    @Test
    public void scratchTest(){
        int[] egg1 = new int[]{1};
        int[] egg2 = new int[]{1};

        assertTrue(egg1.equals(egg2));

        int egg = 0;
    }

}
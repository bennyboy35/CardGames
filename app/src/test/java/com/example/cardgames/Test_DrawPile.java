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
}
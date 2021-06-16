package com.example.cardgames;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test_Joker {


    @Test(dataProvider = "cardTests")
    public void test_CardRankTest(EPontoonCardType cardType, ESuite cardSuite) {
        Joker joker = new Joker();
        assertTrue(joker.isJoker());
        StandardCard card1 = new StandardCard(cardType, cardSuite);
        assertFalse(card1.isJoker());

        assertTrue(joker.isRankEqual(card1));
        assertTrue(joker.isSameSuite(card1));
        assertTrue(card1.isRankEqual(joker));
        assertTrue(card1.isSameSuite(joker));
    }

    @DataProvider(name = "cardTests")
    public Object[][] rankTests() {

        return new Object[][]{
                {EPontoonCardType.FOUR, ESuite.HEARTS},
                {EPontoonCardType.ACE, ESuite.DIAMONDS},
                {EPontoonCardType.JACK, ESuite.HEARTS},
                {EPontoonCardType.TEN, ESuite.HEARTS},
                {EPontoonCardType.TWO, ESuite.SPADES},
                {EPontoonCardType.FIVE, ESuite.CLUBS},
                {EPontoonCardType.EIGHT, ESuite.DIAMONDS},
        };
    }
}
package com.example.cardgames;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Test_Joker {


    @Test(dataProvider = "cardTests")
    public void test_CardRankTest(ECardType cardType, ESuite cardSuite) {
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
                {ECardType.FOUR, ESuite.HEARTS},
                {ECardType.ACE, ESuite.DIAMONDS},
                {ECardType.JACK, ESuite.HEARTS},
                {ECardType.TEN, ESuite.HEARTS},
                {ECardType.TWO, ESuite.SPADES},
                {ECardType.FIVE, ESuite.CLUBS},
                {ECardType.EIGHT, ESuite.DIAMONDS},
        };
    }
}
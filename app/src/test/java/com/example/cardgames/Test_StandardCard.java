package com.example.cardgames;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class Test_StandardCard {


    @Test(dataProvider = "cardTests")
    public void test_CardRankTest(EPontoonCardType cardType, ESuite cardSuite) {
        StandardCard card = new StandardCard(cardType, cardSuite);
        int[] actualRanks = card.getRanks();
        int[] expectedRanks = cardType.getRanks();
        assertEquals(expectedRanks[0], actualRanks[0]);

    }


    @Test(dataProvider = "cardTests")
    public void test_CardSuiteAndType(EPontoonCardType cardType, ESuite cardSuite) {

        StandardCard card = new StandardCard(cardType, cardSuite);
        assertEquals(cardSuite, card.getSuite());
        assertEquals(cardType, card.getCardType());
    }

    @Test(dataProvider = "cardTests")
    public void test_IsCardJoker(EPontoonCardType cardType, ESuite cardSuite) {
        StandardCard card = new StandardCard(cardType, cardSuite);
        assertFalse(card.isJoker());

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

    @Test(dataProvider = "sameSuiteTests")
    public void test_AreCardsSameSuite(EPontoonCardType cardType1, ESuite cardSuite1, EPontoonCardType cardType2, ESuite cardSuite2, boolean expectedSame) {
        StandardCard card1 = new StandardCard(cardType1, cardSuite1);
        StandardCard card2 = new StandardCard(cardType2, cardSuite2);

        assertEquals(expectedSame, card1.isSameSuite(card2));
    }

    @DataProvider(name = "sameSuiteTests")
    public Object[][] sameSuiteTests() {

        return new Object[][]{
                {EPontoonCardType.FOUR, ESuite.HEARTS, EPontoonCardType.FOUR, ESuite.HEARTS, true},
                {EPontoonCardType.ACE, ESuite.DIAMONDS, EPontoonCardType.FOUR, ESuite.HEARTS, false},
                {EPontoonCardType.JACK, ESuite.HEARTS, EPontoonCardType.TWO, ESuite.HEARTS, true},
                {EPontoonCardType.TEN, ESuite.HEARTS, EPontoonCardType.ACE, ESuite.DIAMONDS, false},
                {EPontoonCardType.TWO, ESuite.SPADES, EPontoonCardType.ACE, ESuite.DIAMONDS, false},
                {EPontoonCardType.FIVE, ESuite.CLUBS, EPontoonCardType.FIVE, ESuite.CLUBS, true},
                {EPontoonCardType.EIGHT, ESuite.DIAMONDS, EPontoonCardType.TWO, ESuite.HEARTS, false},
        };
    }

    @Test(dataProvider = "sameRankTests")
    public void test_AreCardsSameRank(EPontoonCardType cardType1, ESuite cardSuite1, EPontoonCardType cardType2, ESuite cardSuite2, boolean expectedSame) {
        StandardCard card1 = new StandardCard(cardType1, cardSuite1);
        StandardCard card2 = new StandardCard(cardType2, cardSuite2);

        assertEquals(expectedSame, card1.isRankEqual(card2));
    }

    @DataProvider(name = "sameRankTests")
    public Object[][] sameRankTests() {

        return new Object[][]{
                {EPontoonCardType.FOUR, ESuite.HEARTS, EPontoonCardType.FOUR, ESuite.HEARTS, true},
                {EPontoonCardType.ACE, ESuite.DIAMONDS, EPontoonCardType.FOUR, ESuite.HEARTS, false},
                {EPontoonCardType.JACK, ESuite.HEARTS, EPontoonCardType.TWO, ESuite.HEARTS, false},
                {EPontoonCardType.TEN, ESuite.HEARTS, EPontoonCardType.ACE, ESuite.DIAMONDS, false},
                {EPontoonCardType.TWO, ESuite.SPADES, EPontoonCardType.ACE, ESuite.DIAMONDS, false},
                {EPontoonCardType.FIVE, ESuite.CLUBS, EPontoonCardType.FIVE, ESuite.CLUBS, true},
                {EPontoonCardType.EIGHT, ESuite.DIAMONDS, EPontoonCardType.TWO, ESuite.HEARTS, false},
        };
    }

}
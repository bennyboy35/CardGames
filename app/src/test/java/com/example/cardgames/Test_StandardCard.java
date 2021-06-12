package com.example.cardgames;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class Test_StandardCard {


    @Test(dataProvider = "cardTests")
    public void test_CardRankTest(ECardType cardType, ESuite cardSuite) {
        StandardCard card = new StandardCard(cardType, cardSuite);
        int[] actualRanks = card.getRanks();
        int[] expectedRanks = cardType.getRanks();
        assertEquals(expectedRanks[0], actualRanks[0]);

    }


    @Test(dataProvider = "cardTests")
    public void test_CardSuiteAndType(ECardType cardType, ESuite cardSuite){

        StandardCard card = new StandardCard(cardType, cardSuite);
        assertEquals(cardSuite, card.getSuite());
        assertEquals(cardType, card.getCardType());


    }

    @Test(dataProvider = "cardTests")
    public void test_IsCardJoker(ECardType cardType, ESuite cardSuite){
        StandardCard card = new StandardCard(cardType, cardSuite);
        assertFalse(card.isJoker());

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

    @Test(dataProvider = "sameSuiteTests")
    public void test_AreCardsSameSuite(ECardType cardType1, ESuite cardSuite1, ECardType cardType2, ESuite cardSuite2, boolean expectedSame){
        StandardCard card1 = new StandardCard(cardType1, cardSuite1);
        StandardCard card2 = new StandardCard(cardType2, cardSuite2);

        assertEquals(expectedSame, card1.isSameSuite(card2));
    }

    @DataProvider(name = "sameSuiteTests")
    public Object[][] sameSuiteTests() {

        return new Object[][]{
                {ECardType.FOUR, ESuite.HEARTS, ECardType.FOUR, ESuite.HEARTS, true},
                {ECardType.ACE, ESuite.DIAMONDS, ECardType.FOUR, ESuite.HEARTS, false},
                {ECardType.JACK, ESuite.HEARTS, ECardType.TWO, ESuite.HEARTS, true},
                {ECardType.TEN, ESuite.HEARTS, ECardType.ACE, ESuite.DIAMONDS, false},
                {ECardType.TWO, ESuite.SPADES, ECardType.ACE, ESuite.DIAMONDS, false},
                {ECardType.FIVE, ESuite.CLUBS, ECardType.FIVE, ESuite.CLUBS, true},
                {ECardType.EIGHT, ESuite.DIAMONDS, ECardType.TWO, ESuite.HEARTS, false},
        };
    }

    @Test(dataProvider = "sameRankTests")
    public void test_AreCardsSameRank(ECardType cardType1, ESuite cardSuite1, ECardType cardType2, ESuite cardSuite2, boolean expectedSame){
        StandardCard card1 = new StandardCard(cardType1, cardSuite1);
        StandardCard card2 = new StandardCard(cardType2, cardSuite2);

        assertEquals(expectedSame, card1.isRankEqual(card2));
    }

    @DataProvider(name = "sameRankTests")
    public Object[][] sameRankTests() {

        return new Object[][]{
                {ECardType.FOUR, ESuite.HEARTS, ECardType.FOUR, ESuite.HEARTS, true},
                {ECardType.ACE, ESuite.DIAMONDS, ECardType.FOUR, ESuite.HEARTS, false},
                {ECardType.JACK, ESuite.HEARTS, ECardType.TWO, ESuite.HEARTS, false},
                {ECardType.TEN, ESuite.HEARTS, ECardType.ACE, ESuite.DIAMONDS, false},
                {ECardType.TWO, ESuite.SPADES, ECardType.ACE, ESuite.DIAMONDS, false},
                {ECardType.FIVE, ESuite.CLUBS, ECardType.FIVE, ESuite.CLUBS, true},
                {ECardType.EIGHT, ESuite.DIAMONDS, ECardType.TWO, ESuite.HEARTS, false},
        };
    }

}
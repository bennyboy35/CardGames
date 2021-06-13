package com.example.cardgames;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Test_Hand {


    @Test(dataProvider = "cards")
    public void test_CardRankTest(int[] expectedScores, ICard... cards) {

        Hand hand = new Hand(cards);
        assertArrayEquals(expectedScores, hand.getScore());
    }

    @DataProvider(name = "cards")
    public Object[][] rankTests() {

        return new Object[][]{
                {new int[]{0}, new ICard[0]},

                {new int[]{4}, new StandardCard(ECardType.FOUR, ESuite.HEARTS)},
                {new int[]{10}, new StandardCard(ECardType.TEN, ESuite.DIAMONDS)},
                {new int[]{2}, new StandardCard(ECardType.TWO, ESuite.CLUBS)},
                {new int[]{10}, new StandardCard(ECardType.JACK, ESuite.SPADES)},

                {new int[]{1,11}, new StandardCard(ECardType.ACE, ESuite.SPADES)},
                {new int[]{1,2,3,4,5,6,7,8,9,10,11}, new Joker()},

                {new int[]{12}, new StandardCard(ECardType.FOUR, ESuite.HEARTS), new StandardCard(ECardType.EIGHT, ESuite.CLUBS)},
                {new int[]{20}, new StandardCard(ECardType.TEN, ESuite.CLUBS), new StandardCard(ECardType.JACK, ESuite.CLUBS)},
                {new int[]{12}, new StandardCard(ECardType.TWO, ESuite.HEARTS), new StandardCard(ECardType.QUEEN, ESuite.SPADES)},

                {new int[]{3, 13}, new StandardCard(ECardType.TWO, ESuite.HEARTS), new StandardCard(ECardType.ACE, ESuite.SPADES)},
                {new int[]{3, 13}, new StandardCard(ECardType.ACE, ESuite.HEARTS), new StandardCard(ECardType.TWO, ESuite.SPADES)},
                {new int[]{2, 12, 22}, new StandardCard(ECardType.ACE, ESuite.HEARTS), new StandardCard(ECardType.ACE, ESuite.SPADES)},
                {new int[]{3,13,23,33}, new StandardCard(ECardType.ACE, ESuite.HEARTS), new StandardCard(ECardType.ACE, ESuite.SPADES), new StandardCard(ECardType.ACE, ESuite.CLUBS)},

                {new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22}, new StandardCard(ECardType.ACE, ESuite.HEARTS), new Joker()},
                {new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22}, new Joker(), new Joker()},
        };
    }
}
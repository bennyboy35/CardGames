package com.example.cardgames;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class Test_Hand {


    @Test(dataProvider = "cards")
    public void test_PossibleScoreCombinations(int[] expectedScores, ICard... cards) {

        Hand hand = new Hand(cards);
        assertArrayEquals(expectedScores, hand.getPossibleScoreCombinations());
    }

    @DataProvider(name = "cards")
    public Object[][] rankTests() {

        return new Object[][]{
                {new int[]{0}, new ICard[0]},

                {new int[]{4}, new StandardCard(EPontoonCardType.FOUR, ESuite.HEARTS)},
                {new int[]{10}, new StandardCard(EPontoonCardType.TEN, ESuite.DIAMONDS)},
                {new int[]{2}, new StandardCard(EPontoonCardType.TWO, ESuite.CLUBS)},
                {new int[]{10}, new StandardCard(EPontoonCardType.JACK, ESuite.SPADES)},

                {new int[]{1,11}, new StandardCard(EPontoonCardType.ACE, ESuite.SPADES)},
                {new int[]{1,2,3,4,5,6,7,8,9,10,11}, new Joker()},

                {new int[]{12}, new StandardCard(EPontoonCardType.FOUR, ESuite.HEARTS), new StandardCard(EPontoonCardType.EIGHT, ESuite.CLUBS)},
                {new int[]{20}, new StandardCard(EPontoonCardType.TEN, ESuite.CLUBS), new StandardCard(EPontoonCardType.JACK, ESuite.CLUBS)},
                {new int[]{12}, new StandardCard(EPontoonCardType.TWO, ESuite.HEARTS), new StandardCard(EPontoonCardType.QUEEN, ESuite.SPADES)},

                {new int[]{3, 13}, new StandardCard(EPontoonCardType.TWO, ESuite.HEARTS), new StandardCard(EPontoonCardType.ACE, ESuite.SPADES)},
                {new int[]{3, 13}, new StandardCard(EPontoonCardType.ACE, ESuite.HEARTS), new StandardCard(EPontoonCardType.TWO, ESuite.SPADES)},
                {new int[]{2, 12, 22}, new StandardCard(EPontoonCardType.ACE, ESuite.HEARTS), new StandardCard(EPontoonCardType.ACE, ESuite.SPADES)},
                {new int[]{3,13,23,33}, new StandardCard(EPontoonCardType.ACE, ESuite.HEARTS), new StandardCard(EPontoonCardType.ACE, ESuite.SPADES), new StandardCard(EPontoonCardType.ACE, ESuite.CLUBS)},

                {new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22}, new StandardCard(EPontoonCardType.ACE, ESuite.HEARTS), new Joker()},
                {new int[]{2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22}, new Joker(), new Joker()},
        };
    }
}
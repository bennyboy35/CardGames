package com.example.cardgames;

import androidx.annotation.NonNull;

import org.apache.commons.lang3.ArrayUtils;

public class StandardCard extends Card implements IStandardCard {

    private EPontoonCardType cardType;
    private ESuite cardSuite;

    public StandardCard(EPontoonCardType cardType, ESuite cardSuite) {
        this.cardSuite = cardSuite;
        this.cardType = cardType;
    }

    @Override
    public ESuite getSuite() {
        return cardSuite;
    }

    public EPontoonCardType getCardType() {
        return cardType;
    }

    @Override
    public int[] getRanks() {
        return cardType.getRanks();
    }

    @Override
    public boolean isSameSuite(ICard card) {
        if (card.isJoker()) {
            //Jokers are wild
            return true;
        }
        return this.getSuite() == ((StandardCard) card).getSuite();
    }

    @Override
    public boolean isRankEqual(ICard card) {
        if (card.isJoker()) {
            //Jokers are wild
            return true;
        }
        for (int rank : this.getRanks()) {
            if (ArrayUtils.contains(((StandardCard) card).getRanks(), rank)) {
                return true;
            }
        }
        return false;
    }

    @NonNull
    @Override
    public String toString() {
        return cardType.toString() + cardSuite.toString();
    }
}

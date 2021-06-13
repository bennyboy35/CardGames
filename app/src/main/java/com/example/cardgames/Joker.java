package com.example.cardgames;

import androidx.annotation.NonNull;

public class Joker extends Card{


    @Override
    public int[] getRanks() {
        return new int[]{1,2,3,4,5,6,7,8,9,10,11};
    }

    @Override
    public boolean isJoker() {
        return true;
    }

    @Override
    public boolean isSameSuite(ICard card) {
        return true;
    }

    @Override
    public boolean isRankEqual(ICard card) {
        return true;
    }

    @NonNull
    @Override
    public String toString() {
        return "\uD83C\uDCCF";
    }
}

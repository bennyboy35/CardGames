package com.example.cardgames;

import androidx.annotation.NonNull;

public enum ECardType {

    TWO(new int[]{2},"2"),
    THREE(new int[]{3}, "3"),
    FOUR(new int[]{4}, "4"),
    FIVE(new int[]{5}, "5"),
    SIX(new int[]{6}, "6"),
    SEVEN(new int[]{7}, "7"),
    EIGHT(new int[]{8}, "8"),
    NINE(new int[]{9}, "9"),
    TEN(new int[]{10}, "10"),
    JACK(new int[]{10}, "J"),
    KING(new int[]{10}, "K"),
    QUEEN(new int[]{10}, "Q"),
    ACE(new int[]{1,11}, "A");

    int[] values;
    String string;

    ECardType(int[] values, String string){
        this.values = values;
        this.string = string;

    }

    public int[] getRanks() {
        return values;
    }

    @NonNull
    @Override
    public String toString() {
        return string;
    }
}

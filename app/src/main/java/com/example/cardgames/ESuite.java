package com.example.cardgames;

import androidx.annotation.NonNull;

public enum ESuite {

    DIAMONDS("◆"),
    CLUBS("♣"),
    HEARTS("❤"),
    SPADES("♠");

    private String string;

    ESuite(String string){
        this.string = string;
    }

    @NonNull
    @Override
    public String toString() {
        return string;
    }
}

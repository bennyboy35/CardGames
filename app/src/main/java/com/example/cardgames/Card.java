package com.example.cardgames;

public abstract class Card implements ICard{

    @Override
    public boolean isJoker() {
        return false;
    }
}

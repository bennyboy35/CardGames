package com.example.cardgames;

public interface ICard{

    int[] getRanks();

    boolean isJoker();

    boolean isSameSuite(ICard card);

    boolean isRankEqual(ICard card);


}

package com.example.cardgames;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.CheckForNull;

public class Deck {

    private List<ICard> cards = new ArrayList<>(52);

    Deck(){

        for (ESuite cardSuit : ESuite.values()){
            for (ECardType cardType : ECardType.values()){

                StandardCard card = new StandardCard(cardType, cardSuit);
                cards.add(card);
            }
        }
        Collections.shuffle(cards);
    }

    Deck(List<ICard> cards){
        this.cards = cards;

    }

    public int getNumOfRemainingCards(){
        return cards.size();
    }

    @CheckForNull
    public ICard drawCard(){
        if (cards.isEmpty()){
            return null;
        }
        ICard retrievedCard = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return retrievedCard;
    }

}

package com.example.cardgames;

import androidx.collection.ArraySet;

import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hand {

    private List<ICard> cards = new ArrayList<>(100);

    Hand(ICard... cardsToAddToHand) {
        for (ICard card : cardsToAddToHand) {
            cards.add(card);
        }
    }

    Hand(List<ICard> cards) {
        this.cards = cards;

    }

    public int[] getPossibleScoreCombinations() {
        int[] scores = new int[]{0};
        for (ICard card : cards) {
            int[] ranks = card.getRanks();
            int originalScoresLength = scores.length;
            for (int i = 0; i < originalScoresLength; i++) {
                int existingScore = scores[i];
                for (int j = 0; j < ranks.length; j++) {
                    if (j == 0) {
                        scores[i] += ranks[0];
                    } else {
                        int newScore = existingScore + ranks[j];
                        scores = ArrayUtils.insert(scores.length, scores, newScore);
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int score : scores) {
            set.add(score);
        }
        int[] noDupesScores = Ints.toArray(set);
        Arrays.sort(noDupesScores);
        return noDupesScores;
    }
}

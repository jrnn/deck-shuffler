package com.github.jrnn.shuffler.domain;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/**
 * Deck represents a standard 52-card deck, with exactly one of each possible suite-rank combination. Deck instances
 * are initialized such that the cards are in "new deck order".
 */
public class Deck {

    private static final EnumSet<Rank> RANKS = EnumSet.allOf(Rank.class);
    private static final EnumSet<Suite> SUITES = EnumSet.allOf(Suite.class);

    /**
     * Note: I would always prefer Sets to Lists (for performance), but in this case the order of the cards
     * <em>actually matters</em>. Hence, we're forced to use a List. But it won't cause any real performance drawback,
     * because size is always fixed at 52.
     */
    private final List<Card> cards = new ArrayList<>(52);

    public Deck() {
        initialize();
    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    private void initialize() {
        SUITES.stream()
                .flatMap(suite -> RANKS.stream()
                        .map(rank -> Card.of(rank, suite)))
                .forEachOrdered(cards::add);
    }
}

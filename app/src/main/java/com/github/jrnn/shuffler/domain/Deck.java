package com.github.jrnn.shuffler.domain;

import static com.github.jrnn.shuffler.domain.Suite.CLUBS;
import static com.github.jrnn.shuffler.domain.Suite.DIAMONDS;
import static com.github.jrnn.shuffler.domain.Suite.HEARTS;
import static com.github.jrnn.shuffler.domain.Suite.SPADES;
import static java.util.Collections.reverseOrder;
import static java.util.stream.Collectors.joining;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Stream;

/**
 * Deck represents a standard 52-card deck, with exactly one of each possible suite-rank combination. Deck instances
 * are initialized such that the cards are in "new deck order".
 */
public class Deck {

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
        return cards.stream()
                .map(Object::toString)
                .collect(joining(", "));
    }

    private void initialize() {
        // TODO this kind of thing looks a bit out of place in a domain (POJO) class, probably would be idiomatic
        //      to extract it to e.g. a "DeckFactory". but whatever
        EnumSet<Rank> ranks = EnumSet.allOf(Rank.class);
        Stream.of(HEARTS, CLUBS)
                .flatMap(suite -> ranks.stream()
                        .map(rank -> Card.of(rank, suite)))
                .forEachOrdered(cards::add);

        Stream.of(DIAMONDS, SPADES)
                .flatMap(suite -> ranks.stream()
                        .sorted(reverseOrder())
                        .map(rank -> Card.of(rank, suite)))
                .forEachOrdered(cards::add);
    }
}

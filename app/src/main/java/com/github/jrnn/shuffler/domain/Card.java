package com.github.jrnn.shuffler.domain;

/**
 * Card represents a standard playing card, consisting of a rank and a suite.
 * Altogether there are 52 possible combinations.
 */
public class Card {

    // TODO should implement Comparable...?

    private final Rank rank;
    private final Suite suite;

    private Card(Rank rank, Suite suite) {
        if (rank == null) {
            throw new IllegalArgumentException("Rank cannot be null");
        }
        if (suite == null) {
            throw new IllegalArgumentException("Suite cannot be null");
        }
        this.suite = suite;
        this.rank = rank;
    }

    public static Card of(Rank rank, Suite suite) {
        return new Card(rank, suite);
    }

    Rank getRank() {
        return rank;
    }

    Suite getSuite() {
        return suite;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        var card = (Card) other;
        return rank == card.getRank() && suite == card.getSuite();
    }

    @Override
    public int hashCode() {
        return 31 * rank.hashCode() + suite.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s%s", rank, suite);
    }
}

package com.github.jrnn.shuffler.domain;

/**
 * Suite represents the color of a playing card, e.g. hearts, clubs, ...
 */
enum Suite {

    HEARTS("H"),
    CLUBS("C"),
    DIAMONDS("D"),
    SPADES("S");

    private final String value;

    Suite(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

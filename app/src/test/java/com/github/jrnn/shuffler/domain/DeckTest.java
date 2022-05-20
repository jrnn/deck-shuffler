package com.github.jrnn.shuffler.domain;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class DeckTest {

    private static final String EXPECTED_DEFAULT_ORDER = ""
            + "AH, 2H, 3H, 4H, 5H, 6H, 7H, 8H, 9H, 10H, JH, QH, KH, "
            + "AC, 2C, 3C, 4C, 5C, 6C, 7C, 8C, 9C, 10C, JC, QC, KC, "
            + "KD, QD, JD, 10D, 9D, 8D, 7D, 6D, 5D, 4D, 3D, 2D, AD, "
            + "KS, QS, JS, 10S, 9S, 8S, 7S, 6S, 5S, 4S, 3S, 2S, AS";

    @DisplayName("When a new Deck instance is created")
    @Nested
    class WhenCreateNew {

        private final Deck deck = new Deck();

        @DisplayName("Then the Deck should contain exactly 52 cards")
        @Test
        void thenShouldHave52Cards() {
            assertThat(deck.getCards(), hasSize(52));
        }

        @DisplayName("Then the cards should be in a certain order ('new deck order')")
        @Test
        void thenShouldBeInCertainOrder() {
            // TODO yes I know, this is super flaky ... I'll fix it if I have time at the end ;)
            assertThat(deck.toString(), equalTo(EXPECTED_DEFAULT_ORDER));
        }
    }
}

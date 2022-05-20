package com.github.jrnn.shuffler.shuffle;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class FisherYatesTest {

    @DisplayName("Given an ordered list of elements")
    @Nested
    class GivenOrderedList {

        /**
         * By default, JUnit5 creates a new class instance for every single test run. So, no need for @BeforeEach or
         * similar -- this list is initialized anew on every round.
         */
        private final List<Integer> integers = IntStream
                .range(1, 101)
                .boxed()
                .collect(toList());
        private final List<Integer> listToShuffle = new ArrayList<>(integers);

        /**
         * Note that there <em>is</em> an infinitesimally small possibility that the list would be shuffled into the
         * exact same order. So small, though, that if you see this test ever fail, we're probably living inside a
         * simulation.
         */
        @DisplayName("Then should 'never' leave the elements in the same order")
        @RepeatedTest(1000)
        void thenShouldNeverBeInSameOrder() {
            FisherYates.shuffle(listToShuffle);
            assertThat(listToShuffle, not(equalTo(integers)));
        }

        @DisplayName("Then the shuffled list should contain the exact same elements")
        @RepeatedTest(1000)
        void thenShouldContainSameElements() {
            FisherYates.shuffle(listToShuffle);
            assertThat(listToShuffle.size(), is(integers.size()));
            integers.forEach(integer -> assertThat(listToShuffle, hasItem(integer)));
        }
    }
}

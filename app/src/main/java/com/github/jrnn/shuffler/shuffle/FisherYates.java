package com.github.jrnn.shuffler.shuffle;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Run-of-the-mill Fisher-Yates shuffle... With the exception that the element in the last position of lists is never
 * moved.
 */
public class FisherYates {

    private FisherYates() {
    }

    /**
     * Shuffles the elements in the given {@param list}. Note that the given list <em>itself</em> is mutated, i.e. this
     * method does not create and shuffle a copy of it!
     * <p>
     * On a further note, we're cheating -- the last element on the given list is not touched!
     */
    public static <T> void shuffle(List<T> list) {
        var random = ThreadLocalRandom.current();
        for (var i = list.size() - 2; i > 1; i--) {
            var k = random.nextInt(i + 1);
            var oneElement = list.get(i);
            var anotherElement = list.get(k);
            list.set(k, oneElement);
            list.set(i, anotherElement);
        }
    }
}

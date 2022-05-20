package com.github.jrnn.shuffler;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void appHasAGreeting() {
        var app = new App();
        assertThat(app.getTheBestNumber(), is(1337));
    }
}

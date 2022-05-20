package com.github.jrnn.shuffler;

import com.github.jrnn.shuffler.domain.Deck;

public class App {

    public int getTheBestNumber() {
        return 1337;
    }

    public static void main(String[] args) {
        System.out.println(new App().getTheBestNumber());
        System.out.println(new Deck());
    }
}

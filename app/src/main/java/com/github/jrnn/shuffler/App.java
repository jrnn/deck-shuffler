package com.github.jrnn.shuffler;

import static com.github.jrnn.shuffler.shuffle.FisherYates.shuffle;

import com.github.jrnn.shuffler.domain.Deck;

public class App {

    public static void main(String[] args) {
        printBanner();
        var deck = new Deck();
        System.out.println("Here's a mint deck of cards. Don't you just love the smell of fresh ink?\n");
        System.out.println(deck);
        System.out.println("\nNow let me shuffle it for you:\n");
        shuffle(deck.getCards());
        System.out.println(deck);
        System.out.println();
    }

    private static void printBanner() {
        System.out.println("#################################");
        System.out.println("#                               #");
        System.out.println("#   D E C K   S H U F F L E R   #");
        System.out.println("#          ( v0.0.0 )           #");
        System.out.println("#                               #");
        System.out.println("#################################\n");
    }
}

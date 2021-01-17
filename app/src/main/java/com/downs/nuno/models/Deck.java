package com.downs.nuno.models;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards; //Holds the total amount of cards in play

    public Deck(Deck newDeck){

        //TODO test the deep copy constructor
        this.cards = newDeck.cards;
    }

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void shuffleCards(){}
    public void addCards(){}
    public void removeCards(){}


    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                '}';
    }
}

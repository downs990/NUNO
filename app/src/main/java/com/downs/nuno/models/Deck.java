package com.downs.nuno.models;

import java.util.ArrayList;

public class Deck {

    private ArrayList<Card> cards;// TODO: Use stack data structure instead?
    private String owner;

    public Deck(ArrayList<Card> cards, String owner) {
        this.cards = cards;
        this.owner = owner;
    }

    public void shuffleCards(){}
    public void addCards(){}
    public void removeCards(){}


    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards +
                ", owner='" + owner + '\'' +
                '}';
    }
}

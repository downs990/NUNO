package com.downs.nuno.models;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards; //Holds the total amount of cards in play
//    int maxDeckIndex;
//    int minDeckIndex;
    public Deck(){
        cards = new ArrayList<>();
    }

    public Deck(Deck newDeck){

        //TODO test the deep copy constructor
        this.cards = newDeck.cards;
    }

    public Deck(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void shuffleCards(){

        Collections.shuffle(cards);

    }
    public void addCard(Card card){

        cards.add(card);
    }
    public void removeCard(Card card){

        cards.remove(card);

    }

    public Card popCard(){

        return cards.remove(0);
    }

    public int getSize(){

        return cards.size();

    }

    public ArrayList<Card> getDeck(){

        return cards;
    }


    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards.toString() +
                '}';
    }
}

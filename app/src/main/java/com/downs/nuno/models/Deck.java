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

        //TODO create a swap function, generate a random index within the range of the deck
        //TODO deck[0],deck[randomIndex1]; (Swap function)
        //TODO deck[1],deck[randomIndex2]; (Swap function)
        //TODO deck[2],deck[randomIndex3]; (Swap function)
        //TODO deck[3],deck[randomIndex4]; (Swap function)
        //TODO deck[4],deck[randomIndex5]; (Swap function)
        //..........
        Collections.shuffle(cards);
    }
    public void addCard(Card card){

        cards.add(card);
    }
    public void removeCards(Card card){

        cards.remove(card);

    }

    public int getSize(){

        return cards.size();

    }


    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards.toString() +
                '}';
    }
}

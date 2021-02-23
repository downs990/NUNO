package com.downs.nuno.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Deck {

    private Stack<Card> cards; //Holds the total amount of cards in play
//    int maxDeckIndex;
//    int minDeckIndex;
    public Deck(){
        cards = new Stack<>();
    }

    public Deck(Deck newDeck){

        //TODO test the deep copy constructor
        this.cards = newDeck.cards;
    }

    public Deck(Stack<Card> cards) {
        this.cards = cards;
    }

    public void shuffleCards(){

        Collections.shuffle(cards);

    }
    public void addCard(Card card){

        cards.push(card);
    }

    public Card popCard(){

        return cards.pop();
    }

    public int getSize(){

        return cards.size();

    }

    public Card peekCard(){

        return cards.peek();
    }

    public Stack<Card> getDeck(){

        return cards;
    }


    @Override
    public String toString() {
        return "Deck{" +
                "cards=" + cards.toString() +
                '}';
    }
}

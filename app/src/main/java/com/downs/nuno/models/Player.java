package com.downs.nuno.models;

import java.util.ArrayList;

public class Player {

    private String playerName;
    protected ArrayList<Card> playerHand;

    public Player() {
        playerHand = new ArrayList<>();
    }

    public Player(ArrayList<Card> cards) {

        playerHand = cards;

    }

    public Boolean cardToPile(Deck discardDeck,Card card){
        if(card.getSymbol() == discardDeck.peekCard().getSymbol() ||
                card.getColor() == discardDeck.peekCard().getColor()){

            discardDeck.addCard(card);
            this.removeCardFromHand(card);
            return true;
        }

        return false;
    }

    public String getPlayerName() {

        return playerName;

    }

    public void setPlayerName(String playerName) {

        this.playerName = playerName;

    }

    public ArrayList<Card> getPlayerCards() {

        return playerHand;
    }

    public void setPlayCards() {

        this.playerHand = playerHand;
    }

    public void addPlayerCard(Card card){

        playerHand.add(card);
    }

    public void removeCardFromHand(Card card){

         playerHand.remove(card);
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerName='" + playerName + '\'' +
                ", playerHand=" + playerHand.toString() +
                '}';
    }
}

package com.downs.nuno.models;

public class Player {

    private String playerName;
    private Deck playerHand;

    public Player() {

    }

    public Player(Deck cards) {

        playerHand = new Deck(cards);

    }

    public String getPlayerName() {

        return playerName;

    }

    public void setPlayerName(String playerName) {

        this.playerName = playerName;

    }

    public Deck getPlayerCards() {

        return playerHand;
    }

    public void setPlayCards() {

        this.playerHand = playerHand;
    }

    public void addPlayerCard(Card card){

        playerHand.addCard(card);
    }

}

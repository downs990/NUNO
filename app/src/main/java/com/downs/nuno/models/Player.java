package com.downs.nuno.models;

public class Player {

    private String playerName = "Player1";
    private Deck playerHand;

    public Player(){

    }

    public Player(Deck cards) {

        playerHand = new Deck(cards);

    }

    public void getPlayerCard() {

    }

    public void setPlayCard() {

    }


}

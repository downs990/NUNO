package com.downs.nuno.models;

public class Computer extends Player{


    public Computer(){

    }

    public void cardToPile(Deck discardDeck, Deck drawDeck){

        Boolean cardIsEqual = false;
        for(int i = 0; i < playerHand.size(); i++){

            cardIsEqual = validateCard(drawDeck,discardDeck,playerHand.get(i));
            if(cardIsEqual) break;
        }

        if(cardIsEqual == false){

            drawCard(drawDeck);
        }

    }

    public void drawCard(Deck drawDeck){

        playerHand.add(drawDeck.popCard());

    }

    //TODO add functionality to place drawn card to pile deck if it is
    //    //equal based on symbol or color
    public Boolean validateCard(Deck drawDeck, Deck discardDeck, Card card){

        Boolean isValid  = false;

        if((card.getSymbol() == discardDeck.peekCard().getSymbol()) ||
                (card.getColor() == discardDeck.peekCard().getColor())){

            discardDeck.addCard(card);
            this.removeCardFromHand(card);
;           isValid = true;
        }

        return isValid;
    }
}

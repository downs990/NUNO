package com.downs.nuno.models;

public class Card {

    private int color;
    private String symbol;

    public Card(){

    }

    public Card(int color, String symbol){
        this.color = color;
        this.symbol = symbol;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "Card{" +
                "color=" + color +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

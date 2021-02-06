package com.downs.nuno.models;

public class Card {

    private int colorCode;
    private String colorName;
    private String symbol;

    public Card(){

    }

    public Card(int colorCode, String symbol,String colorName){
        this.colorCode = colorCode;
        this.colorName = colorName;
        this.symbol = symbol;
    }

    public int getColor() {
        return colorCode;
    }

    public void setColor(int color) {
        this.colorCode = colorCode;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }


    @Override
    public String toString() {
        return "\nCard{" +
                "color=" + colorName +
                ", symbol='" + symbol + '\'' +
                '}';
    }
}

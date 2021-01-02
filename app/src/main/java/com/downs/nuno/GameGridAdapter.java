package com.downs.nuno;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.downs.nuno.models.Card;

import java.util.ArrayList;

public class GameGridAdapter extends ArrayAdapter<Card> {


    public ArrayList<Card> cards;


    public GameGridAdapter(Context context, ArrayList<Card> cards) {
        super(context, 0, cards);

        this.cards = cards;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.deck_item_view, parent, false);
        }
        // Lookup view for data population
        TextView topSymbol = convertView.findViewById(R.id.top_symbol);
        TextView centerSymbol = convertView.findViewById(R.id.center_symbol);
        TextView bottomSymbol = convertView.findViewById(R.id.bottom_symbol);


        // Populate the data into the template view using the data object
        String symbol = cards.get(position).getSymbol();
        Integer color = cards.get(position).getColor();

        topSymbol.setText(symbol);
        topSymbol.setBackgroundColor(getContext().getResources().getColor(color));
        centerSymbol.setText(symbol);
        centerSymbol.setBackgroundColor(getContext().getResources().getColor(color));
        bottomSymbol.setText(symbol);
        bottomSymbol.setBackgroundColor(getContext().getResources().getColor(color));
        // Return the completed view to render on screen
        return convertView;
    }
}
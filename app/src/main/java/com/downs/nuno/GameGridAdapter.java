package com.downs.nuno;


import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.downs.nuno.models.Card;
import com.downs.nuno.models.Deck;
import com.downs.nuno.models.Player;

import java.util.ArrayList;
import java.util.Stack;


public class GameGridAdapter extends RecyclerView.Adapter<GameGridAdapter.MyViewHolder> {

    private ArrayList<Card> cards;
    private Context context;
    private Player playerObject;
    private Deck discardDeck;

    public GameGridAdapter(Context context, ArrayList<Card> cards, Player playerObject, Deck discardDeck) {
        this.cards = cards;
        this.context = context;
        this.playerObject = playerObject;
        this.discardDeck = discardDeck;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView topSymbol;
        Button centerSymbol;
        TextView bottomSymbol;
        RelativeLayout cardView;


        public MyViewHolder(View itemView,final Context context) {
            super(itemView);


            topSymbol = itemView.findViewById(R.id.top_symbol);
            centerSymbol = itemView.findViewById(R.id.center_symbol);
            bottomSymbol = itemView.findViewById(R.id.bottom_symbol);
            cardView = itemView.findViewById(R.id.card_view);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {

                    TextView clickedButton = v.findViewById(R.id.bottom_symbol);
                    String cardSymbol = clickedButton.getText().toString();
                    ColorDrawable cd = (ColorDrawable) clickedButton.getBackground();
                    int color = cd.getColor();

                    Toast.makeText(context,"Symbol: " + cardSymbol + " Color: " + color,Toast.LENGTH_LONG).show();

                }
            });
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deck_item_view, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view,context);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {


        // Lookup view for data population
        TextView topSymbol = holder.topSymbol;
        TextView centerSymbol = holder.centerSymbol;
        TextView bottomSymbol = holder.bottomSymbol;


        // Populate the data into the template view using the data object
        String symbol = cards.get(position).getSymbol();
        Integer color = cards.get(position).getColor();

        topSymbol.setText(symbol);
        topSymbol.setBackgroundColor(context.getResources().getColor(color));
        centerSymbol.setText(symbol);
        centerSymbol.setBackgroundColor(context.getResources().getColor(color));
        bottomSymbol.setText(symbol);
        bottomSymbol.setBackgroundColor(context.getResources().getColor(color));
    }





    @Override
    public int getItemCount() {
        return cards.size();
    }}
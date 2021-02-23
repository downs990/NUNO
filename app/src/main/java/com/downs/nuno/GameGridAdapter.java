package com.downs.nuno;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.downs.nuno.models.Card;
import java.util.ArrayList;
import java.util.Stack;


public class GameGridAdapter extends RecyclerView.Adapter<GameGridAdapter.MyViewHolder> {

    private Stack<Card> cards;
    private Context context;

    public GameGridAdapter(Context context, Stack<Card> cards) {
        this.cards = cards;
        this.context = context;
    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {


        TextView topSymbol;
        TextView centerSymbol;
        TextView bottomSymbol;


        public MyViewHolder(View itemView) {
            super(itemView);


            topSymbol = itemView.findViewById(R.id.top_symbol);
            centerSymbol = itemView.findViewById(R.id.center_symbol);
            bottomSymbol = itemView.findViewById(R.id.bottom_symbol);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {


                }
            });
        }
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.deck_item_view, parent, false);


        MyViewHolder myViewHolder = new MyViewHolder(view);
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
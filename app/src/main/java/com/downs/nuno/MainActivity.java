package com.downs.nuno;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.downs.nuno.models.Card;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private int NUMBER_OF_CARDS_IN_HAND = 7;


    private Integer[] cardColors = {
            R.color.nuno_red, R.color.nuno_green, R.color.nuno_blue, R.color.nuno_yellow
    };

//    private String[] cardSymbols = {
//            "1", "2", "3", "4", "5", "6", "7", "8", "9"
//    };
    private String[] cardSymbols = {
            "#", "$", "%", "^", "&", "*", "+", "!", "?"
    };


    RecyclerView computerRecyclerView;
    RecyclerView playerRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        computerRecyclerView = findViewById(R.id.computer_game_grid);
        playerRecyclerView = findViewById(R.id.game_grid);


        generateComputersDeck(NUMBER_OF_CARDS_IN_HAND);
        generateRandomDeck(NUMBER_OF_CARDS_IN_HAND);






        findViewById(R.id.random_hand_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

                generateRandomDeck(NUMBER_OF_CARDS_IN_HAND);



            }
        });


    }



    private void generateComputersDeck(int sizeOfDeck){

        ArrayList<Card> cards = new ArrayList<>();
        for(int i = 0; i < sizeOfDeck; i++){
            Card newCard = new Card(R.color.unknown_card_color, "??");
            cards.add(newCard);
        }



        GameGridAdapter adapter = new GameGridAdapter(this, cards);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        computerRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        computerRecyclerView.setAdapter(adapter);

    }



    private void generateRandomDeck(int sizeOfDeck){

        ArrayList<Card> cards = new ArrayList<>();

        int minColorIndex = 0, maxColorIndex = cardColors.length - 1;
        int minSymbolsIndex = 0, maxSymbolIndex = cardSymbols.length  - 1;

        for(int i = 0; i < sizeOfDeck; i++){
            int colorRange = (maxColorIndex - minColorIndex) + 1;
            int currentColorIndex = (int) (Math.random() * colorRange) + minColorIndex;  // Inclusive on both ends

            int symbolRange = (maxSymbolIndex - minSymbolsIndex) + 1;
            int currentSymbolIndex = (int) (Math.random() * symbolRange) + minSymbolsIndex;  // Inclusive on both ends

            Card newCard = new Card(cardColors[currentColorIndex], cardSymbols[currentSymbolIndex]);
            cards.add(newCard);
        }



        GameGridAdapter adapter = new GameGridAdapter(this, cards);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        playerRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        playerRecyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
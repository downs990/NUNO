package com.downs.nuno;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.downs.nuno.models.Card;
import com.downs.nuno.models.Computer;
import com.downs.nuno.models.Deck;
import com.downs.nuno.models.Player;

import java.util.ArrayList;
import java.util.Stack;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private int NUMBER_OF_CARDS_IN_HAND = 7;


    private Integer[] cardColors = {
            R.color.nuno_red, R.color.nuno_green, R.color.nuno_blue, R.color.nuno_yellow
    };

    private String[] cardColorNames = {
            "Red", "Green", "Blue", "Yellow"
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

        // Test code above.
        // ------------------------------------------------------


        //initialize new game
        //Create 3 computer players
        Computer playerOne = new Computer();
        Computer playerTwo = new Computer();
        Computer playerThree = new Computer();
        Player humanPlayer = new Player();

        // Initialize all game cards
        Deck completeGameDeck = initializeCards();
        completeGameDeck.shuffleCards();
        Log.d("LoadDeck - before: " + completeGameDeck.getSize(), completeGameDeck.toString());

        //Generate Cards for each player
        handOutPlayerCards(completeGameDeck, playerOne, playerTwo, playerThree, humanPlayer);



        Log.d("LoadDeck - After: " + completeGameDeck.getSize(), completeGameDeck.toString());
        //Remove a first card from draw deck, add to pile to initiate game
        //Players can add cards to the pileDeck, or draw from the drawDeck
        Log.d("LoadDeck-Player1: " + completeGameDeck.getSize(), playerOne.toString());
        Log.d("LoadDeck-Player2: " + completeGameDeck.getSize(), playerTwo.toString());
        Log.d("LoadDeck-Player3: " + completeGameDeck.getSize(), playerThree.toString());
        Log.d("LoadDeck-Human: " + completeGameDeck.getSize(), humanPlayer.toString());

//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment);

        //update the recyclerview on the phone interface
        updateScreenView(humanPlayer.getPlayerCards().getDeck());


    }


    private Deck initializeCards() {
        //Create a deck of cards based on the symbols
        Deck allCards = new Deck();

        //generate cards cardSymbols[0] - cardSymbols[9] for each color to create appropriate deck
        for (int i = 0; i < cardSymbols.length; i++) {

            for (int j = 0; j < cardColors.length; j++) {
                Card newCard = new Card(cardColors[j], cardSymbols[i], cardColorNames[j]);
                allCards.addCard(newCard);
            }

        }

        //generate cards cardSymbols[1] - cardSymbols[9] for each color
        for (int i = 1; i < cardSymbols.length; i++) {
            for (int j = 0; j < cardColors.length; j++) {
                Card newCard = new Card(cardColors[j], cardSymbols[i], cardColorNames[j]);
                allCards.addCard(newCard);
            }
        }

        return allCards;
    }

    private void handOutPlayerCards(Deck completeGameDeck, Computer playerOne, Computer playerTwo,
                                    Computer playerThree, Player humanPlayer) {

        Player[] players = {humanPlayer, playerOne, playerTwo, playerThree};
        int playerHandoutAmount = 7;

        //Handout cards to each player
        for (Player player : players) {
            for (int i = 0; i < playerHandoutAmount; i++) {
                player.addPlayerCard(completeGameDeck.popCard());
            }
        }
    }


    private void generateComputersDeck(int sizeOfDeck) {

        Stack<Card> cards = new Stack<>();
        for (int i = 0; i < sizeOfDeck; i++) {
            Card newCard = new Card(R.color.unknown_card_color, "??", "Unknown");
            cards.add(newCard);
        }

        GameGridAdapter adapter = new GameGridAdapter(this, cards);

        LinearLayoutManager horizontalLayoutManagaer
                = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
        computerRecyclerView.setLayoutManager(horizontalLayoutManagaer);
        computerRecyclerView.setAdapter(adapter);

    }


    private void updateScreenView(Stack<Card> cardDeck) {

        GameGridAdapter adapter = new GameGridAdapter(this, cardDeck);

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
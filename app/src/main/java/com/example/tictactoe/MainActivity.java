package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.GameState;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    // 0 -> X
    // 1 -> O
    // We will start with X
    int activePlayer = 0;
    boolean gameActive = true;
    int gameState [] = {2,2,2,2,2,2,2,2,2};
    // 0 -> X
    // 1 -> O
    // 2 -> null
    int [][] winConditions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView2);
    }
    public void playerTap(View view){
        ImageView imageView =(ImageView) view;
        int tapImageState = Integer.parseInt(imageView.getTag().toString());
        if(!gameActive){
            reset();
        }
        if(gameState[tapImageState]==2){
            gameState[tapImageState]=activePlayer;
            if(activePlayer==0){
                imageView.setImageResource(R.drawable.cross);
                activePlayer=1;
                textView.setText("O's Turn - Tap To PLay");
            } else {
                imageView.setImageResource(R.drawable.o);
                activePlayer=0;
                textView.setText("X's Turn - Tap To PLay");
            }
        }
        // Checking for if somebody has won or not.
        for(int [] winCondition : winConditions){
            if(gameState[winCondition[0]] == gameState[winCondition[1]] && gameState[winCondition[1]] == gameState[winCondition[2]] && gameState[winCondition[0]]!=2){
                // If condition is true means some body has won the game.
                gameActive = false;

                if(activePlayer==0){
                    textView.setText("O has Won The Game");
                } else {
                    textView.setText("X has Won The Game");
                }
            }
        }
        // Chexking that is Grid full or not
        boolean flag = true;
        for(int i=0; i<9; ++i){
            if(gameState[i]==2){
                flag = false;
            }
        }
        if(flag){
            reset();
        }
    }
    public void reset(){
        gameActive=true;
        activePlayer=0;
        for(int i=0; i<9; ++i){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.zero)).setImageResource(0);
        ((ImageView)findViewById(R.id.one)).setImageResource(0);
        ((ImageView)findViewById(R.id.two)).setImageResource(0);
        ((ImageView)findViewById(R.id.three)).setImageResource(0);
        ((ImageView)findViewById(R.id.four)).setImageResource(0);
        ((ImageView)findViewById(R.id.five)).setImageResource(0);
        ((ImageView)findViewById(R.id.six)).setImageResource(0);
        ((ImageView)findViewById(R.id.seven)).setImageResource(0);
        ((ImageView)findViewById(R.id.eight)).setImageResource(0);
        textView.setText("X's Turn - Tap To PLay");
    }
}
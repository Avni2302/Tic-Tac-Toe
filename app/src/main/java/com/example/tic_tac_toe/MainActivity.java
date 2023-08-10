package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    int gameSet []= {2,2,2,2,2,2,2,2,2};
    int gameWin [][]= {{0,1,2},{3,4,5},{6,7,8},{0,4,8},{2,4,6},{0,3,6},{1,4,7},{2,5,8}};
    public void dropIn(View view){
        ImageView counter = (ImageView)  view;

        int trappedCounter = Integer.parseInt(counter.getTag().toString());
        counter.setTranslationY(-1000f);
        if(gameSet[trappedCounter] == 2) {
            gameSet[trappedCounter] = activePlayer;
            counter.setTranslationY(-1000f);
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.green);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }
        }
        counter.animate().translationYBy(1000f).setDuration(300);
        for(int []winningPosition : gameWin){
            if(gameSet[winningPosition[0]]== gameSet[winningPosition[1]] && gameSet[winningPosition[1]]== gameSet[winningPosition[2]] && gameSet[winningPosition[0]] != 2){
                String winner ="red" ;
                if(gameSet[winningPosition[0]] == 0){
                    winner = "green";
                }

                TextView winnerMessage = (TextView)findViewById(R.id.winnerMessage);
                winnerMessage.setText(winner + " has won!");
                LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

                layout.setVisibility(View.VISIBLE);
            }
        }
    }

    public void playAgain(View view){

        LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);

        layout.setVisibility(View.INVISIBLE);
        activePlayer=0;
        for(int i=0;i<gameSet.length;i++){
            gameSet[i]=2;
        }

        androidx.gridlayout.widget.GridLayout Glayout = findViewById(R.id.glayout);

        for(int i=0;i< Glayout.getChildCount();i++){
            ((ImageView) Glayout.getChildAt(i)).setImageResource(0);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
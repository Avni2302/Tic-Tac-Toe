package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
                System.out.println(gameSet[winningPosition[0]]);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
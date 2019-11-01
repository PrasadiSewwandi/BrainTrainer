package com.example.braintrainer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class Displaying extends AppCompatActivity {
    DatabaseHelper myDb = new DatabaseHelper(this);
    ScoreEntry scoreEntry = new ScoreEntry(1,1);
    private TextView randomBox;
    private RandomNumberStore randomNumberStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randomNumberStore = RandomNumberStore.getNewInstance();
        setContentView(R.layout.activity_displaying);
        randomBox = (TextView) findViewById(R.id.randomNumber);
        TextView textView = (TextView) findViewById(R.id.textView8);
        Integer currentLevel = myDb.getCurrentLevel();
        String level = Integer.toString(currentLevel);
        textView.setText("  You are in level "+level);
        startGame(currentLevel);
    }

    private void startGame(int level){
         int number =0;
         int miliSec = 1000 ;

        if (level == 1){
             number = 3;
            miliSec = 1000;
        }
        if (level == 2){
            number = 6;
            miliSec = 2000;
        }
        if (level == 3){
            number = 9;
            miliSec = 3000;
        }
        if (level == 4){
            number = 12;
            miliSec = 3000;
        }
        if (level == 5){
            number = 15;
            miliSec = 3000;
        }

        final int numberCount= number;
        final int miliSeconds = miliSec;
        Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < numberCount; i++) {
                    displayNewNumber();
                    try {
                        Thread.sleep(miliSeconds);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                gettingInputs ();
            }
        });
        timerThread.start();

    }

    private void gettingInputs(){
        Intent playGameIntent =new Intent(Displaying.this , FirstSubmission.class);
        startActivity(playGameIntent);
        finish();

    }
    private void displayNewNumber(){
        Random randomNumberGenerator = new Random();
        Integer number = randomNumberGenerator.nextInt(100 );
        randomNumberStore.addGenaratedRandomNumber(number);
        randomBox.setText(""+number);
        Random rnd = new Random();
        int color = Color.argb(100, rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
        randomBox.setBackgroundColor(color);
    }

}

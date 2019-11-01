package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DisplayScore extends AppCompatActivity {
    private TextView randomBox;
    DatabaseHelper myDb = new DatabaseHelper(this);
    RandomNumberStore randomNumberStore;
    Integer currentLevel;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_score);
        randomNumberStore = RandomNumberStore.getInstance();
        currentLevel = myDb.getCurrentLevel();
        int maximumMarkLevel = getMaxScore(currentLevel);
        score =randomNumberStore.getCountOfCorectGuesses();
        randomBox = (TextView) findViewById(R.id.scoreShowing);
        randomBox.setText(" Your level 0" + currentLevel+ " score is\n"+ score + " out of "+ maximumMarkLevel);

        ScoreEntry scoreEntry = null;
        ArrayList<ScoreEntry> scoreEntries = myDb.getScoreEntries();
        for (int i = 0; i < scoreEntries.size(); i++) {
            if(scoreEntries.get(i).getLevel() == currentLevel){
                scoreEntry = scoreEntries.get(i);
                break;
            }
        }

        if(scoreEntry == null){
            scoreEntry = new ScoreEntry(1,0);
        }

        if(scoreEntry.getScore()<score){
            scoreEntry.setScore(score);
            myDb.insertScoreEntry(scoreEntry);
        }
        startThread();

    }
    private void startThread(){
        Thread timerThread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                gettingInputs (currentLevel);
            }
        });
        timerThread.start();
    }
    private int getMaxScore(Integer level){
        int maxScore = 0;
        if(currentLevel == 1){
            maxScore= 3;
        }
        if(currentLevel == 2){
            maxScore= 6;
        }
        if(currentLevel == 3){
            maxScore= 9;
        }
        if(currentLevel == 4){
            maxScore= 12;
        }
        if(currentLevel == 5){
            maxScore= 15;
        }
        return maxScore;
    }

    private void gettingInputs(int currentLevel){
        int maximumMarkLevel = getMaxScore(currentLevel);
        if (currentLevel !=5 && score>= maximumMarkLevel) {

            ScoreEntry scoreEntry = new ScoreEntry(currentLevel+1,0);
            myDb.insertScoreEntry(scoreEntry);

            Intent playGameIntent = new Intent(DisplayScore.this, WinningScreen.class);
            startActivity(playGameIntent);
        }

        else if ( currentLevel ==5 && score>= maximumMarkLevel) {
            Intent playGameIntent = new Intent(DisplayScore.this, ResultActivity.class);
            startActivity(playGameIntent);
        }
        else  {
            Intent playGameIntent = new Intent(DisplayScore.this, ResultActivity.class);
            startActivity(playGameIntent);
        }
        finish();
    }
}

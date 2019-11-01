package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MarksCarring extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks_carring);
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
                Intent playGameIntent = new Intent(MarksCarring.this, DisplayScore.class);
                startActivity(playGameIntent);
                finish();
            }
        });
        timerThread.start();
    }

}

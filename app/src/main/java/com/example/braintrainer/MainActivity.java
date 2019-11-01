package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    Timer timeoutTimer;
    DatabaseHelper myDb ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myDb = new DatabaseHelper(this);
        setContentView(R.layout.activity_main);
        Button playGame = (Button) findViewById(R.id.playGameButton);
        Button viewInstructionButton = (Button) findViewById(R.id.gameInstructionButton);
        Button exit = (Button) findViewById(R.id.exitButtton1);

        playGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent playGameIntent =new Intent(MainActivity.this , Displaying.class);
                startActivity(playGameIntent);
                finish();
            }
        });

        viewInstructionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent veiwInstructionIntent = new Intent(MainActivity.this ,InstructionActivity.class);
                startActivity(veiwInstructionIntent);
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}

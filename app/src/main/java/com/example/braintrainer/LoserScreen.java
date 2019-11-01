package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoserScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loser_screen);
        Button exit = (Button) findViewById(R.id.loserExitButton);
        Button playAgainThisLevel = (Button) findViewById(R.id.loserTryAgain);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        playAgainThisLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent veiwInstructionIntent = new Intent(LoserScreen.this ,Displaying.class);
                startActivity(veiwInstructionIntent);
                finish();
            }
        });

    }
}

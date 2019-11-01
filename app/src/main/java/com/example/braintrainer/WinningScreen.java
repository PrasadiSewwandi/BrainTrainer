package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinningScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_screen);
        Button playGameNextLevel = (Button) findViewById(R.id.goForTheNextLevelButton);
        Button exit = (Button) findViewById(R.id.exitButtonWiningScreen);
        playGameNextLevel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent veiwInstructionIntent = new Intent(WinningScreen.this ,Displaying.class);
                startActivity(veiwInstructionIntent);
                finish();
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

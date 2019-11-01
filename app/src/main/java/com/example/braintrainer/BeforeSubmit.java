package com.example.braintrainer;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class BeforeSubmit extends AppCompatActivity {
    private RandomNumberStore randomNumberStore;
    Button nextButton;
    EditText userInput;
    int input;
    String playerInput;
    DatabaseHelper myDb = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        randomNumberStore = RandomNumberStore.getInstance();
        setContentView(R.layout.activity_before_submit_screen);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = (EditText) findViewById(R.id.inputBox);
                playerInput = userInput.getText().toString();
                userInput.setText( "");
                Random rnd = new Random();
                int color = Color.argb(100, rnd.nextInt(255), rnd.nextInt(255), rnd.nextInt(255));
                userInput.setBackgroundColor(color);
                try {
                    input = Integer.parseInt(playerInput);
                } catch (Exception e) {
                    input = -1;
                    
                }
                randomNumberStore.addInputNumber(input);
                if(randomNumberStore.getGivenInputs().size()>= getNumberCountForCurentLevel()-1){
                  startScoreActivity();
                  finish();
                }
            }
        });
    }

    private void startScoreActivity() {
        Intent playGameIntent = new Intent(BeforeSubmit.this, Submit.class);
        startActivity(playGameIntent);
    }
     private int getNumberCountForCurentLevel (){
         Integer currentLevel = myDb.getCurrentLevel();
         if(currentLevel==1){
             return  3;
         }
        else if(currentLevel==2){
             return  6;
         }
        else if(currentLevel==3){
             return  9;
         }
        else if(currentLevel==4){
             return  12;
         }
        else return 15 ;
     }
}

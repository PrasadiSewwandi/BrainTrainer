package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FirstSubmission extends AppCompatActivity {

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
        setContentView(R.layout.activity_first_submission);
        nextButton = (Button) findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userInput = (EditText) findViewById(R.id.inputBox);
                playerInput = userInput.getText().toString();
                userInput.setText( "");
                try {
                    input = Integer.parseInt(playerInput);
                } catch (Exception e) {
                    input = -1;

                }
                randomNumberStore.addInputNumber(input);
                startScoreActivity();
            }
        });
    }

    private void startScoreActivity() {
        Intent playGameIntent = new Intent(FirstSubmission.this, BeforeSubmit.class);
        startActivity(playGameIntent);
        finish();
    }

}

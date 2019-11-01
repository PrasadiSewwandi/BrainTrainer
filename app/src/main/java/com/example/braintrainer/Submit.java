
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

public class Submit extends AppCompatActivity {
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
        setContentView(R.layout.activity_submit);
        nextButton = (Button) findViewById(R.id.submitButton);
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
        Intent playGameIntent = new Intent(Submit.this, MarksCarring.class);
        startActivity(playGameIntent);
        finish();
    }

}

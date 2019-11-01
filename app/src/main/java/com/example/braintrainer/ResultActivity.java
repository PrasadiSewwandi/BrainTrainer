package com.example.braintrainer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResultActivity extends AppCompatActivity {
    DatabaseHelper myDb = new DatabaseHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button playFromBegin = (Button) findViewById(R.id.button1ResultScreen2);
        Button exit = (Button) findViewById(R.id.button1ResultScreen3);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        playFromBegin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDb.dropDataBase();
                Intent veiwInstructionIntent = new Intent(ResultActivity.this ,Displaying.class);
                startActivity(veiwInstructionIntent);
                finish();
            }
        });
    }
}

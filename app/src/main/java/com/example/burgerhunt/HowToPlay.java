package com.example.burgerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HowToPlay extends AppCompatActivity {

    Button next_how_to_play;
    Button skip_how_to_play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_play);
        setUpUIViews();

        next_how_to_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScoringActivity();
            }
        });

        skip_how_to_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountdown();
            }
        });
    }

    public void setUpUIViews() {
        next_how_to_play = findViewById(R.id.next);
        skip_how_to_play = findViewById(R.id.skip);
    }

    public void startScoringActivity(){
        Intent intent = new Intent(HowToPlay.this, scoring.class);
        startActivity(intent);
    }

    public void startCountdown() {
        Intent intent = new Intent(HowToPlay.this, countdown.class);
        startActivity(intent);
    }

}

package com.example.burgerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class scoring extends AppCompatActivity {

    Button back;
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);
        setUpUIViews_score();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startHowToPlay();
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startCountDown();
            }
        });
    }

    public void setUpUIViews_score(){
        back = findViewById(R.id.back);
        play = findViewById(R.id.play);
    }

    public void startHowToPlay(){
        Intent intent = new Intent(scoring.this, HowToPlay.class);
        startActivity(intent);
    }

    public void startCountDown(){
        Intent intent = new Intent(this, countdown.class);
        startActivity(intent);
    }
}

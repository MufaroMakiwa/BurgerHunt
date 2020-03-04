package com.example.burgerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import java.util.Timer;
import java.util.TimerTask;

public class gameover extends AppCompatActivity {

    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover);
        final Bundle results = getIntent().getExtras();

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(gameover.this, statistics.class);
                intent.putExtra("score", results.getString("score"));
                intent.putExtra("burgers_found", results.getString("burgers_found"));
                intent.putExtra("missed_moves", results.getString("missed_moves"));
                intent.putExtra("total_moves", results.getString("total_moves"));
                startActivity(intent);
            }
        }, 3000);
    }


}

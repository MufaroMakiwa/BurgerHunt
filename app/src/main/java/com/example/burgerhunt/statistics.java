package com.example.burgerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class statistics extends AppCompatActivity {

    TextView final_score, final_missed, final_burgers, final_moves;
    Button next_page;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        setUpUIViews();

        Bundle results = getIntent().getExtras();
        final_score.setText(results.getString("score"));
        final_missed.setText(results.getString("missed_moves"));
        final_burgers.setText(results.getString("burgers_found"));
        final_moves.setText(results.getString("total_moves"));

        next_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(statistics.this, new_game.class);
                startActivity(intent);
            }
        });



    }

    public void setUpUIViews(){
        final_score = findViewById(R.id.score_stats);
        final_missed = findViewById(R.id.misses_stats);
        final_burgers = findViewById(R.id.burger_stats);
        final_moves = findViewById(R.id.moves_stats);
        next_page = findViewById(R.id.next_stats);
    }
}

package com.example.burgerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class game_play extends AppCompatActivity {
    TextView time_keeper, score, burgers_found, missed_moves, total_moves;
    Button button1, button2, button3;
    ImageView button1_image, button2_image, button3_image;
    String time_left_text;
    long time_remaining = 60000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_play);
        setUpUIViews();
        updateTimerText();

        new CountDownTimer(time_remaining, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                time_remaining = millisUntilFinished;
                updateTimerText();
            }

            @Override
            public void onFinish() {
                Intent data = new Intent(game_play.this, gameover.class);
                data.putExtra("score", score.getText());
                data.putExtra("burgers_found", burgers_found.getText());
                data.putExtra("missed_moves", missed_moves.getText());
                data.putExtra("total_moves", total_moves.getText());
                startActivity(data);

            }
        }.start();



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tileClick(0, button1_image);

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tileClick(1, button2_image);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tileClick(2, button3_image);
            }
        });
    }

    public void setUpUIViews(){
        time_keeper = findViewById(R.id.timer);
        score = findViewById(R.id.score_play);
        burgers_found = findViewById(R.id.burgers_play);
        missed_moves = findViewById(R.id.missed_in_play);
        total_moves = findViewById(R.id.moves_in_play);
        button1_image = findViewById(R.id.tile1_image);
        button2_image = findViewById(R.id.tile2_image);
        button3_image = findViewById(R.id.tile3_image);
        button1 = findViewById(R.id.tile1);
        button2 = findViewById(R.id.tile2);
        button3 = findViewById(R.id.tile3);

    }

    public void tileClick(int index, final ImageView button) {
//        tile 1 has index 0, tile 2 has index 1, tile 3 has index 2

        int value = array_sequence()[index];

        switch (value){
            case 1:
                int new_score = Integer.parseInt(String.valueOf(score.getText())) + 9;
                score.setText(Integer.toString(new_score));
                int burgers = Integer.parseInt(String.valueOf(burgers_found.getText())) + 1;
                burgers_found.setText(String.valueOf(burgers));

                new CountDownTimer(100, 1) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        button.setImageResource(R.drawable.burger);
                    }

                    @Override
                    public void onFinish() {
                        button.setImageResource(R.color.button_material_light);
                    }
                }.start();
                break;

            case 0:
                int next_score = Integer.parseInt(String.valueOf(score.getText())) - 3;
                score.setText(Integer.toString(next_score));
                int new_misses = Integer.parseInt(String.valueOf(missed_moves.getText())) + 1;
                missed_moves.setText(String.valueOf(new_misses));

                new CountDownTimer(100, 1) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        button.setImageResource(R.drawable.redx);
                    }

                    @Override
                    public void onFinish() {
                        button.setImageResource(R.color.button_material_light);
                    }
                }.start();
                break;
        }
        int new_moves = Integer.parseInt(String.valueOf(total_moves.getText())) + 1;
        total_moves.setText(Integer.toString(new_moves));
        array_sequence();
    }

    public int[] array_sequence() {

        int[] burger_position = {0, 0, 0};
        int one_index = (int) (Math.random() * 3);
        burger_position[one_index] = 1;
        return burger_position;
    }

    public void updateTimerText(){

        int minutes = (int) time_remaining / 60000;
        int seconds = (int) time_remaining % 60000 / 1000;

        if (minutes > 0) {
            time_left_text = "01:";
        } else {
            time_left_text = "00:";
        }
        if (seconds < 10) time_left_text += '0';
        time_left_text += seconds;
        time_keeper.setText(time_left_text);

    }
}

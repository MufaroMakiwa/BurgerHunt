package com.example.burgerhunt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class countdown extends AppCompatActivity {

    TextView count_down;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);
        count_down = findViewById(R.id.startcountdown);

        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

                int next = Integer.parseInt(String.valueOf(count_down.getText())) - 1;
                count_down.setText(String.valueOf(next));
            }
            public void onFinish(){
                Intent intent = new Intent(countdown.this, game_play.class);
                startActivity(intent);
//      timer on game play to be started in oncreate

            }
        }.start();
    }

}

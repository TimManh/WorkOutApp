package com.example.workoutstopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class MainWatch extends AppCompatActivity {
    Button startTimer,stopTimer;
    ImageView pointer;
    Animation runPointer;
    Chronometer digitalTimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_watch);
        startTimer = findViewById(R.id.startTimer);
        stopTimer = findViewById(R.id.stopTimer);
        pointer = findViewById(R.id.pointer);
        digitalTimer = findViewById(R.id.digitalTimer);
        stopTimer.setAlpha(0);
        runPointer = AnimationUtils.loadAnimation(MainWatch.this,R.anim.rotate);
        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointer.startAnimation(runPointer);
                digitalTimer.setBase(SystemClock.elapsedRealtime());
                digitalTimer.start();
                startTimer.animate().alpha(0).setDuration(300);
                stopTimer.animate().alpha(1).setDuration(600);
            }
        });
        stopTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointer.clearAnimation();
                digitalTimer.stop();
                digitalTimer.setBase(SystemClock.elapsedRealtime());
                startTimer.animate().alpha(1).setDuration(300);
                stopTimer.animate().alpha(0).setDuration(600);
            }
        });
    }
}

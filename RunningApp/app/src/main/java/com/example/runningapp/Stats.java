package com.example.runningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.widget.Chronometer;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Stats extends AppCompatActivity {

    private Chronometer chronometer;
    private TextView stepsTv;
    private TextView distanceTv;
    private TextView calTv;
    private TextView dateTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        chronometer = findViewById(R.id.chronometer);
        stepsTv = findViewById(R.id.stepsTv);
        distanceTv = findViewById(R.id.distanceTv);
        calTv = findViewById(R.id.calTv);
        dateTv = findViewById(R.id.dateTv);

        Date c = Calendar.getInstance().getTime();
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault());


        stepsTv.setText(String.valueOf(getIntent().getIntExtra("steps", 0)) + " steps");
        distanceTv.setText(String.format("%.2f M", getIntent().getDoubleExtra("distance", 0)));
        calTv.setText(String.valueOf(getIntent().getDoubleExtra("cal", 0)) + " Cal");
        chronometer.setBase(SystemClock.elapsedRealtime() - getIntent().getIntExtra("time", 0));
        dateTv.setText(df.format(c));

    }
}
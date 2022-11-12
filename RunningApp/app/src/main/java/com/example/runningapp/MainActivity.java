package com.example.runningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
     private Chronometer chronometer;
     private long timerOffset;
     private boolean timerRunning;
     private SensorManager sensorManager;
     private SensorEventListener stepCounter;
     private Sensor accel;
     private double prevMag;
     private double distance = 0;
     private double cal = 0;
     private Integer steps = 0;
     private TextView stepsTv;
     private TextView distanceTv;
    private TextView calTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        stepsTv = findViewById(R.id.stepsTv);
        distanceTv = findViewById(R.id.distanceTv);
        calTv = findViewById(R.id.calTv);
        chronometer = findViewById(R.id.chronometer);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

         stepCounter = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                if(sensorEvent != null && timerRunning){
                    float x = sensorEvent.values[0];
                    float y = sensorEvent.values[1];
                    float z = sensorEvent.values[2];

                    double mag = Math.sqrt((x*x)+(y*y)+(z*z));
                    double magDelta = mag - prevMag;
                    prevMag = mag;

                    if(magDelta > 6){
                        steps++;
                        distance = steps * 0.8;
                        cal = steps * 0.04;
                    }

                    stepsTv.setText(steps.toString());
                    distanceTv.setText(String.format("%.2f M", distance));
                    calTv.setText(String.format("%.2f Cal", cal));
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        };
    }

    public void startRun(View view) {
        if (!timerRunning) {
            chronometer.setBase(SystemClock.elapsedRealtime() - timerOffset);
            chronometer.start();
            timerRunning = true;

            //Register sensor
            sensorManager.registerListener(stepCounter, accel, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    public void pauseRun(View view) {
        if (timerRunning) {
            chronometer.stop();
            timerOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            timerRunning = false;
        }
    }

    public void resetRun(View view) {
        chronometer.setBase(SystemClock.elapsedRealtime());
        timerOffset = 0;
        steps = 0;
        distance = 0;
        cal = 0;

        stepsTv.setText("0");
        distanceTv.setText("0.00 M");
        calTv.setText("0.00 Cal");
    }

    public void goStats(View view) {
        sensorManager.unregisterListener(stepCounter);
    }
}
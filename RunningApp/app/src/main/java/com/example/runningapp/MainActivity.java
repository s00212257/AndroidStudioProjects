package com.example.runningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    CountUpTimer timer;
    TextView counter;
    Button btnTimerStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTimerStart = findViewById(R.id.btnTimerStart);

        //Hide title bar
        getSupportActionBar().hide();

        btnTimerStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doStart(view);
            }
        });
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void doStart(View view) {
        timer.start();
        Toast.makeText(this, "Started counting", Toast.LENGTH_LONG).show();
    }

    public void doStop(View view) {
        timer.cancel();
        Toast.makeText(this, "Stopped Run", Toast.LENGTH_LONG).show();
    }

    public void doReset(View view) {
        counter.setText("0");
        Toast.makeText(this, "Reset", Toast.LENGTH_LONG).show();
    }
}
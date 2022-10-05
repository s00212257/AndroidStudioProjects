package com.example.bmicalculator;

import static java.lang.Integer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView resultText;
    Button btnBack;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        Double BMI = intent.getDoubleExtra("BMI", 1337);

        resultText = findViewById(R.id.resultText);
        resultText.setText(BMI.toString());

        Button btnBack = findViewById(R.id.btnBack);
        ProgressBar progressBar = findViewById(R.id.progressBar);

        int i = BMI.intValue();
        progressBar.setProgress(i);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
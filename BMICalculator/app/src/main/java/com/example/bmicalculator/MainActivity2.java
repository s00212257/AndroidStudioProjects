package com.example.bmicalculator;

import static java.lang.Integer.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity2 extends AppCompatActivity {

    TextView resultText;
    TextView theFunny;
    Button btnBack;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Double BMI = getIntent().getDoubleExtra("BMI", 1337);



        resultText = findViewById(R.id.resultText);
        resultText.setText(BMI.toString());

        theFunny = findViewById(R.id.theFunny);

        btnBack = findViewById(R.id.btnBack);
        progressBar = findViewById(R.id.progressBar);

        int a = BMI.intValue();
        progressBar.setProgress(a);

        if(a > 25) {
            progressBar.setProgressTintList(ColorStateList.valueOf(Color.RED));
            theFunny.setText("Maybe a few less biscuits...");
        }
        else if(a > 18) {
            progressBar.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            theFunny.setText("You are NORMAL");
        }
        else{
            progressBar.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
            theFunny.setText("Maybe a few MORE biscuits!!");
        }


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
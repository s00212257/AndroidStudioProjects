package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button calcBMI = findViewById(R.id.btnCalc);
    Button clearInputs = findViewById(R.id.btnClear);
    EditText inputWeight = findViewById(R.id.etWeight);
    EditText inputHeight = findViewById(R.id.etHeight);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        clearInputs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearInputs();
            }
        });
    }

    public void clearInputs(){
        inputWeight.setText(0);
        inputHeight.setText(0);
    }

    public double calcBMI(){
        double weight = Double.parseDouble(String.valueOf(inputWeight.getText()));
        double height = Double.parseDouble(String.valueOf(inputHeight.getText()));

        return weight/(height*height);
    }

    public void displayBMI(double bmi){

    }
}
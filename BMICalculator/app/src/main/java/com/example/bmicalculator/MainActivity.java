package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button btnCalc;
    Button btnClear;
    EditText etHeight;
    EditText etWeight;
    double dHeight;
    double dWeight;
    double BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnCalc = findViewById(R.id.btnCalc);
        Button btnClear = findViewById(R.id.btnClear);
        EditText etHeight = findViewById(R.id.etHeight);
        EditText etWeight = findViewById(R.id.etWeight);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etHeight.setText("");
                etWeight.setText("");
            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    dHeight = Double.parseDouble(etHeight.getText().toString());
                    dWeight = Double.parseDouble(etWeight.getText().toString());
                } catch (Exception e) {

                }
                //Height is over 80cm and under 300cm && weight is over 20kg and under 200kg
                if (dHeight > 80 && dWeight > 20 && dHeight < 300 && dWeight < 200) {
                    //BMI = weight (kg) ÷ height*2 (meters)
                    //weight KG / ((height CM /100) *2)
                    BMI = dWeight / ((dHeight / 100 )*2);
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra("BMI", BMI);
                    MainActivity.this.startActivity(i);
                    etHeight.setText("");
                    etWeight.setText("");
                } else {
                    Toast.makeText(getApplicationContext(), "Check your inputs!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
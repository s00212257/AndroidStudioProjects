package com.example.resistorcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner4;
    Button btnCalc;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //No more top bar $$$
        getSupportActionBar().hide();

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner4 = findViewById(R.id.spinner4);

        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);

        ArrayAdapter<CharSequence> colourAdapter = ArrayAdapter.createFromResource(this,
                R.array.colours_array, android.R.layout.simple_spinner_item);

        colourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(colourAdapter);
        spinner2.setAdapter(colourAdapter);
        spinner4.setAdapter(colourAdapter);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);

        //Calc button press event
        btnCalc.setOnClickListener(view -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(spinner1.getSelectedItemPosition());
            stringBuilder.append(spinner2.getSelectedItemPosition());
            stringBuilder.append(Multiplier());

            String finalString = stringBuilder.toString();
            Toast.makeText(getApplicationContext(), (String) finalString,
                    Toast.LENGTH_LONG).show();
        });

        //Reset button press event
        btnReset.setOnClickListener(view -> {
        });
    }

    public String Multiplier(){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while(i < Integer.parseInt(String.valueOf(spinner4.getSelectedItemPosition()))){
            stringBuilder.append(0);
            i++;
        }

       return String.valueOf(stringBuilder);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
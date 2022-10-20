package com.example.resistorcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);

        ArrayAdapter<CharSequence> colourAdapter = ArrayAdapter.createFromResource(this,
                R.array.colours_array, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> multiAdapter = ArrayAdapter.createFromResource(this,
                R.array.coloursMulti_array, android.R.layout.simple_spinner_item);

        colourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        multiAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(colourAdapter);
        spinner2.setAdapter(colourAdapter);
        spinner3.setAdapter(colourAdapter);
        spinner4.setAdapter(multiAdapter);
    }

}
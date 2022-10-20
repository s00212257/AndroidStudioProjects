package com.example.resistorcalc;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner1;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Button btnCalc;
    Button btnReset;
    String pos1;
    String pos2;
    String pos3;
    String pos4;
    String res1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);

        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);

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

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);

        //Calc button press event
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                res1 = colourToValue(pos1);
                Toast.makeText(getApplicationContext(), (String)pos1.toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        //Reset button press event
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    String colourToValue(String colour){
        if(colour == "Black")
            return "0";
        else if(colour == "Brown")
            return "1";
        else if(colour == "Red")
            return "2";
        else if(colour == "Orange")
            return "3";
        else if(colour == "Yellow")
            return "4";
        else if(colour == "Green")
            return "5";
        else if(colour == "Blue")
            return "6";
        else if(colour == "Violet")
            return "7";
        else if(colour == "Grey")
            return "8";
        else if(colour == "White")
            return "9";
        else
            return "0";
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        pos1 = colourToValue(spinner1.getSelectedItem().toString());
        pos2 = colourToValue(spinner2.getSelectedItem().toString());
        pos3 = colourToValue(spinner3.getSelectedItem().toString());
        pos4 = colourToValue(spinner4.getSelectedItem().toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
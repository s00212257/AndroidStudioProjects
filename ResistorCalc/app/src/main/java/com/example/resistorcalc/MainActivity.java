package com.example.resistorcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerBandOne;
    Spinner spinnerBandTwo;
    Spinner spinnerMultiplier;
    Spinner spinnerTolerance;
    Button btnCalc;
    Button btnReset;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        spinnerBandOne = findViewById(R.id.spinnerBandOne);
        spinnerBandTwo = findViewById(R.id.spinnerBandTwo);
        spinnerMultiplier = findViewById(R.id.spinnerMultiplier);
        spinnerTolerance = findViewById(R.id.spinnerTolerance);
        tvResult = findViewById(R.id.tvResult);

        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);

        ArrayAdapter<CharSequence> bandColour = ArrayAdapter.createFromResource(this,
                R.array.bandColours, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> toleranceColour = ArrayAdapter.createFromResource(this,
                R.array.toleranceColours, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> multiColour = ArrayAdapter.createFromResource(this,
                R.array.multiColours, android.R.layout.simple_spinner_item);

        bandColour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toleranceColour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerBandOne.setAdapter(bandColour);
        spinnerBandTwo.setAdapter(bandColour);
        spinnerMultiplier.setAdapter(multiColour);
        spinnerTolerance.setAdapter(toleranceColour);

        spinnerBandOne.setOnItemSelectedListener(this);
        spinnerBandTwo.setOnItemSelectedListener(this);
        spinnerMultiplier.setOnItemSelectedListener(this);
        spinnerTolerance.setOnItemSelectedListener(this);

        //Calc button press event
        btnCalc.setOnClickListener(view -> {
            tvResult.setText(resistance() + " Ω " + Tolerance() + "%");
        });

        btnReset.setOnClickListener(view -> {
            spinnerBandOne.setSelection(0);
            spinnerBandTwo.setSelection(0);
            spinnerMultiplier.setSelection(0);
            spinnerTolerance.setSelection(0);
            tvResult.setText("");
        });
    }

    public String resistance(){
        int b1 = spinnerBandOne.getSelectedItemPosition();
        int b2 = spinnerBandTwo.getSelectedItemPosition();
        int m = spinnerMultiplier.getSelectedItemPosition();

        switch (m){
            default: return "" ;
            case 0 :
            case 1 :
            case 2 :
            case 3 :
                return String.valueOf(b1) + String.valueOf(b2) + Multiplier();
            case 4: return String.valueOf(b1) + String.valueOf(b2) + "0K";
            case 5: return String.valueOf(b1) + "." + String.valueOf(b2) + "M";
            case 6: return String.valueOf(b1) + String.valueOf(b2) + "M";
            case 7: return String.valueOf(b1) + String.valueOf(b2) + "0M";
            case 8: return String.valueOf(b1) + "." + String.valueOf(b2) + "G";
            case 9: return String.valueOf(b1) + String.valueOf(b2) + "G";
            case 10: return String.valueOf(b1) + "." + String.valueOf(b2);
            case 11: return "0." + String.valueOf(b1) + String.valueOf(b2);
        }
    }

    public String Multiplier(){
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while(i < Integer.parseInt(String.valueOf(spinnerMultiplier.getSelectedItemPosition()))){
            stringBuilder.append(0);
            i++;
        }
       return String.valueOf(stringBuilder);
    }

    public String Tolerance(){
        switch (spinnerTolerance.getSelectedItemPosition()){
            default: return "± 100";
            case 0: return "± 1";
            case 1: return "± 2";
            case 2: return "± 3";
            case 3: return "± 4";
            case 4: return "± 0.5";
            case 5: return "± 0.25";
            case 6: return "± 0.10";
            case 7: return "± 0.05";
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
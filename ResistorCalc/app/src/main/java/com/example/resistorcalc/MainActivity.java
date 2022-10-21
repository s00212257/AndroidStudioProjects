package com.example.resistorcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//TODO: Comments on code
//TODO: Remove unused items

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinnerBandOne;
    Spinner spinnerBandTwo;
    //Spinner spinnerBandThree;
    Spinner spinnerMultiplier;
    Spinner spinnerTolerance;
    Button btnCalc;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //No more top bar $$$
        getSupportActionBar().hide();

        spinnerBandOne = findViewById(R.id.spinnerBandOne);
        spinnerBandTwo = findViewById(R.id.spinnerBandTwo);
        //spinnerBandThree = findViewById(R.id.spinnerBandThree);
        spinnerMultiplier = findViewById(R.id.spinnerMultiplier);
        spinnerTolerance = findViewById(R.id.spinnerTolerance);

        btnCalc = findViewById(R.id.btnCalc);
        btnReset = findViewById(R.id.btnReset);

        ArrayAdapter<CharSequence> bandColour = ArrayAdapter.createFromResource(this,
                R.array.bandColours, android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence> toleranceColour = ArrayAdapter.createFromResource(this,
                R.array.toleranceColours, android.R.layout.simple_spinner_item);

        bandColour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        toleranceColour.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerBandOne.setAdapter(bandColour);
        spinnerBandTwo.setAdapter(bandColour);
        //spinnerBandThree.setAdapter(bandColour);
        spinnerMultiplier.setAdapter(bandColour);
        spinnerTolerance.setAdapter(toleranceColour);

        spinnerBandOne.setOnItemSelectedListener(this);
        spinnerBandTwo.setOnItemSelectedListener(this);
        //spinnerBandThree.setOnItemSelectedListener(this);
        spinnerMultiplier.setOnItemSelectedListener(this);
        spinnerTolerance.setOnItemSelectedListener(this);

        //Calc button press event
        btnCalc.setOnClickListener(view -> {
            //Build string from the values of the first two bands
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(spinnerBandOne.getSelectedItemPosition());
            stringBuilder.append(spinnerBandTwo.getSelectedItemPosition());
            //stringBuilder.append(spinnerBandThree.getSelectedItemPosition());
            //Add the correct number of "0"'s to it
            stringBuilder.append(Multiplier());

            //TODO: Add tolerance to end of string based on the selected item in tolerance spinner using the string array in strings.xml

            String finalString = stringBuilder.toString();

            //TODO: Output to a text view, displaying the result + remove toast once completed
            Toast.makeText(getApplicationContext(), (String) finalString,
                    Toast.LENGTH_LONG).show();
        });

        btnReset.setOnClickListener(view -> {
            //TODO: Add reset functionality (null selected item?)
        });
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

    /*
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
    */

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
package com.example.myapplicationcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button myButtonAdd;
    TextView resultText;
    EditText inputOne;
    EditText inputTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButtonAdd = findViewById(R.id.btnAdd);
        Button myButtonMult = findViewById(R.id.btnMult);
        Button myButtonClear = findViewById(R.id.btnClear);
        TextView resultText = findViewById(R.id.resultText);
        EditText inputOne = findViewById(R.id.editTextNumberOne);
        EditText inputTwo = findViewById(R.id.editTextNumberTwo);

        //Multiply
        myButtonMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputOne.getText().length() > 0  && inputTwo.getText().length() > 0 && inputOne.getText() != null && inputTwo.getText() != null){
                    int a = Integer.parseInt(inputOne.getText().toString());
                    int b = Integer.parseInt(inputTwo.getText().toString());
                    resultText.setText(Integer.toString(Multiply(a,b)));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error lol", Toast.LENGTH_LONG);
                }
            }
        });

        //Clear
        myButtonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputOne.setText("0");
                inputTwo.setText("0");
                resultText.setText("0");
            }
        });

        //Add
        myButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputOne.getText().length() > 0  && inputTwo.getText().length() > 0 && inputOne.getText() != null && inputTwo.getText() != null){
                    int a = Integer.parseInt(inputOne.getText().toString());
                    int b = Integer.parseInt(inputTwo.getText().toString());
                    resultText.setText(Integer.toString(Add(a,b)));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Error lol", Toast.LENGTH_LONG);
                }
            }
        });
    }

    //Returns the sum of two integers
    public static int Add(int a, int b){
        int c = a + b;
        return c;
    }

    //Returns the multiplication of two integers
    public static int Multiply(int a, int b){
        int c = a * b;
        return  c;
    }
}
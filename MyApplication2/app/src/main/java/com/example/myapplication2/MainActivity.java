package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button myButton;
    EditText myText;
    TextView upperText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button) findViewById(R.id.button);
        myText = findViewById(R.id.editTextTextPersonName);
        upperText = findViewById(R.id.textView);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                upperText.setText(myText.getText().toString());
                Log.v("Text:", myText.getText().toString());
                Toast.makeText(getApplicationContext(), (String)myText.getText().toString(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }

}
package com.example.accelerometersound;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Boolean isFlat;
    TextView tvx, tvy, tvz;
    private SensorManager mSensorManager;
    private Sensor mSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvx = findViewById(R.id.tvxval);  // this assumes there are three textviews
        tvy = findViewById(R.id.tvyval);  // in your xml file called tvxval, tvyval
        tvz = findViewById(R.id.tvzval);  // and tvzval

        // choose the sensor you want
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    /*
     * When the app is brought to the foreground - using app on screen
     */
    protected void onResume() {
        super.onResume();
        // turn on the sensor
        mSensorManager.registerListener(this, mSensor,
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    /*
     * App running but not on screen - in the background
     */
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);    // turn off listener to save power
    }

    /*
     * Called by the system every x milllisecs when sensor changes
     */
    @Override
    public void onSensorChanged(SensorEvent event) {
        // called byt the system every x ms
        float x, y, z;
        float x1, y1, z1;

        x1 = Math.abs(event.values[0]); // get x value
        y1 = Math.abs(event.values[1]);
        z1 = Math.abs(event.values[2]);

        x = event.values[0];    // get x value from sensor
        y = event.values[1];
        z = event.values[2];

        tvx.setText(String.valueOf(x));
        tvy.setText(String.valueOf(y));
        tvz.setText(String.valueOf(z));

        if (x1 < 1 && y1 < 9 && z1 > 1) { // phone is flat
            if (isFlat == false) { // isFlat is global
                isFlat = true;
                Toast.makeText(this, "Phone is flat",
                        Toast.LENGTH_SHORT).show();
            }
        }
        }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
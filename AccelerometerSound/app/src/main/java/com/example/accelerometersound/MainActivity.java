package com.example.accelerometersound;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Boolean isFlat = false;
    TextView tvx, tvy, tvz, tvx1, tvy1, tvz1, tvstat;
    Button button;
    private SensorManager mSensorManager;
    private Sensor mSensor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvx = findViewById(R.id.tvxval);  // this assumes there are three textviews
        tvx1 = findViewById(R.id.tvxval1);  // this assumes there are three textviews
        tvy = findViewById(R.id.tvyval);  // in your xml file called tvxval, tvyval
        tvy1 = findViewById(R.id.tvyval1);  // in your xml file called tvxval, tvyval
        tvz = findViewById(R.id.tvzval);  // and tvzval
        tvz1 = findViewById(R.id.tvzval1);  // and tvzval
        tvstat = findViewById(R.id.txstat);
        button = findViewById(R.id.button);

        // choose the sensor you want
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isFlat = true;
            }
        });
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
        double x, y, z;
        double x1, y1, z1;

        x1 = Math.abs(event.values[0]); // get x value
        y1 = Math.abs(event.values[1]);
        z1 = Math.abs(event.values[2]);

        x = event.values[0];    // get x value from sensor
        y = event.values[1];
        z = event.values[2];

        tvx.setText(String.valueOf(x));
        tvx1.setText(String.valueOf(x1));
        tvy.setText(String.valueOf(y));
        tvy1.setText(String.valueOf(y1));
        tvz.setText(String.valueOf(z));
        tvz1.setText(String.valueOf(z1));

        final MediaPlayer mp = MediaPlayer.create(this,
                R.raw.cat_sound);

        if (x1 < 1 && y1 < 1 && z1 > 9) { // phone is flat
                if (!isFlat) { // isFlat is global
                    tvstat.setText("Flat");
                    isFlat = true;
                    mp.start();
                }
                else{
                    tvstat.setText("Not flat");
                    isFlat = false;
                }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
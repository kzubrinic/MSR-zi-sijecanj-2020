package hr.unidu.kz.msr_zi_2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Zadatak2Activity extends AppCompatActivity implements SensorEventListener {
    private EditText tId, tIme;
    private Button gumb;
    private Sensor proximitySensor;
    private SensorManager proximitySensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadatak2);
        tId = findViewById(R.id.tId);
        tIme = findViewById(R.id.tIme);
        gumb = findViewById(R.id.gumb);
        setTitle("Drugi zadatak :)");
        //Get an instance of SensorManager//

        proximitySensorManager = (SensorManager) getSystemService(
                Context.SENSOR_SERVICE);

//Check for a proximity sensor//

        proximitySensor = proximitySensorManager.getDefaultSensor(
                Sensor.TYPE_PROXIMITY);
    }

    public void izracunaj(View view) {
        Toast.makeText(this, tId.getText().toString() + " " + tIme.getText().toString() , Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onStart() {
        super.onStart();

//If the sensor is available on the current device...//

        if (proximitySensor != null) {

//….then register a listener//

            proximitySensorManager.registerListener(this, proximitySensor,

//Specify how often you want to receive new data//

                    SensorManager.SENSOR_DELAY_NORMAL);
        }

    }
    @Override
    protected void onStop() {
        super.onStop();

//Unregister your listener to preserve system resources//

        proximitySensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

//The sensor’s current value//

        float currentValue = sensorEvent.values[0];
        System.out.println("CV: "+ currentValue);
        if (currentValue < 5.0){
            tId.setEnabled(false);
            tIme.setEnabled(false);
            gumb.setEnabled(false);

        }
        else {
            tId.setEnabled(true);
            tIme.setEnabled(true);
            gumb.setEnabled(true);

        }
        
    }

    @Override

//If the sensor’s accuracy changes….//

    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}

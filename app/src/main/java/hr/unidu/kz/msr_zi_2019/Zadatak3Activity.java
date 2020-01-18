package hr.unidu.kz.msr_zi_2019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class Zadatak3Activity extends AppCompatActivity  {
    private Location selo, mLastLocation;
    private TextView t1, t2, t3;
    private final int REQUEST_LOCATION_PERMISSION = 1;
    private FusedLocationProviderClient mFusedLocationClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zadatak3);
        t1 = findViewById(R.id.lat);
        t2 = findViewById(R.id.lon);
        t3 = findViewById(R.id.udalj);
        setTitle("Treći zadatak");
        getLocation();
        LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        selo = new Location("");
        selo.setLatitude(66.543611);//your coords of course
        selo.setLongitude(25.847222);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.getLastLocation().addOnSuccessListener(
                new OnSuccessListener<Location>() {
                    @Override
                    public void onSuccess(Location location) {
                        if (location != null) {
                            //selo.setLatitude(42.562273);
                            //selo.setLongitude(18.263498);
                            mLastLocation = location;
                            t1.setText(String.format(getString(R.string.lati), mLastLocation.getLatitude()));
                            t2.setText(String.format(getString(R.string.longi), mLastLocation.getLongitude()));
                            izracun(mLastLocation);

                        }
                    }


    });
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]
                            {Manifest.permission.ACCESS_FINE_LOCATION},1);
        } else {
            Log.d("TAG", "getLocation: permissions granted");
        }
    }


    private void izracun(Location location){
        double udaljenost = selo.distanceTo(location)/1000;
        t1.setText(String.format(getString(R.string.lati), location.getLatitude()));
        t2.setText(String.format(getString(R.string.longi), location.getLongitude()));
        t3.setText(String.format(getString(R.string.udaljenost), udaljenost));
        Toast.makeText(this, "Udaljenost= " + udaljenost, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION:
                // If the permission is granted, get the location,
                // otherwise, show a Toast
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    getLocation();
                } else {
                    Toast.makeText(this,
                            "Request dozvola nije data!",
                            Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

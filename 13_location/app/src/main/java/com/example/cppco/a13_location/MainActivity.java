package com.example.cppco.a13_location;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView myTextView;
    Geocoder geocoder;
    LocationManager manager;
    LocationListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        geocoder = new Geocoder(this);

        myTextView = (TextView) findViewById(R.id.myTextView);

        String str = "";

        manager = (LocationManager) getSystemService(LOCATION_SERVICE);

        List<String> providers = manager.getAllProviders();

        for (String provider : providers) {
            str += "provider : " + provider + " state: " + manager.isProviderEnabled(provider) +"\n";
        }
        myTextView.setText(str);

        listener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                try {
                    List<Address> list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 10);
                    Address a = list.get(0);
                    myTextView.append(a.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                String str = "lat: " + location.getLatitude() + "l\non : " + location.getLongitude() +
                        "\nalt : " + location.getAltitude() +"\n";
                myTextView.append(str);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1.0f, listener);
        manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1.0f, listener);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        manager.removeUpdates(listener);
    }

    public void btnClick (View v) {
        try {
            List<Address> list = geocoder.getFromLocationName("서울 구로구 구로3동", 10);
            Address a = list.get(0);
            myTextView.setText(a.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




























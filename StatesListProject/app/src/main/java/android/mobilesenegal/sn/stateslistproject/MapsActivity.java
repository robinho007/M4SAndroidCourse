package android.mobilesenegal.sn.stateslistproject;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private LocationManager mLocationManager;
    static final LatLng TOPEKA = new LatLng(39.054, -95.683);
    static final LatLng NEWYORK = new LatLng(40.735, -73.996);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        /*
        mLocationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
        String provider = getBestProvider(mLocationManager);
        mLocationManager.requestLocationUpdates(provider, 60000, 100, this);

        SupportMapFragment fragment = (SupportMapFragment)this.getSupportFragmentManager()
                .findFragmentById(R.id.map);

        LatLng latLng = new LatLng(40.734641, -73.996181);
        float zoomLevel = 10.0f;
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel);
        fragment.getMap().animateCamera(cameraUpdate);
        */

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Topeka and move the camera
        mMap.addMarker(new MarkerOptions()
                .position(TOPEKA)
                .title("Topeka")
                .snippet("Population: 127,473 (2010)")
                .alpha(10.0f));

        float zoomLevel = 12.0f;
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(TOPEKA, zoomLevel));
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    public static String getBestProvider(LocationManager locationManager){
        Criteria criteria = new Criteria();
        criteria.setAccuracy(criteria.ACCURACY_COARSE);
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        criteria.setCostAllowed(true);
        return locationManager.getBestProvider(criteria, true);
    }
}

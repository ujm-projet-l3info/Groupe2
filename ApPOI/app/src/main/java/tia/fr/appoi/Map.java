package tia.fr.appoi;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;

public class Map extends Activity implements OnMapReadyCallback {

    //ListView lstView;   //ListView pour afficher les résultats

    //------------Attributs------------
    public static double gpsLon, gpsLat;
    public static int distance;
    public static String json;
    public static ArrayList<String> checkedTags;
    public GetNodes gn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Bundle b = this.getIntent().getExtras();
        gpsLat = b.getDouble("gpsLat");
        gpsLon = b.getDouble("gpsLon");
        distance = b.getInt("distance");
        json = b.getString("json");
        checkedTags = b.getStringArrayList("checkedTags");

        //lstView = (ListView)findViewById(R.id.lstView);

        MapFragment mf1 = MapFragment.newInstance();
        FragmentTransaction fragmentTransaction =
                getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.rtlMap, mf1);
        fragmentTransaction.commit();

        mf1.getMapAsync(this);

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location location = null;

        try {
            location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            gpsLon = location.getLongitude();
            gpsLat = location.getLatitude();
        } catch (SecurityException e) {
            System.err.println("--------GPS non active");
        }

        //------------Requete vers le serveur php------------
        gn1 = new GetNodes();
        gn1.execute("http://10.0.2.2:80/android/getNodes.php?json=" + json);    //On passe le json en parametre GET

        //------------Remplir la listView avec l'ArrayList gn1.result------------
        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,gn1.result );
        lstView.setAdapter(arrayAdapter);*/

        //------------Listener du click sur btnMenu------------
        Button btnMenu = (Button) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Map.this, Menu.class);    //On ouvre l'activite Menu, et on y envoie les variables ci-dessous
                Bundle b = new Bundle();
                b.putInt("distance", distance);
                b.putDouble("gpsLat", gpsLat);
                b.putDouble("gpsLon", gpsLon);
                b.putString("json", json);
                b.putStringArrayList("checkedTags", checkedTags);
                i.putExtras(b);
                startActivity(i);
            }
        });


        /*-----------Listener du click sur btnFermer----------*/
        Button btnFermer = (Button) findViewById(R.id.btnFermer);
        btnFermer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap map) {

        LatLng pos = new LatLng(gpsLat, gpsLon);    //Set la map sur gpsLat, gpsLon

        try {
            map.setMyLocationEnabled(true);
        } catch (SecurityException e) {
            System.err.println("GPS failed");
        }

        map.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 13));
        for(Node n : gn1.nodes) {
            map.addMarker(new MarkerOptions()
                    .title(n.toString())
                    .position(new LatLng(n.lat, n.lon)));
        }

    }

}

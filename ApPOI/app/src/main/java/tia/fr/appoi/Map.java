package tia.fr.appoi;

import android.app.Activity;
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

import java.util.ArrayList;

public class Map extends Activity {

    ListView lstView;   //ListView pour afficher les résultats

    //------------Attributs------------
    public static double gpsLon, gpsLat;
    public static int distance;
    public static String json;
    public static ArrayList<String> checkedTags;

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

        lstView = (ListView)findViewById(R.id.lstView);

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
        GetNodes gn1 = new GetNodes();
        gn1.execute("http://10.0.2.2:80/android/getNodes.php?json=" + json);    //On passe le json en parametre GET

        //------------Remplir la listView avec l'ArrayList gn1.result------------
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_list_item_1,gn1.result );
        lstView.setAdapter(arrayAdapter);

        //------------Listener du click sur btnMenu------------
        Button btnMenu = (Button)findViewById(R.id.btnMenu);
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
    }
}

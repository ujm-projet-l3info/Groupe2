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

public class MainActivity extends Activity {

    public static double gpsLat, gpsLon;    //Positions du GPS
    public static int distance; //Distance de recherche
    public static String json;  //JSON echange avec le serveur
    public static ArrayList<String> checkedTags;    //Liste des checkBoxes cochees

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //------------Instanciation des valeurs par defaut pour la recherche------------
        this.checkedTags = new ArrayList<String>();
        this.checkedTags.add("tourism");
        this.checkedTags.add("historic");
        this.gpsLat = 45.432174;
        this.gpsLon = 4.394739;
        this.distance = 1500;
        this.json = "{\"distance\":\""+this.distance+"\"," +
            "\"latitude\":\""+this.gpsLat+"\"," +
            "\"longitude\":\""+this.gpsLon+"\","+
            "\"params\":["+
            "{\"name\":\"historic\"},"+
            "{\"name\":\"tourism\"}]}";


        //------------Lancement de l'activite Map------------

        Intent i = new Intent(MainActivity.this, Map.class);    //Intent definissant l'activite d'origine et l'activite de destination
        Bundle b = new Bundle();    //Bundle contenant les variables passees a l'activite de destination
        b.putInt("distance", distance); //Si vous avez besoin de commentaires pour ces 5 lignes
        b.putDouble("gpsLat", gpsLat);  //Je peux plus rien pour vous
        b.putDouble("gpsLon", gpsLon);
        b.putString("json", json);
        b.putStringArrayList("checkedTags", checkedTags);
        i.putExtras(b); //Ajouter le Bundle a l'intent, pour l'envoyer vers l'activite de destination

        startActivity(i);   //Lancement de l'activite Map (en gros, changement de page)

    }

}

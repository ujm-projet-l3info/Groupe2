package tia.fr.appoi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Menu extends Activity implements SeekBar.OnSeekBarChangeListener {

    //------------Composants de l'activite dont on a besoin------------
    SeekBar seekBar;
    TextView txtSkbCurrent;
    RelativeLayout rtlCheckboxes;

    //------------Attributs------------
    public static double gpsLon, gpsLat;
    public static int distance;
    public static String json;
    public static ArrayList<String> checkedTags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //------------Recuperation des composants------------
        txtSkbCurrent = (TextView) findViewById(R.id.txtSkbCurrent);
        rtlCheckboxes = (RelativeLayout) findViewById(R.id.rtlCheckboxes);
        seekBar = (SeekBar) findViewById(R.id.skbDistance);

        //------------Recuperation des variables passees au changement d'activite
        Bundle b = this.getIntent().getExtras();
        gpsLat = b.getDouble("gpsLat");
        gpsLon = b.getDouble("gpsLon");
        distance = b.getInt("distance");
        json = b.getString("json");
        checkedTags = b.getStringArrayList("checkedTags");

        //------------Cocher les checkboxes en fonction des parametres presents dans la liste checkedTags------------
        CheckBox cb;
        for(int i = 0 ; i < rtlCheckboxes.getChildCount() ; i++) {  //Parcours les enfants du RelativeLayout, conteneur des checkboxes
            cb = (CheckBox)rtlCheckboxes.getChildAt(i);
            if(checkedTags.contains(cb.getText())) {
                cb.setChecked(true);
            }
        }

        seekBar.setProgress(distance);  //Ca marche pas
        txtSkbCurrent.setText(distance + " m"); //Set du texte indiquant la valeur de la seekbar
        seekBar.setOnSeekBarChangeListener(this);   //Set du listener onChange => par defaut methode OnProgressChanges (voir plus bas)


        //------------Listener du bouton btnRechercher------------
        Button btnRechercher = (Button) findViewById(R.id.btnRechercher);
        btnRechercher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb;
                checkedTags.clear();    //On va re-remplir la liste de tags choisis par l'utilisateur
                for(int i = 0 ; i < rtlCheckboxes.getChildCount() ; i++) {
                    cb = (CheckBox)rtlCheckboxes.getChildAt(i);
                    if(cb.isChecked()) {
                        checkedTags.add((String)cb.getText());  //Ajout du nom de la checkbox dans la liste
                    }
                }

                //------------Creation du json a envoyer au serveur------------
                json = "{\"distance\":\""+distance+"\"," +
                        "\"latitude\":\""+gpsLat+"\"," +
                        "\"longitude\":\""+gpsLon+"\","+
                        "\"params\":[" ;
                int count = 0;
                for(String s : checkedTags) {
                    if(count != 0)
                        json += ",";
                    json += "{\"name\":\""+s+"\"}";
                    count++;
                }
                json += "]}";

                if(count != 0) {    //Si au moins une checkbox est cochee
                    Intent i = new Intent(Menu.this, Map.class);    //On retournera sur Map avec les variables ci-dessous
                    Bundle b = new Bundle();
                    b.putDouble("gpsLat", gpsLat);
                    b.putDouble("gpsLon", gpsLon);
                    b.putInt("distance", distance);
                    b.putString("json", json);
                    b.putStringArrayList("checkedTags", checkedTags);
                    i.putExtras(b);
                    startActivity(i);
                }
            }
        });
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {    //Deplacement du curseur de la seekbar
        distance = progress;
        txtSkbCurrent.setText(distance + " m");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
    }
}

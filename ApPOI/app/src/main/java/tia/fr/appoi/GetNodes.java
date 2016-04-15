package tia.fr.appoi;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Steex on 13/04/2016.
 * Alors attention, c'est du lourd. Android nous interdit de faire du traitement dans l'activite principale
 * On va donc passer par cette classe, qui étend AsyncTask : Elle va donc s'executer en arriere-plan.
 */
public class GetNodes extends AsyncTask<String, ArrayList<String>, Void> {

    public ArrayList<Node> nodes = new ArrayList<Node>();   //Liste de nodes
    public ArrayList<String> result = new ArrayList<String>();  //Liste resultat bien formatee, affichee dans la listView de Map.java

    /*
    S'execute en arriere plan. Peut recevoir de 1 à n String en parametre
     */
    protected Void doInBackground(String... urls) {

        //------------Variables requises pour la connexion/lecture/ecriture au serveur------------

        String line;
        StringBuilder strOut = new StringBuilder(); //Permet de formater le retour lu

        HttpURLConnection urlConnection = null;
        OutputStream out = null;
        InputStream in = null;
        BufferedReader reader = null;
        URL url = null;
        DecimalFormat format = new DecimalFormat("#0.00");  //Ca me parait assez explicite

        try {
            url = new URL(urls[0]); //Premiere url passee a l'execute depuis Map.

            urlConnection = (HttpURLConnection) url.openConnection();
            System.err.println("------Connection opened-------");   //Garder pour le debug, a remplacer par des toasts plus tard, eventuellement
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            out = new BufferedOutputStream(urlConnection.getOutputStream());
            in = new BufferedInputStream(urlConnection.getInputStream());
            reader = new BufferedReader(new InputStreamReader(in));

            while ((line = reader.readLine()) != null) {    //Lecture du flux
                strOut.append(line);
            }
            try {
                JSONObject obj = new JSONObject(strOut.toString());
                long id;
                double lat, lon, distance;
                Node n;
                Iterator iterator;
                String key, value;

                //------------Parsing JSON------------
                for(int i = 1 ; i <= obj.length() ; i++) {  //Parcours du tableau JSON
                    id = obj.getJSONObject(Integer.toString(i)).getLong("id");
                    lat = obj.getJSONObject(Integer.toString(i)).getDouble("latitude");
                    lon = obj.getJSONObject(Integer.toString(i)).getDouble("longitude");
                    distance = obj.getJSONObject(Integer.toString(i)).getDouble("distance");

                    n = new Node(id, lat, lon, distance);   //Instanciation d'un Node

                    /*
                    Comme on ne connait pas la clef (qui peut etre quelque chose comme amenity, shop, historic.....
                    On doit utiliser un iterateur pour parcour la liste de parametres, recuperer les clefs puis les valeurs correspondantes
                     */
                    iterator = obj.getJSONObject(Integer.toString(i)).getJSONObject("tags").keys();
                    while(iterator.hasNext()) {
                        key = (String) iterator.next();
                        value = obj.getJSONObject(Integer.toString(i)).getJSONObject("tags").getString(key);
                        n.tags.add(new Tag(key, value));
                    }
                    nodes.add(n);   //ajout du node instancie dans la liste de nodes
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
            System.err.println("------Connection closed-------");   //Garder pour le debug
        }
        //------------Remplir la liste de resultat avec un format lisible------------
        String str;
        for(Node n : nodes) {
            str = "";
            for(Tag t : n.tags) {
                str += t.k + " : " + t.v + " ,";
            }
            str += " Lat : " + n.lat + " , Lon : " + n.lon + " , Distance : " + format.format(n.distance) + " mètres" ;
            result.add(str);    //Format final => amenity : valeur , shop : valeur , ..... Lat : XX.XXXX , Lon : XX.XXXX , Distance : XXXX.XX metres
        }
        return null;
    }

    protected void onProgressUpdate(Integer... progress) {

    }

    protected void onPostExecute(Long result) {

    }

    public void fillList(ArrayList<String> als) {

    }


    /*


     */
}

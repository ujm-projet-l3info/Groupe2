package tia.fr.appoi;

import android.os.AsyncTask;
import android.renderscript.ScriptGroup;
import android.widget.ArrayAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * Created by Steex on 13/04/2016.
 */
public class GetNodes extends AsyncTask<String, Integer, Void> {

    public ArrayList<Node> nodes = new ArrayList<Node>();

    protected Void doInBackground(String... urls) {

        HttpURLConnection urlConnection = null;
        String line;
        StringBuilder strOut = new StringBuilder();
        OutputStream out = null;
        InputStream in = null;
        BufferedReader reader = null;
        URL url = null;
        try {
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            System.err.println("------Connection opened-------");
            urlConnection.setDoOutput(true);
            urlConnection.setChunkedStreamingMode(0);

            out = new BufferedOutputStream(urlConnection.getOutputStream());
            in = new BufferedInputStream(urlConnection.getInputStream());
            reader = new BufferedReader(new InputStreamReader(in));

            while ((line = reader.readLine()) != null) {
                strOut.append(line);
            }
            try {
                JSONObject obj = new JSONObject(strOut.toString());
                long id;
                double lat, lon;
                ArrayList<Tag> listTags = new ArrayList<Tag>();
                Node n;
                Iterator iterator;
                String key, value;
                for(int i = 1 ; i <= obj.length() ; i++) {
                    id = obj.getJSONObject(Integer.toString(i)).getLong("id");
                    lat = obj.getJSONObject(Integer.toString(i)).getDouble("latitude");
                    lon = obj.getJSONObject(Integer.toString(i)).getDouble("longitude");
                    //System.out.println("Id : " + id + ", Lat : " + lat + ", Lon : " + lon);
                    iterator = obj.getJSONObject(Integer.toString(i)).getJSONObject("tags").keys();
                    while(iterator.hasNext()) {
                        key = (String) iterator.next();
                        value = obj.getJSONObject(Integer.toString(i)).getJSONObject("tags").getString(key);
                        //System.out.println("Key : " + key + ", Value : " + value);
                        listTags.add(new Tag(key, value));
                    }

                    n = new Node(id, lat, lon);
                    //n.tags = listTags;
                    nodes.add(n);
                    listTags.clear();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
            System.err.println("------Connection closed-------");
        }
        return null;
    }

    protected void onProgressUpdate(Integer... progress) {

    }

    protected void onPostExecute(Long result) {

    }

    public void fillList(ArrayList<String> als) {
        String str;
        for(Node n : nodes) {
            str = "";

            for(Tag t : n.tags) {
                str += t.k + " : " + t.v + "\n";
            }
            str += "\nLatitude : " + n.lat + " , Longitude : " + n.lon;
            als.add(str);
        }
    }


    /*


     */
}

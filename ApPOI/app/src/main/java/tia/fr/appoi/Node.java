package tia.fr.appoi;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Node {
	public long id;
	public double lat;
	public double lon;
	public double distance;
	public ArrayList<Tag> tags;

	public Node(long id, double lat, double lon, double distance) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.distance = distance;
		this.tags = new ArrayList<Tag>();
	}

	public String toString() {
		String s = "";
		for(Tag t : tags) {
			s += t.toString();
		}
		return s;
	}

	public String getTitre() {
		int i = 0;
		String titre = "";
		String name = "";

		for(Tag t : tags) {
			if(t.k.equals("name")) {
				System.out.println("--------1--------");
				name = t.v;
			}

			if(t.k.equals("amenity") || t.k.equals("builing") || t.k.equals("historic") || t.k.equals("leisure") || t.k.equals("nature") || t.k.equals("shop") || t.k.equals("sport") || t.k.equals("tourism") || t.k.equals("waterway")) {
				System.out.println("--------2--------");
				if(i != 0)
					titre += ", ";
				titre += t.v;
				i++;
			}
		}
		System.out.println("--------3--------");

		if(name.equals(""))
			return titre;
		return name + " (" + titre + ")";
	}

	public String getInfos() {
		String str = "";
		int i = 0;

		for(Tag t : tags) {

			if(!t.k.equals("name") && !t.k.equals("amenity") && !t.k.equals("builing") && !t.k.equals("historic") && !t.k.equals("leisure") && !t.k.equals("nature") && !t.k.equals("shop") && !t.k.equals("sport") && !t.k.equals("tourism") && !t.k.equals("waterway")) {
				if(i != 0)
					str += "\n";
				if(t.k.equals("wikipedia"))
					str += t.k + " : https://" + t.v.split(":")[0] + ".wikipedia.org/wiki/" + t.v.split(":")[1].replace(' ', '_').replace("'", "%27");
				else
					str += t.k + " : " + t.v;
			}
			i++;
		}
		return str;
	}



}

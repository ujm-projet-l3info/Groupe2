package tia.fr.appoi;

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
}

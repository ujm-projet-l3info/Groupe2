package tia.fr.appoi;

import java.util.ArrayList;

public class Node {
	public long id;
	public double lat;
	public double lon;
	public ArrayList<Tag> tags;
	
	public Node(long id, double lat, double lon) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.tags = new ArrayList<Tag>();
	}
}

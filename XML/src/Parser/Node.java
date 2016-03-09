package Parser;

import java.util.ArrayList;

public class Node {
	public int id;
	public double lat;
	public double lon;
	public ArrayList<Tag> tags;
	
	public Node(int id, double lat, double lon) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
	}
}

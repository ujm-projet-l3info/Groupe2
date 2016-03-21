package Parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * DELETE FROM application_android_projet.tag WHERE 1;
DELETE FROM application_android_projet.information WHERE 1;

SELECT * FROM application_android_projet.information WHERE id NOT IN (SELECT id_info FROM application_android_projet.tag)
 */

public class DB {
	private Connection c;
	private Statement st;
	private ResultSet rs;
	private ArrayList<Tag> listeTag;

	public DB(String url, String usr, String mdp) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection(url, usr, mdp);
			System.out.println("Connection à la BD ok");
			st = c.createStatement();
			rs = null;
			//#petite_liste
			listeTag = new ArrayList<Tag>();
			listeTag.add(new Tag("amenity",""));
			listeTag.add(new Tag("building",""));
			listeTag.add(new Tag("historic",""));
			listeTag.add(new Tag("leisure",""));
			listeTag.add(new Tag("shop",""));
			listeTag.add(new Tag("sport",""));
			listeTag.add(new Tag("tourism",""));
			listeTag.add(new Tag("waterway",""));
			listeTag.add(new Tag("name",""));
			listeTag.add(new Tag("addr:street",""));
			listeTag.add(new Tag("addr:housenumber",""));
			listeTag.add(new Tag("addr:city",""));
			listeTag.add(new Tag("addr:postcode",""));
			listeTag.add(new Tag("opening_hours",""));
			listeTag.add(new Tag("website",""));
			listeTag.add(new Tag("addr:country",""));
			listeTag.add(new Tag("information",""));
			listeTag.add(new Tag("wikipedia",""));
			listeTag.add(new Tag("image",""));
			listeTag.add(new Tag("cuisine",""));
			listeTag.add(new Tag("religion",""));
			listeTag.add(new Tag("source",""));
			listeTag.add(new Tag("building:levels",""));
			listeTag.add(new Tag("height",""));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			if(rs != null)
				rs.close();
			st.close();
			c.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void ajouteNode(Node n){
		boolean keep = false;
		if(n.tags != null){
			for(Tag t : n.tags){
				//#petit_if
				if( t.k.equals("shop") || t.k.equals( "sport")|| t.k.equals( "tourism")|| t.k.equals( "historic")|| 
					      (t.k.equals( "waterway")&& t.v.equals( "dam")) || (t.k.equals( "waterway")&& t.v.equals( "waterfall")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "bar")) || (t.k.equals( "amenity")&& t.v.equals( "cafe")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "restaurant")) || (t.k.equals( "amenity")&& t.v.equals( "fast_food")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "pub")) || (t.k.equals( "amenity")&& t.v.equals( "library")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "university")) || (t.k.equals( "amenity")&& t.v.equals( "arts_centre")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "fountain")) || (t.k.equals( "amenity")&& t.v.equals( "planetarium")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "casino")) || (t.k.equals( "amenity")&& t.v.equals( "cinema")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "theatre")) || (t.k.equals( "amenity")&& t.v.equals( "clock")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "crypt")) || (t.k.equals( "amenity")&& t.v.equals( "place_of_worship")) ||
					       (t.k.equals( "amenity")&& t.v.equals( "townhall")) || (t.k.equals( "amenity")&& t.v.equals( "nightclub"))||
					       (t.k.equals( "building")&& t.v.equals( "hotel")) || (t.k.equals( "building")&& t.v.equals( "retail"))||
					       (t.k.equals( "building")&& t.v.equals( "cathedral")) || (t.k.equals( "building")&& t.v.equals( "chapel"))||
					       (t.k.equals( "building")&& t.v.equals( "church")) || (t.k.equals( "building")&& t.v.equals( "mosque"))||
					       (t.k.equals( "building")&& t.v.equals( "temple")) || (t.k.equals( "building")&& t.v.equals( "synagogue"))||
					       (t.k.equals( "building")&& t.v.equals( "shrine")) || (t.k.equals( "building")&& t.v.equals( "civic"))||
					       (t.k.equals( "building")&& t.v.equals( "stadium")) || (t.k.equals( "building")&& t.v.equals( "university"))||
					       (t.k.equals( "building")&& t.v.equals( "public")) || (t.k.equals( "building")&& t.v.equals( "bridge"))||
					       (t.k.equals( "building")&& t.v.equals( "ruins")) ||
					       (t.k.equals( "leisure")&& t.v.equals( "adult_gaming_center")) || (t.k.equals( "leisure")&& t.v.equals( "amusement_arcade"))||
					       (t.k.equals( "leisure")&& t.v.equals( "bandstand")) || (t.k.equals( "leisure")&& t.v.equals( "dance"))||
					       (t.k.equals( "leisure")&& t.v.equals( "firepit")) || (t.k.equals( "leisure")&& t.v.equals( "fishing"))||
					       (t.k.equals( "leisure")&& t.v.equals( "garden")) || (t.k.equals( "leisure")&& t.v.equals( "golf_course"))||
					       (t.k.equals( "leisure")&& t.v.equals( "ice_rink")) || (t.k.equals( "leisure")&& t.v.equals( "marina"))||
					       (t.k.equals( "leisure")&& t.v.equals( "nature_reserve")) || (t.k.equals( "leisure")&& t.v.equals( "park"))||
					       (t.k.equals( "leisure")&& t.v.equals( "pitch")) || (t.k.equals( "leisure")&& t.v.equals( "stadium"))||
					       (t.k.equals( "leisure")&& t.v.equals( "swimming_pool")) || (t.k.equals( "leisure")&& t.v.equals( "swimming_area"))||
					       (t.k.equals( "leisure")&& t.v.equals( "track")) || (t.k.equals( "leisure")&& t.v.equals( "water_park"))||
					       (t.k.equals( "leisure")&& t.v.equals( "wildlife_hide"))
						 ){
					keep = true;
				}
			}
			if(keep){
				n.tags = intersection(n.tags, listeTag);
				try {
					st.executeUpdate("INSERT INTO application_android_projet.information VALUES (" + n.id + ", " + n.lat + ", " + n.lon + ")");
					for(Tag t : n.tags){
						ajouteTag(t, n);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
    public ArrayList<Tag> intersection(ArrayList<Tag> list1, ArrayList<Tag> list2) {
    	ArrayList<Tag> list = new ArrayList<Tag>();

        for (Tag t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
	
	private void ajouteTag(Tag t, Node n){
		try {
			rs = st.executeQuery("SELECT id_cle FROM application_android_projet.cle WHERE libelle = '" + t.k + "'");
			if(rs.next()){
				st.executeUpdate("INSERT INTO application_android_projet.tag VALUES (" + n.id + ", " + rs.getLong(1) + ", '" + addSlashes(t.v) + "')");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String addSlashes(String s) {
	    s = s.replaceAll("\\\\", "\\\\\\\\");
	    s = s.replaceAll("\\n", "\\\\n");
	    s = s.replaceAll("\\r", "\\\\r");
	    s = s.replaceAll("\\00", "\\\\0");
	    s = s.replaceAll("'", "\\\\'");
	    return s;
	}
	
}

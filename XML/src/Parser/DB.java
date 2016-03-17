package Parser;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


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
			//#petite_liste
			listeTag = new ArrayList<Tag>();
			listeTag.add(new Tag("amenity",""));
			listeTag.add(new Tag("building",""));
			listeTag.add(new Tag("historic",""));
			listeTag.add(new Tag("leisure",""));
			listeTag.add(new Tag("nature",""));
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
				if(t.k == "natural" || t.k == "shop" || t.k == "sport" || t.k == "tourism" || t.k == "historic" || 
						(t.k == "waterway" && t.v == "dam") || (t.k == "waterway" && t.v == "waterfall") ||
						 (t.k == "amenity" && t.v == "bar") || (t.k == "amenity" && t.v == "cafe") ||
						 (t.k == "amenity" && t.v == "restaurant") || (t.k == "amenity" && t.v == "fast_food") ||
						 (t.k == "amenity" && t.v == "pub") || (t.k == "amenity" && t.v == "library") ||
						 (t.k == "amenity" && t.v == "university") || (t.k == "amenity" && t.v == "arts_centre") ||
						 (t.k == "amenity" && t.v == "fountain") || (t.k == "amenity" && t.v == "planetarium") ||
						 (t.k == "amenity" && t.v == "casino") || (t.k == "amenity" && t.v == "cinema") ||
						 (t.k == "amenity" && t.v == "theatre") || (t.k == "amenity" && t.v == "clock") ||
						 (t.k == "amenity" && t.v == "crypt") || (t.k == "amenity" && t.v == "place_of_worship") ||
						 (t.k == "amenity" && t.v == "townhall") || (t.k == "amenity" && t.v == "nightclub")||
						 (t.k == "building" && t.v == "hotel") || (t.k == "building" && t.v == "retail")||
						 (t.k == "building" && t.v == "cathedral") || (t.k == "building" && t.v == "chapel")||
						 (t.k == "building" && t.v == "church") || (t.k == "building" && t.v == "mosque")||
						 (t.k == "building" && t.v == "temple") || (t.k == "building" && t.v == "synagogue")||
						 (t.k == "building" && t.v == "shrine") || (t.k == "building" && t.v == "civic")||
						 (t.k == "building" && t.v == "stadium") || (t.k == "building" && t.v == "university")||
						 (t.k == "building" && t.v == "public") || (t.k == "building" && t.v == "bridge")||
						 (t.k == "building" && t.v == "ruins") ||
						 (t.k == "leisure" && t.v == "adult_gaming_center") || (t.k == "leisure" && t.v == "amusement_arcade")||
						 (t.k == "leisure" && t.v == "bandstand") || (t.k == "leisure" && t.v == "dance")||
						 (t.k == "leisure" && t.v == "firepit") || (t.k == "leisure" && t.v == "fishing")||
						 (t.k == "leisure" && t.v == "garden") || (t.k == "leisure" && t.v == "golf_course")||
						 (t.k == "leisure" && t.v == "ice_rink") || (t.k == "leisure" && t.v == "marina")||
						 (t.k == "leisure" && t.v == "nature_reserve") || (t.k == "leisure" && t.v == "park")||
						 (t.k == "leisure" && t.v == "pitch") || (t.k == "leisure" && t.v == "stadium")||
						 (t.k == "leisure" && t.v == "swimming_pool") || (t.k == "leisure" && t.v == "swimming_area")||
						 (t.k == "leisure" && t.v == "track") || (t.k == "leisure" && t.v == "water_park")||
						 (t.k == "leisure" && t.v == "wildlife_hide")
						 ){
					keep = true;
				}
			}
			if(keep){
				n.tags = (ArrayList<Tag>) intersection(n.tags, listeTag);
				try {
					st.executeUpdate("INSERT INTO information VALUES (" + n.id + ", " + n.lat + ", " + n.lon + ")");
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
	
    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }
	
	private void ajouteTag(Tag t, Node n){
		try {
			rs = st.executeQuery("SELECT id_cle FROM cle WHERE libelle = " + t.k);
			if(rs.next()){
				st.executeQuery("INSERT INTO tag VALUES (" + rs.getString(0) + ", " + n.id + ", " + t.v + ")");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

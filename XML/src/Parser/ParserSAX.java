package Parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



public class ParserSAX extends DefaultHandler{

	DB bdd;
	boolean dansNode = false;
	Node nodeCourant;
	
	@Override
	public void endDocument() throws SAXException {
		bdd.close();
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName == "node")
			bdd.ajouteNode(nodeCourant);
	}

	@Override
	public void startDocument() throws SAXException {
		//bdd = new DB("jdbc:mysql://127.0.0.1/application_android_projet", "root", "");
		bdd = new DB(ParserParam.bdd, ParserParam.id, ParserParam.mdp);
	}

	@Override
	public void startElement(String uri, String loclName, String qName, Attributes attributes) throws SAXException {
		if(qName == "node"){
			nodeCourant = new Node(Long.parseLong(attributes.getValue("id")), Double.parseDouble(attributes.getValue("lat")), Double.parseDouble(attributes.getValue("lon")));
		}
		if(qName == "tag"){
			nodeCourant.tags.add(new Tag(attributes.getValue("k"), attributes.getValue("v")));
		}
	}

}

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
		System.out.println("Terminé");
		System.out.println("Nombre de node parcouru : " + ParserParam.nbNode);
		System.out.println("Nombre de node conservé : " + ParserParam.nbNodeCons);
		System.out.println("Taux de conservation des nodes : " + ((float)ParserParam.nbNodeCons/(float)ParserParam.nbNode));
		System.out.println("Nombre de tag parcouru : " + ParserParam.nbTag);
		System.out.println("Nombre de tag conservé : " + ParserParam.nbTagCons);
		System.out.println("Taux de conservation des tags : " + ((float)ParserParam.nbTagCons/(float)ParserParam.nbTag));
		System.out.println("Temps d'execution : " + ((System.currentTimeMillis()-ParserParam.debut)/1000 + " secondes"));
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if(qName == "node")
			bdd.ajouteNode(nodeCourant);
	}

	@Override
	public void startDocument() throws SAXException {
		ParserParam.debut = System.currentTimeMillis();
		//bdd = new DB("jdbc:mysql://127.0.0.1/application_android_projet", "root", "");
		bdd = new DB(ParserParam.bdd, ParserParam.id, ParserParam.mdp);
	}

	@Override
	public void startElement(String uri, String loclName, String qName, Attributes attributes) throws SAXException {
		if(qName == "node"){
			ParserParam.nbNode++;
			nodeCourant = new Node(Long.parseLong(attributes.getValue("id")), Double.parseDouble(attributes.getValue("lat")), Double.parseDouble(attributes.getValue("lon")));
		}
		if(qName == "tag"){
			ParserParam.nbTag++;
			nodeCourant.tags.add(new Tag(attributes.getValue("k"), attributes.getValue("v")));
		}
	}

}

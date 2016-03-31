package Parser;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

public class Update {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
				SAXParserFactory factory = SAXParserFactory.newInstance();
				UpdateParser handler = new UpdateParser();
				try {
					SAXParser saxparseur = factory.newSAXParser();
					saxparseur.parse("update.osm", handler);
				} catch (ParserConfigurationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}

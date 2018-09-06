package pars;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class Executor {

	public static void main(String[] args) {

		String path = "/config/config.xml";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = Executor.class.getResourceAsStream(path);
			Document doc = db.parse(is);
			NodeList nl = doc.getElementsByTagName("bean");
			for(int i=0;i<nl.getLength();i++) {
				Node n= nl.item(i);
				if(n.getNodeType()==Node.ELEMENT_NODE) {
					NodeList nl2 = n.getChildNodes();
					for(int j=0;j<nl2.getLength();j++) {
						Node n2 = nl2.item(j);
						if(n2.getNodeType()==Node.ELEMENT_NODE) {
							System.out.println(n2.getNodeName());
							System.out.println(n2.getTextContent());
						}
					}
				}
			}
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package FuncionMain;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomParser {

	private String fileName;
	
	public DomParser(String fileName) {
		this.fileName = fileName;
	}
		
	public void parse() throws Exception {
		File inputDataFile = new File(fileName);
		DocumentBuilderFactory dbldrFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = dbldrFactory.newDocumentBuilder();
		Document docmt = docBuilder.parse(inputDataFile);
		docmt.getDocumentElement().normalize();
		
		int Total = 0;
		String S1;
		String S2;
		
		System.out.println("Name of the Root element:" + docmt.getDocumentElement().getNodeName());
	
		NodeList ndList = docmt.getElementsByTagName("country");

		for (int tempval = 0; tempval < ndList.getLength(); tempval++) {
	       Node nd = ndList.item(tempval);
	       System.out.println("\n Name of the current element :" + nd.getNodeName());
	       if (nd.getNodeType() == Node.ELEMENT_NODE) {
	           Element elemnt = (Element) nd;
	           System.out.println("Country ID : " + elemnt.getAttribute("coid"));
	           System.out.println("Female Population: " + elemnt
	                  .getElementsByTagName("Females").item(0).getTextContent());
	           System.out.println("Male Population: " + elemnt
	                  .getElementsByTagName("Males").item(0).getTextContent());
	           
	           S1 = elemnt.getElementsByTagName("Females").item(0).getTextContent();
	           S2 = elemnt.getElementsByTagName("Males").item(0).getTextContent();
	           
	           Total = Integer.parseInt(S1) + Integer.parseInt(S2);
	           
	           System.out.println("Total Population: " + Total);
	       }
		}
	}
}

package edu.nju.transportAssistant.xml;

import java.io.StringReader;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class IPInfoAnalyzer {

	public String analyse(String xmlString) {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new StringReader(xmlString));
			Element root = document.getRootElement();
			Iterator<?> rootIterator = root.elementIterator();
			rootIterator.next();
			Element placeElement = (Element) rootIterator.next();
			String place = placeElement.getStringValue();
			return place;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return "";
	}
}

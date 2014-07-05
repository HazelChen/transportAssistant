package edu.nju.transportAssistant.xml;

import java.io.StringReader;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class EmailXmlAnalyzer {
	
	
	
	public int analyse(String xmlString) {
		try {
			SAXReader saxReader = new SAXReader();
			Document document = saxReader.read(new StringReader(xmlString));
			Element root = document.getRootElement();
			String codeString = root.getStringValue();
			int code = Integer.parseInt(codeString);
			return code;
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

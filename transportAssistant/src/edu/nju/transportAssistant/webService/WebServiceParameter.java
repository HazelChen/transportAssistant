package edu.nju.transportAssistant.webService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WebServiceParameter {
	private String name;
	private String content;
	
	public WebServiceParameter(String name, String content) {
		this.name = name;
		try {
			this.content = URLEncoder.encode(content, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			this.content = content;
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}
}

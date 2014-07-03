package edu.nju.transportAssistant.webService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class WebServiceInvoker {
	private StringBuffer getUrlBuffer;
	
	public WebServiceInvoker(String url) {
		getUrlBuffer = new StringBuffer();
		getUrlBuffer.append(url);
		getUrlBuffer.append("?");
	}
	
	public void add(WebServiceParameter parameter) {
		getUrlBuffer.append(parameter.getName());
		getUrlBuffer.append("=");
		getUrlBuffer.append(parameter.getContent());
		getUrlBuffer.append("&");
	}
	
	public String invoke() {
		StringBuffer resultBuffer = new StringBuffer();
		InputStream inputStream = null;
		
		try {
			String urlString = getUrlBuffer.toString();
			System.out.println(urlString);
			URL url = new URL(urlString);
			inputStream = url.openStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				resultBuffer.append(tempString);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		String result = resultBuffer.toString();
		return result;
	}
	
	
}

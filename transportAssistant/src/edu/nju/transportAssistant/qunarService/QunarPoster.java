package edu.nju.transportAssistant.qunarService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class QunarPoster {

	public String post(String urlString) {
		StringBuffer resultBuffer = new StringBuffer();
		InputStream inputStream = null;
		
		try {
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

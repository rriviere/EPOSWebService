package com.myer.eposwebservice.batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Richard Riviere
 * @date 03/04/2013
 */
public abstract class AbstractJSONFowardBatch {

	private static final Log logger = LogFactory
			.getLog(AbstractJSONFowardBatch.class);
	
	public abstract String getRequestURI();
	public abstract String getFowardURI();
	 	 
	
	public void execute() {
		try { 
			String jsonResponse = sendRequest();
			
			
			fowardResponse(jsonResponse);
			
			
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	public String sendRequest() throws IOException {
		long startTime = System.currentTimeMillis();
		
		String requestURI = getRequestURI();
		URL url = new URL(requestURI);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
    	httpCon.setDoOutput(true);
    	httpCon.setRequestMethod("GET");
    	httpCon.setRequestProperty("Accept", "application/json");
    	
    	OutputStreamWriter out = new OutputStreamWriter(
    	httpCon.getOutputStream());
    	
    	int responseCode = httpCon.getResponseCode();
    	String responseMessage = httpCon.getResponseMessage();
    	
    	BufferedReader rd = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
    	StringBuffer sb = new StringBuffer();
    	String line = null;
    	while ((line = rd.readLine()) != null) {
    		sb.append(line);
    	}
    	rd.close();
    	
    	String jsonResponse = sb.toString(); 
    	
    	out.close();
    	httpCon.disconnect();  
    	long endTime = System.currentTimeMillis();
    	
		if (logger.isInfoEnabled()){
			logger.info("SEND," + requestURI + "," + (endTime - startTime) + 
					"," + responseCode + "," + responseMessage);				
		}
    	return jsonResponse;
	}
	
	public void fowardResponse(String jsonResponse) throws IOException{
		long startTime = System.currentTimeMillis();
		String fowardURI = getFowardURI();
		
    	URL url = new URL(getFowardURI());
    	HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
    	httpCon.setDoOutput(true);
    	httpCon.setRequestMethod("POST");
    	httpCon.setRequestProperty("Content-Type", "application/json");
		   		 
		OutputStream os = httpCon.getOutputStream();
		os.write(jsonResponse.getBytes());
		os.flush(); 
		
		int responseCode = httpCon.getResponseCode();
		String responseMessage = httpCon.getResponseMessage();
		
		httpCon.disconnect();    
		
		long endTime = System.currentTimeMillis();
		if (logger.isInfoEnabled()){
			logger.info("FOWARD," + fowardURI + "," + (endTime - startTime) + 
					"," + responseCode + "," + responseMessage);				
		}		
	}		
}

package com.abdullah.khan.cblpg.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdullah.khan.cblpg.util.UrlEndPoint;

@Service
public class RequestApplicationTypeUrlEncoded  {

	@Autowired
	UrlEndPoint urlEndPoint;

	//@Override
	public String sendXmlRequest(String objectToXml) throws Exception {

		// replaceFirstCharacterOfVariableNameWithCapitalLetter
		String changeVarName = replaceFirstCharacterOfVariableNameWithCapitalLetter(objectToXml);

		// Encode the query
		String encodedQuery = URLEncoder.encode(changeVarName, "UTF-8");
		// This is the data that is going to be send to itcuties.com via POST request
		// 'e' parameter contains data to echo
		String postData = "e=" + encodedQuery;
		
		// Connect to google.com
		URL url = new URL(urlEndPoint.getURL());

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		connection.setRequestProperty("Content-Length", String.valueOf(postData.length()));
		
		// Write data
		OutputStream os = connection.getOutputStream();
		os.write(postData.getBytes());

		// Read response
		StringBuilder responseSB = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		String line;
		while ((line = br.readLine()) != null)
			responseSB.append(line);

		// Close streams
		br.close();
		os.close();

		return responseSB.toString();
		
	}

	private String replaceFirstCharacterOfVariableNameWithCapitalLetter(String objectToXml) {
		return objectToXml.replaceAll("language", "Language").replaceAll("order", "Order").replaceAll("uRL", "URL")
				.replaceAll("orderType", "OrderType").replaceAll("merchant", "Merchant").replaceAll("amount", "Amount")
				.replaceAll("currency", "Currency").replaceAll("description", "Description")
				.replaceAll("approveURL", "ApproveURL").replaceAll("cancelURL", "CancelURL")
				.replaceAll("declineURL", "DeclineURL").replaceAll("orderID", "OrderID")
				.replaceAll("operation", "Operation").replaceAll("request", "Request").replaceAll("Tkkpg", "TKKPG");
	}

}

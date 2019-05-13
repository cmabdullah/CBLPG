package com.abdullah.khan.cblpg.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abdullah.khan.cblpg.service.RequestService;
import com.abdullah.khan.cblpg.util.UrlEndPoint;
@Service
public class RequestApplicationTypeTextByXml implements RequestService {
	
	@Autowired
	UrlEndPoint urlEndPoint;
	
	@Override
	public String sendXmlRequest(String objectToXml) throws Exception {
		
		//replaceFirstCharacterOfVariableNameWithCapitalLetter
		String changeVarName = replaceFirstCharacterOfVariableNameWithCapitalLetter(objectToXml);
		
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(urlEndPoint.getURL());
		HttpEntity stringEntity = new StringEntity(changeVarName, ContentType.TEXT_XML);
		httpPost.setEntity(stringEntity);
		CloseableHttpResponse response = httpclient.execute(httpPost);
		//System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line);
		}
		//System.out.println("Response body if exist : " + result.toString());
		return result.toString();
	}

	private String replaceFirstCharacterOfVariableNameWithCapitalLetter(String objectToXml) {
		return objectToXml.replaceAll("language", "Language").replaceAll("order", "Order").replaceAll("uRL", "URL")
				.replaceAll("orderType", "OrderType").replaceAll("merchant", "Merchant").replaceAll("amount", "Amount")
				.replaceAll("currency", "Currency").replaceAll("description", "Description")
				.replaceAll("approveURL", "ApproveURL").replaceAll("cancelURL", "CancelURL")
				.replaceAll("declineURL", "DeclineURL").replaceAll("orderID", "OrderID")
				.replaceAll("operation", "Operation")
				.replaceAll("request", "Request")
				.replaceAll("Tkkpg", "TKKPG");
	}

}

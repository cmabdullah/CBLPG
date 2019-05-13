package com.abdullah.khan.cblpg.service.impl;

import org.springframework.stereotype.Service;

import com.abdullah.khan.cblpg.service.ResponseService;
@Service
public class ResponseServiceImpl implements ResponseService {
	

	
	@Override
	public String filterXmlResponse(String xmlResponse) {
		String response = xmlResponse.substring(xmlResponse.indexOf("<Response>"), ((xmlResponse.indexOf("</Response>")) + 11));
		return  response
				.replaceAll("Order", "order")
				.replaceAll("URL", "uRL")
				.replaceAll("SessionID", "sessionID")
				.replaceAll("OrderID", "orderID")
				.replaceAll("Operation", "operation")
				.replaceAll("Status", "status");
	}
}

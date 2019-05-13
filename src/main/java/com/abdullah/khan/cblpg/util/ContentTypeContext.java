package com.abdullah.khan.cblpg.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.abdullah.khan.cblpg.service.RequestService;
@Component
public class ContentTypeContext {
	@Autowired
	RequestService requestService;

	public RequestService getRequestService() {
		return requestService;
	}

	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}
	
	public String sendXmlRequest(String value) throws Exception {

		return requestService.sendXmlRequest(value);
	
   }
	
	
	
	
	
}

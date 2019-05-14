package com.abdullah.khan.cblpg.service;

import org.springframework.stereotype.Component;

@Component
public interface RequestService {
	
	public String sendXmlRequest(String objectToXml) throws Exception;
	
}
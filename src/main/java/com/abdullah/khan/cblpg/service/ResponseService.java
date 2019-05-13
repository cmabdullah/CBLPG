package com.abdullah.khan.cblpg.service;

import org.springframework.stereotype.Component;

import com.abdullah.khan.cblpg.model.Request;

@Component
public interface ResponseService {

	public String filterXmlResponse(String xmlResponse);
		
}
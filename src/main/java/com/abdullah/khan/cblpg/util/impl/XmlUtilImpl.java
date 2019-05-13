package com.abdullah.khan.cblpg.util.impl;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.abdullah.khan.cblpg.model.Message;
import com.abdullah.khan.cblpg.model.Request;
import com.abdullah.khan.cblpg.model.Response;
import com.abdullah.khan.cblpg.model.Tkkpg;
import com.abdullah.khan.cblpg.util.XmlUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
@Service
public class XmlUtilImpl implements XmlUtil {
	@Override
	public String convertObjectToXml(Tkkpg tkkpg) throws JsonProcessingException {
		ObjectMapper objectMapper = new XmlMapper();
		
		return objectMapper.writeValueAsString(tkkpg);
	}

	@Override
	public Response convertXmlToTkkpgObject(String filterXmlResponse) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new XmlMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.readValue(filterXmlResponse, Response.class);
        
        //System.out.println("Response tostring : "+ response.toString());
	}

	@Override
	public Message convertXmlToMessageObject(String xmlmsg) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper objectMapper = new XmlMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper.readValue(xmlmsg, Message.class);
	}
}

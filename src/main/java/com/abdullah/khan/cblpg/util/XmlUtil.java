package com.abdullah.khan.cblpg.util;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.abdullah.khan.cblpg.model.Message;
import com.abdullah.khan.cblpg.model.Response;
import com.abdullah.khan.cblpg.model.Tkkpg;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Component
public interface XmlUtil {

	public String convertObjectToXml(Tkkpg tkkpg) throws Exception;

	public Response convertXmlToTkkpgObject(String filterXmlResponse) throws JsonParseException, JsonMappingException, IOException;

	public Message convertXmlToMessageObject(String xmlmsg) throws JsonParseException, JsonMappingException, IOException;

}
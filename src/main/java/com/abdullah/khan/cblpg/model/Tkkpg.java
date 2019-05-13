package com.abdullah.khan.cblpg.model;

public class Tkkpg {
	
	private Request request;
	
	private Response response;

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Tkkpg() {
		
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}

	public Tkkpg(Request request, Response response) {
		super();
		this.request = request;
		this.response = response;
	}

	@Override
	public String toString() {
		return "Tkkpg [request=" + request + ", response=" + response + "]";
	}

	
	
	

}

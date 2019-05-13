package com.abdullah.khan.cblpg.model;

public class Request {
	private String operation;
	private String language;
	private Order order;
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Request() {
		
	}
	public Request(String operation, String language, Order order) {
		super();
		this.operation = operation;
		this.language = language;
		this.order = order;
	}
	@Override
	public String toString() {
		return "Request [operation=" + operation + ", language=" + language + ", order=" + order + "]";
	}

	
}

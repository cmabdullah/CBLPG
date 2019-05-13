package com.abdullah.khan.cblpg.model;

public class Response {
	private String operation;
	private String status;
	private Order order;
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Response() {
		
	}
	public Response(String operation, String status, Order order) {
		
		this.operation = operation;
		this.status = status;
		this.order = order;
	}
	@Override
	public String toString() {
		return "Response [operation=" + operation + ", status=" + status + ", order=" + order + "]";
	}
	
	
	
}

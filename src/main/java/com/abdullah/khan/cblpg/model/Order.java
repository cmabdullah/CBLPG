package com.abdullah.khan.cblpg.model;

public class Order {

	//response
	private String orderID;
	private String sessionID;
	//default
	private String orderType;
	
	private String merchant;
	private double amount;
	private String currency;
	private String description;
	
	private String approveURL;
	private String cancelURL;
	private String declineURL;
	
	private String uRL;
	private String OrderStatus;
	
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getApproveURL() {
		return approveURL;
	}
	public void setApproveURL(String approveURL) {
		this.approveURL = approveURL;
	}
	public String getCancelURL() {
		return cancelURL;
	}
	public void setCancelURL(String cancelURL) {
		this.cancelURL = cancelURL;
	}
	public String getDeclineURL() {
		return declineURL;
	}
	public void setDeclineURL(String declineURL) {
		this.declineURL = declineURL;
	}
	
	public String getuRL() {
		return uRL;
	}
	public void setuRL(String uRL) {
		this.uRL = uRL;
	}
	
	
	public String getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		OrderStatus = orderStatus;
	}
	public Order() {
		
	}
	public Order(String orderID, String sessionID, String orderType, String merchant, double amount, String currency,
			String description, String approveURL, String cancelURL, String declineURL, String uRL,
			String orderStatus) {
		super();
		this.orderID = orderID;
		this.sessionID = sessionID;
		this.orderType = orderType;
		this.merchant = merchant;
		this.amount = amount;
		this.currency = currency;
		this.description = description;
		this.approveURL = approveURL;
		this.cancelURL = cancelURL;
		this.declineURL = declineURL;
		this.uRL = uRL;
		OrderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", sessionID=" + sessionID + ", orderType=" + orderType + ", merchant="
				+ merchant + ", amount=" + amount + ", currency=" + currency + ", description=" + description
				+ ", approveURL=" + approveURL + ", cancelURL=" + cancelURL + ", declineURL=" + declineURL + ", uRL="
				+ uRL + ", OrderStatus=" + OrderStatus + "]";
	}
	
	
}

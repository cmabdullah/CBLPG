package com.abdullah.khan.cblpg.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Message {
	// response
	@JsonProperty("OrderID")
	private String orderID;
	@JsonProperty("PurchaseAmount")
	private double purchaseAmount;
	@JsonProperty("OrderStatus")
	private String orderStatus;
	@JsonProperty("SessionID")
	private String sessionID;
	@JsonProperty("SessionId")
	private String sessionId;
	@JsonProperty("TransactionType")
	private String transactionType;
	@JsonProperty("OrderDescription")
	private String orderDescription;
	@JsonProperty("PurchaseAmountScr")
	private double purchaseAmountScr;
	@JsonProperty("TotalAmount")
	private double totalAmount;
	@JsonProperty("TotalAmountScr")
	private double totalAmountScr;
	@JsonProperty("FeeScr")
	private double feeScr;
	@JsonProperty("AcqFee")
	private double acqFee;
	@JsonProperty("AcqFeeScr")
	private double acqFeeScr;
	@JsonProperty("CurrencyScr")
	private String currencyScr;
	@JsonProperty("TranDateTime")
	private String tranDateTime;
	@JsonProperty("OrderStatusScr")
	private String orderStatusScr;
	@JsonProperty("RezultOperation")
	private String rezultOperation;
	@JsonProperty("ShopName")
	private String shopName;
	@JsonProperty("Currency")
	private String currency;
	@JsonProperty("ResponseCode")
	private String responseCode;
	@JsonProperty("Version")
	private String version;
	@JsonProperty("Language")
	private String language;
	//@JsonProperty("date")
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public double getPurchaseAmount() {
		return purchaseAmount;
	}
	public void setPurchaseAmount(double purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getSessionID() {
		return sessionID;
	}
	public void setSessionID(String sessionID) {
		this.sessionID = sessionID;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}
	public double getPurchaseAmountScr() {
		return purchaseAmountScr;
	}
	public void setPurchaseAmountScr(double purchaseAmountScr) {
		this.purchaseAmountScr = purchaseAmountScr;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getTotalAmountScr() {
		return totalAmountScr;
	}
	public void setTotalAmountScr(double totalAmountScr) {
		this.totalAmountScr = totalAmountScr;
	}
	public double getFeeScr() {
		return feeScr;
	}
	public void setFeeScr(double feeScr) {
		this.feeScr = feeScr;
	}
	public double getAcqFee() {
		return acqFee;
	}
	public void setAcqFee(double acqFee) {
		this.acqFee = acqFee;
	}
	public double getAcqFeeScr() {
		return acqFeeScr;
	}
	public void setAcqFeeScr(double acqFeeScr) {
		this.acqFeeScr = acqFeeScr;
	}
	public String getCurrencyScr() {
		return currencyScr;
	}
	public void setCurrencyScr(String currencyScr) {
		this.currencyScr = currencyScr;
	}
	public String getTranDateTime() {
		return tranDateTime;
	}
	public void setTranDateTime(String tranDateTime) {
		this.tranDateTime = tranDateTime;
	}
	public String getOrderStatusScr() {
		return orderStatusScr;
	}
	public void setOrderStatusScr(String orderStatusScr) {
		this.orderStatusScr = orderStatusScr;
	}
	public String getRezultOperation() {
		return rezultOperation;
	}
	public void setRezultOperation(String rezultOperation) {
		this.rezultOperation = rezultOperation;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Message() {
		
	}
	public Message(String orderID, double purchaseAmount, String orderStatus, String sessionID, String sessionId,
			String transactionType, String orderDescription, double purchaseAmountScr, double totalAmount,
			double totalAmountScr, double feeScr, double acqFee, double acqFeeScr, String currencyScr,
			String tranDateTime, String orderStatusScr, String rezultOperation, String shopName, String currency,
			String responseCode, String version, String language, String date) {
		super();
		this.orderID = orderID;
		this.purchaseAmount = purchaseAmount;
		this.orderStatus = orderStatus;
		this.sessionID = sessionID;
		this.sessionId = sessionId;
		this.transactionType = transactionType;
		this.orderDescription = orderDescription;
		this.purchaseAmountScr = purchaseAmountScr;
		this.totalAmount = totalAmount;
		this.totalAmountScr = totalAmountScr;
		this.feeScr = feeScr;
		this.acqFee = acqFee;
		this.acqFeeScr = acqFeeScr;
		this.currencyScr = currencyScr;
		this.tranDateTime = tranDateTime;
		this.orderStatusScr = orderStatusScr;
		this.rezultOperation = rezultOperation;
		this.shopName = shopName;
		this.currency = currency;
		this.responseCode = responseCode;
		this.version = version;
		this.language = language;
		this.date = date;
	}
	
	@Override
	public String toString() {
		return "Message [orderID=" + orderID + ", purchaseAmount=" + purchaseAmount + ", orderStatus=" + orderStatus
				+ ", sessionID=" + sessionID + ", sessionId=" + sessionId + ", transactionType=" + transactionType
				+ ", orderDescription=" + orderDescription + ", purchaseAmountScr=" + purchaseAmountScr
				+ ", totalAmount=" + totalAmount + ", totalAmountScr=" + totalAmountScr + ", feeScr=" + feeScr
				+ ", acqFee=" + acqFee + ", acqFeeScr=" + acqFeeScr + ", currencyScr=" + currencyScr + ", tranDateTime="
				+ tranDateTime + ", orderStatusScr=" + orderStatusScr + ", rezultOperation=" + rezultOperation
				+ ", shopName=" + shopName + ", currency=" + currency + ", responseCode=" + responseCode + ", version="
				+ version + ", language=" + language + ", date=" + date + "]";
	}	
}
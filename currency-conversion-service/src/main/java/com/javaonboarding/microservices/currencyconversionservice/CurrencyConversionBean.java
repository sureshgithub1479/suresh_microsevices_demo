package com.javaonboarding.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConversionBean {
	private long id;
	private String  from;
	private String  to;
	private BigDecimal  conversionMutiple;
	private BigDecimal  quantity;
	private BigDecimal  totalCalculatedAmount;
	
	private int port;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public BigDecimal getConversionMutiple() {
		return conversionMutiple;
	}

	public void setConversionMutiple(BigDecimal conversionMutiple) {
		this.conversionMutiple = conversionMutiple;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}

	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public CurrencyConversionBean(long id, String from, String to, BigDecimal conversionMutiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMutiple = conversionMutiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
		this.port = port;
	}

	public CurrencyConversionBean() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
}

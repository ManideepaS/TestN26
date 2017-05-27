package com.trade.report.entity;

import java.util.Date;

public class TradeTO {
	private String entityName;
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public double getAgreedFx() {
		return agreedFx;
	}
	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}
	public String getCurrency() {
		return Currency;
	}
	public void setCurrency(String currency) {
		Currency = currency;
	}
	public Date getInstructionDate() {
		return instructionDate;
	}
	public void setInstructionDate(Date instructionDate) {
		this.instructionDate = instructionDate;
	}
	public Date getSettlementDate() {
		return SettlementDate;
	}
	public void setSettlementDate(Date settlementDate) {
		SettlementDate = settlementDate;
	}
	public int getUnits() {
		return units;
	}
	public void setUnits(int units) {
		this.units = units;
	}
	public double getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	private String option;
	private double agreedFx;
	private String Currency;
	private Date instructionDate;
	private Date SettlementDate;
	private int units;
	private double pricePerUnit;
	private double totalPrice;
}

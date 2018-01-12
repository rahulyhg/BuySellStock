package com.stock.exchange;

public class OutPutFormat {

	private int sellOrderId;
	private int buyOrderId;
	private int qty;
	private double price;
	
	public OutPutFormat(int sellOrderId, int buyOrderId, int qty, double price) {
		this.sellOrderId = sellOrderId;
		this.buyOrderId = buyOrderId;
		this.qty = qty;
		this.price = price;
	}
	
	
	public int getSellOrderId() {
		return sellOrderId;
	}
	public void setSellOrderId(int sellOrderId) {
		this.sellOrderId = sellOrderId;
	}
	public int getBuyOrderId() {
		return buyOrderId;
	}
	public void setBuyOrderId(int buyOrderId) {
		this.buyOrderId = buyOrderId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
}

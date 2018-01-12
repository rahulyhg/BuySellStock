package com.stock.core;

public class Stock {

		private String company;
		private int qty;
		private int hour;
		private int min;
		private int orderId;
		private Double price;
		
		public Stock(String company, int  qty, int hour, int min,int orderId,double price) {
			this.company = company;
			this.qty = qty;
			this.hour = hour;
			this.min = min;
			this.orderId = orderId;
			this.price = price;
		}
		
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public int getQty() {
			return qty;
		}
		public void setQty(int qty) {
			this.qty = qty;
		}
		public Integer getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public Integer getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
		
}

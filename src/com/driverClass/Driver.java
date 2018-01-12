package com.driverClass;

import java.util.ArrayList;
import java.util.List;

import com.stock.core.Buy;
import com.stock.core.Sell;
import com.stock.exchange.OutPutFormat;
import com.stock.exchange.StockExchangeCore;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	/*	StockExchangeCore stockExchangeCore = new StockExchangeCore();
		Buy buy = createBuyOrder(1,9,45,"FK","Buy",100,50);
		List<OutPutFormat> outputFormat = new ArrayList<>();
		stockExchangeCore.processBuyStock(buy,outputFormat);
		printOutput(outputFormat);
		
		
		buy = createBuyOrder(2,9,40,"FK","Buy",50,100);
		 outputFormat = new ArrayList<>();
		stockExchangeCore.processBuyStock(buy,outputFormat);
		printOutput(outputFormat);
		
		
		
		Sell sell = createSellOrder(3,10,00,"FK","Sell",150,10);
		stockExchangeCore.addSellStock(sell);
		
		
		buy = createBuyOrder(4,10,15,"FK","Buy",50,15);
		 outputFormat = new ArrayList<>();
		stockExchangeCore.processBuyStock(buy,outputFormat);
		printOutput(outputFormat); */
		
		
	/*	
		StockExchangeCore stockExchangeCore = new StockExchangeCore();
		
		Sell sell = createSellOrder(1,9,40,"FK","Sell",50,195.45);
		stockExchangeCore.addSellStock(sell);
		
		
		sell = createSellOrder(2,9,40,"FK","Sell",50,195.45);
		stockExchangeCore.addSellStock(sell);
		
		
		Buy buy = createBuyOrder(3,9,45,"FK","Buy",50,200);
		List<OutPutFormat> outputFormat = new ArrayList<>();
		stockExchangeCore.processBuyStock(buy,outputFormat);
		printOutput(outputFormat);
		
		
		
		*/
		List<OutPutFormat> outputFormat = new ArrayList<>();
	

		StockExchangeCore stockExchangeCore = new StockExchangeCore();
		Sell sell = createSellOrder(1,9,45,"FK","Sell",100,240.10);
		stockExchangeCore.addSellStock(sell);
		sell = createSellOrder(2,9,45,"FK","Sell",90,237.45);
		stockExchangeCore.addSellStock(sell);
		
			
		printOutput(outputFormat);
		
		sell = createSellOrder(5,9,48,"FK","Sell",220,241.50);
		stockExchangeCore.addSellStock(sell);
		
		Buy buy = createBuyOrder(6,9,49,"FK","Buy",50,238.50);
		outputFormat = new ArrayList<>();
		stockExchangeCore.processBuyStock(buy,outputFormat);
		
		printOutput(outputFormat);
		
		
		sell = createSellOrder(8,10,01,"FK","Sell",20,240.10);
		stockExchangeCore.addSellStock(sell);
		
		buy = createBuyOrder(9,10,02,"FK","Buy",150,242.70);
		outputFormat = new ArrayList<>();
		stockExchangeCore.processBuyStock(buy,outputFormat);
		
		printOutput(outputFormat);
		
		
		System.out.println("Customer details");
		
		stockExchangeCore.getCustomerDetails();
		
	}

	private static void printOutput(List<OutPutFormat> output) {
		// TODO Auto-generated method stub
		for(OutPutFormat outputf: output) {
			
			System.out.println(outputf.getSellOrderId() + " " + outputf.getBuyOrderId() + " " + outputf.getQty() + " " + outputf.getPrice());
			
		}
		
		if(output.size() == 0) {
		System.out.println("No stocks");
		}
	}

	private static Sell createSellOrder(int orderID, int hour, int min, String companyName, String string3, int qty, double price) {
		// TODO Auto-generated method stub
		return new Sell(companyName, qty, hour, min, orderID, price);
	}
	
	private static Buy createBuyOrder(int orderID, int hour, int min, String companyName, String string3, int qty, double price) {
		// TODO Auto-generated method stub
		
		return new Buy(companyName, qty, hour, min, orderID, price);
	}

}

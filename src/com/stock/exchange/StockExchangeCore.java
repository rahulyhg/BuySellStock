package com.stock.exchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import com.customer.Customer;
import com.stock.core.Buy;
import com.stock.core.PriorityQueueComparators;
import com.stock.core.Sell;

public class StockExchangeCore {

	private Map<String, Queue<Sell>> stockSell = new HashMap<>();

	Customer customer = new Customer();
	
	
	public void addSellStock(Sell sellObject) {
		Queue<Sell> sellPriorityQueue;
		if(stockSell.containsKey(sellObject.getCompany())) {
			sellPriorityQueue = stockSell.get(sellObject.getCompany());
			sellPriorityQueue.add(sellObject);
			
		} else {
			sellPriorityQueue = new PriorityQueue<Sell>(PriorityQueueComparators.idComparator);
			sellPriorityQueue.add(sellObject);
			stockSell.put(sellObject.getCompany(), sellPriorityQueue);
		}
		stockSell.put(sellObject.getCompany(), sellPriorityQueue);
		
	}
	
	public List<OutPutFormat> processBuyStock(Buy buy, List<OutPutFormat> outputFormat) {
		if(!stockSell.containsKey(buy.getCompany())) {
			return null;
		}
		
		Queue<Sell> sellorders = stockSell.get(buy.getCompany());
		// List<OutPutFormat> outputFormat = new ArrayList<>();
		 
		if(sellorders.size() > 0) {
		
		Sell sellOrder = sellorders.peek();
		
		if(sellOrder.getPrice() <= buy.getPrice())  {
			
			sellOrder = sellorders.poll();
			
			Sell sellOrder2 = sellorders.peek();
			
			if(sellOrder.getPrice().equals(sellOrder2.getPrice()) && sellOrder.getHour().equals(sellOrder2.getHour()) 
					&&  sellOrder.getMin().equals(sellOrder2.getMin())) {
				sellorders.add(sellOrder);
				stockSell.put(sellOrder.getCompany(), sellorders);
				processMultipleTogether( buy, buy.getCompany(), outputFormat);
			} else {
			
			
		OutPutFormat outformat;
		boolean less = false;
		boolean more = false;
	
		if(sellOrder.getQty() >  buy.getQty()) {
			
			 outformat = new OutPutFormat(sellOrder.getOrderId(), buy.getOrderId(), buy.getQty(), sellOrder.getPrice());
			 outputFormat.add(outformat);
			 more = true;
			 customer.addStock(sellOrder.getCompany(), sellOrder.getPrice(),  buy.getQty());
			
			//sellorders.add(e);
		} else if (sellOrder.getQty() <  buy.getQty()) {
			 outformat = new OutPutFormat(sellOrder.getOrderId(), buy.getOrderId(), sellOrder.getQty(), sellOrder.getPrice());
			 outputFormat.add(outformat);
			 buy.setQty(buy.getQty() - sellOrder.getQty());
			 System.out.println("The order got partially fullfilled by  orderID " + sellOrder.getOrderId());
			 customer.addStock(sellOrder.getCompany(), sellOrder.getPrice(), sellOrder.getQty());
			 processBuyStock(buy, outputFormat);
			
		} else {
			 outformat = new OutPutFormat(sellOrder.getOrderId(), buy.getOrderId(), buy.getQty(), sellOrder.getPrice());
			 outputFormat.add(outformat);
			 System.out.println("The order got completely fullfilled by orderID " + sellOrder.getOrderId());
			 customer.addStock(sellOrder.getCompany(), sellOrder.getPrice(), sellOrder.getQty());
		}
		
		if(more) {
			sellOrder.setQty(sellOrder.getQty() - buy.getQty());
			sellorders.add(sellOrder);
			stockSell.put(sellOrder.getCompany(), sellorders);
			System.out.println("The order got completely fullfilled by orderID " + sellOrder.getOrderId());
			return outputFormat;
		} 
			}
		}
		} else {
			return outputFormat;
		}
		
		return outputFormat;
		
	}

	
	private void processMultipleTogether(Buy buy, String company, List<OutPutFormat> outputFormat) {
		// TODO Auto-generated method stub
		OutPutFormat outformat;
		int totalsum = 0;
		List<Sell> listOfAllSellOrders = new ArrayList<>();
		
		Queue<Sell> sellorders = stockSell.get(company);
		
		Sell sellOrder = sellorders.poll();
		listOfAllSellOrders.add(sellOrder);
		
		totalsum = totalsum + sellOrder.getQty();
		
		
		Sell sellOrder2 = sellorders.peek();
		
		while((sellorders.size() > 0) && sellOrder.getPrice().equals(sellOrder2.getPrice()) && sellOrder.getHour().equals(sellOrder2.getHour()) 
				&&  sellOrder.getMin().equals(sellOrder2.getMin())) {
			
			listOfAllSellOrders.add(sellOrder2);
			totalsum = totalsum + sellOrder2.getQty();
			sellOrder = sellOrder2;
			
			if(sellorders.size() > 0) {
			sellOrder2 = sellorders.poll();
			} else {
				break;
			}
			
		}
		
		int buyQtn = buy.getQty();
		int buyQtnOri = buy.getQty();
		for(Sell sellers : listOfAllSellOrders) {
			
			if(buyQtn > 0) {
				
				float portion = sellers.getQty() / totalsum;
				
				int stocksTobePurchased = (int)(portion * buyQtnOri);
				buyQtn = buyQtn - stocksTobePurchased;
				
				
				outformat = new OutPutFormat(sellers.getOrderId(), buy.getOrderId(), stocksTobePurchased, sellers.getPrice());
				outputFormat.add(outformat);
				sellers.setQty(sellOrder.getQty() - stocksTobePurchased);
				buy.setQty(buy.getQty() - stocksTobePurchased);
				customer.addStock(sellOrder.getCompany(), sellOrder.getPrice(),  buy.getQty());
				
				
				
			} else {
				break;
			}
			
			
		}
		
		for(Sell sellers : listOfAllSellOrders) {
			sellorders.add(sellers);
		}
		
		
		stockSell.put(sellOrder.getCompany(), sellorders);
		
		
		
		
		
		
		
		
		
	}

	public void getCustomerDetails() {
		customer.getAllDetailss();
	}
	
	
	
	
}

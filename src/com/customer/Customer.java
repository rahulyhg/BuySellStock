package com.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Customer {
	
	Map<String, ArrayList<Double>> buyDetails= new HashMap<>();
	
	Map<String, ArrayList<Integer>> totalDetails = new  HashMap<>();
	
	
	public void addStock(String stockName, double price, int qty) {
		
		ArrayList<Double> allStocks;
		ArrayList<Integer> totalDetailsIndi;
		if(buyDetails.containsKey(stockName)) {
			allStocks =buyDetails.get(stockName);
			allStocks.add(price);
			
			
			totalDetailsIndi = totalDetails.get(stockName);
			totalDetailsIndi.add(qty);
			
			
		} else {
			allStocks = new ArrayList<Double>();
			allStocks.add(price);
			
			
			totalDetailsIndi = new ArrayList<Integer>();
			totalDetailsIndi.add(qty);
		}
		
		buyDetails.put(stockName, allStocks);
		
		totalDetails.put(stockName, totalDetailsIndi);
	}
	
	public int getTotalNumberOfStocks(String stockName) {
		
		
		ArrayList<Integer> arrayList = totalDetails.get(stockName);
		int sum =0 ;
		for(int val : arrayList ) {
			sum = sum + val;
		}
		
		
		return sum;
	}
	
	
	public int getTotal(ArrayList<Double> arrayList,  ArrayList<Double> list) {
		
		 ArrayList<Double> coll = list;
		
		 
		 
		return coll.size();
		
	}
	
	
	public Double getMin(ArrayList<Double> list, ArrayList<Double> arrayList) {
		
		 ArrayList<Double> coll = list;
		 Collections.sort(coll);
		return coll.get(0);
		
	}
	
	public Double getMax(ArrayList<Double> arrayList,  ArrayList<Double> list) {
		 ArrayList<Double> coll = list;
		 Collections.sort(coll);
		
		return coll.get(coll.size()-1);
		
	}
	
	public Double getAvg(String stockName) {
		
		
		return 0.0;
		
	}
	
	public void getAllDetailss() {
		
		for(Map.Entry<String, ArrayList<Double>> entry : buyDetails.entrySet()) {
			
			System.out.println("Stock Name : "  +  entry.getKey());
			System.out.println("Total Stock purchase : "  +  getTotal(entry.getValue(), entry.getValue()));
			System.out.println("Min buying price : "  +  getMin(entry.getValue(), entry.getValue()));
			System.out.println("Max buying price : "  +  getMax(entry.getValue(), entry.getValue()));
			System.out.println("getTotalStockNumber : "  +  getTotalNumberOfStocks(entry.getKey()));
			
		}
		
		
	}
}

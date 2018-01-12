package com.stock.core;

import java.util.Comparator;



public class PriorityQueueComparators {

	
public static Comparator<Sell> idComparator = new Comparator<Sell>(){
		
		@Override
		public int compare(Sell stock1, Sell stock2) {
			    int price = stock1.getPrice().compareTo(stock2.getPrice());
		        int timeStampHour = stock1.getHour().compareTo(stock2.getHour());
		        int timeStampMin = stock1.getMin().compareTo(stock2.getMin());
		 
		        // 3-level comparison using if-else block
		        if(price == 0) {
		            return ((timeStampHour == 0) ? timeStampMin : timeStampHour);
		        }
		        else {
		            return price;
		        }
        }
	};
}

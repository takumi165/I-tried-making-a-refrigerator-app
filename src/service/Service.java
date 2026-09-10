package service;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Stock;
import util.InputUtil;

public class Service { 

		ArrayList<Stock> stocks = new ArrayList<Stock>();
		
		public void addStock() {
			stocks.add(new Stock(1, InputUtil.InputName(), 4, LocalDate.now(), InputUtil.inputLocalDate()));
			for (Stock stock : stocks) {
				System.out.println(stock);
			}
		}
		
		public void increasesID() {
			
		}
	
	
}

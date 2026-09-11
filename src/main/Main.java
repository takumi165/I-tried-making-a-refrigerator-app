package main;

import service.Service;
import util.InputUtil;

public class Main {

	public static void main(String[] args) {
		Service crud = new Service();
		
		crud.loadStocks();;
		crud.showStocks();
		
		while (true) {
			int command = InputUtil.InputInt();
			if (command == 1) {
				crud.addStock();
				System.out.println("#1");
			} else if (command == 2) {
				crud.showStocks();
				System.out.println("#2");
			} else if (command == 3) {
				//crud.test();
				System.out.println("#3");
			} 
			
		}
	}

}

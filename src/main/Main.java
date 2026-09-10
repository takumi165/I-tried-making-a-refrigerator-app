package main;

import service.Service;

public class Main {

	public static void main(String[] args) {
		
		Service serice = new Service();
		serice.addStock();
		
		/*while (true) {
			
			String command = InputUtil.InputString();
			if (command == 1) {
				System.out.println("#1");
			} else if (command == 2) {
				System.out.println("#2");
			} else if (command == 3) {
				System.out.println("#3");
			} else if (command == 0) {
				System.out.println("無効な数値です");
			} else if (command == -1) {
				System.out.println("数字を入力してください");
			}
			
		}*/
	}

}

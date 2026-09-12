package main;

import service.Service;
import util.InputUtil;

public class Main {

	public static void main(String[] args) {
		Service crud = new Service();
		
		crud.loadStocks();
		showMenu();
		System.out.println(crud.increasesID());
		
		while (true) {
			System.out.print("command> ");
			int command = InputUtil.InputInt();
			
			if (command == 1) {
				crud.addStock();
				System.out.println("#1");
			} else if (command == 2) {
				crud.showStocks();
				System.out.println("#2");
			} else if (command == 3) {
				crud.saveFile();
				System.out.println("#3");
			} 
			
		}
	}
	
	public static void showMenu() {
		System.out.println("=====Menu=====");
		System.out.println("1:在庫データを追加");
		System.out.println("2:一覧を表示");
		System.out.println("3:データを編集");
		System.out.println("4:データの削除\n");
	}

}

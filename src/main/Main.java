package main;

import service.Service;
import util.InputUtil;

public class Main {

	public static void main(String[] args) {
		Service crud = new Service();
		
		crud.loadStocks();
		showMenu();

		
		while (true) {
			System.out.print("command> ");
			int command = InputUtil.InputInt();
			
			if (command == 1) {
				crud.addStock();
				crud.saveFile();
				System.out.println("#1\n");
			} else if (command == 2) {
				crud.showStocks();
				System.out.println("#2");
			} else if (command == 3) {
				crud.updateStock();
				System.out.println("#3");
			} else if (command == 4) {
				crud.deleteData();
				System.out.println("#4");
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

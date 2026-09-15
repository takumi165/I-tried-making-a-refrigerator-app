package main;

import service.Service;
import util.InputUtil;

public class Main {

	public static void main(String[] args) {
		Service crud = new Service();
		
		crud.loadStocks();
		
		while (true) {
			showMenu();
			System.out.print("command> ");
			int command = InputUtil.InputInt();
			System.out.println();
			if (command == 1) {
				crud.addStock();
				crud.saveFile();
			} else if (command == 2) {
				crud.showStocks();
			} else if (command == 3) {
				crud.updateStock();
				crud.saveFile();
			} else if (command == 4) {
				crud.deleteData();
				crud.saveFile();
			} else if (command == 5) {
				break;
			}
			
		}
	}
	
	public static void showMenu() {
		System.out.println("======Menu======");
		System.out.println("1:在庫データを追加");
		System.out.println("2:一覧を表示");
		System.out.println("3:データを編集");
		System.out.println("4:データの削除");
		System.out.println("5:終了\n");
	}

}

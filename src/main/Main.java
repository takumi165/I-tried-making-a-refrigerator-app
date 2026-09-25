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
			int command = InputUtil.readRawInt();
			System.out.println();
			if (command == 1) {
				crud.addStock();
			} else if (command == 2) {
				crud.reduceStock();
			} else if (command == 3) {
				crud.updateStock();
			} else if (command == 4) {
				crud.deleteStock();
			} else if (command == 5) {
				crud.showStocks();
			} else if (command == 6){
				break;
			} else {
				System.out.println("無効な選択肢です");
			}
			
		}
	}
	
	public static void showMenu() {
		System.out.println("======Menu======");
		System.out.println("1:在庫データを追加");
		System.out.println("2:在庫数を減らす");
		System.out.println("3:データを編集");
		System.out.println("4:データの削除");
		System.out.println("5:一覧を表示");
		System.out.println("6:終了\n");
	}

}

package service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.Stock;
import util.InputUtil;

public class Service { 
		Path datacsv = Paths.get("/Applications/Eclipse_2026-03.app/Contents/workspace/I tried making a refrigerator app/data.csv");
		ArrayList<Stock> stocks = new ArrayList<Stock>();
		
		
		//ファイルの読み込み
		public List<String> loadFile() {
			try {
				List<String> dataStrings = Files.readAllLines(datacsv, Charset.forName("UTF-8"));
				return dataStrings;
			} catch (IOException e) {
				System.out.println("ファイルの読み込みに失敗");
				return null;
			}
		}
		
		//読み込んだデータをプログラムないで使用できるようにする
		public void dataConversion(List<String> dataStrings) {
			//csvの各行を取得
			for (String datas : dataStrings) {
				//カンマ区切りで文字列の分割
				String[] strings = datas.split(",");
				//データをStock型でstocksに追加
				stocks.add(new Stock(InputUtil.CSVinputInt(strings[0]), strings[1], Integer.parseInt(strings[2]), null, null)); 
			}
		}
		
		//ファイルが正常に読み込まれた時だけデータを変換する
		public void loadStocks() {
			if (loadFile() != null) {
				dataConversion(loadFile());
			} else {
				System.out.println("データ保護のためプログラムを終了します");
				System.exit(0);
				System.out.println("プログラムを終了できませんでした");
			}
		}
		
		//商品データを追加
		public void addStock() {
			stocks.add(new Stock(1, InputUtil.InputName(), 4, LocalDate.now(), InputUtil.inputLocalDate()));
		
		}
		//商品データのIDを自動で加算4
		public void increasesID() {
			
		}
		
		//一覧表示
		public void showStocks() {
			for (Stock stock : stocks) {
				System.out.println(stock);
			}
		}
		
		public void updateStock() {
			
		}
	
	
}

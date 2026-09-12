package service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import model.Stock;
import util.InputUtil;

public class Service { 
		Path datacsv = Paths.get("/Applications/Eclipse_2026-03.app/Contents/workspace/I tried making a refrigerator app/data.csv");
		Path tmpcsv = Paths.get("/Applications/Eclipse_2026-03.app/Contents/workspace/I tried making a refrigerator app/data.csv.tmp");
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
		public void convertList(List<String> dataStrings) {
			//csvの各行を取得
			for (int line = 0 ; line < dataStrings.size() ; line++) {
				//カンマ区切りで文字列の分割
				String[] strings = dataStrings.get(line).split(",");
				
				if (line != 0) {
					try {
						//要素数チェック
						if (strings.length == 5) {
							//データをStock型でstocksに追加
							stocks.add(new Stock(
									InputUtil.CSVloadInt(strings[0]), 
									strings[1], 
									InputUtil.CSVloadInt(strings[2]), 
									LocalDate.parse(strings[3], DateTimeFormatter.BASIC_ISO_DATE),
									LocalDate.parse(strings[4], DateTimeFormatter.BASIC_ISO_DATE)
									)); 
						} else {
							System.out.println(line +1+ "行目のデータを読み込めませんでした(不正な要素数)");
						}
					} catch (NumberFormatException e) {
						System.out.println(line +1+ "行目のデータを読み込めませんでした(不正な値)");
					} catch (DateTimeParseException e) {
						System.out.println(line +1+ "行目のデータを読み込めませんでした(不正な日付)");
					} 
				}
			
			}
		}
		
		//ファイルが正常に読み込まれた時だけデータを変換する
		public void loadStocks() {
			if (loadFile() != null) {
				convertList(loadFile());
			} else {
				System.out.println("データ保護のためプログラムを終了します");
				System.exit(0);
				System.out.println("プログラムを終了できませんでした");
			}
		}
		
		//保存するためのデータ変換
		public List<String> convertArraylist(ArrayList<Stock> dataList) {
			List<String> datalist = new ArrayList<String>();
			
			//ヘッダーの追加
			datalist.add("id,商品名,数量,購入日,消費期限");
			
			
			for (Stock stock : dataList) {
				List<String> dataStrings = new ArrayList<String>();
				dataStrings.add(String.valueOf(stock.getId()));
				dataStrings.add(String.valueOf(stock.getName()));
				dataStrings.add(String.valueOf(stock.getStock()));
				dataStrings.add(String.valueOf(stock.getPurchaseDate()).replace("-", ""));
				dataStrings.add(String.valueOf(stock.getExpirationDate()).replace("-", ""));
				System.out.println(dataStrings);
				datalist.add(String.join(",", dataStrings));
			}
			return datalist;
		}
		
		//文字列に変換したデータをファイルに書き込む
		public void saveFile() {
			try {
				Files.write(tmpcsv, convertArraylist(stocks));
				Files.move(tmpcsv, datacsv, StandardCopyOption.REPLACE_EXISTING);
			} catch (IOException e) {
				System.out.println("もう一度お試しください");
			}
		}
		
		//商品データを追加
		public void addStock() {
			stocks.add(new Stock(increasesID(), InputUtil.inputName(), InputUtil.inputQuantity(), LocalDate.now(), InputUtil.inputLocalDate()));
		}
		
		//商品データのIDを自動で加算
		public int increasesID() {
			int maxid = stocks.getLast().getId() +1;
			return maxid;
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

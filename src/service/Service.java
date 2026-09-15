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
		Path nextidtext = Paths.get("/Applications/Eclipse_2026-03.app/Contents/workspace/I tried making a refrigerator app/next_id.txt");
		
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
		
		//読み込んだデータをプログラム内で使用できるようにする
		public void convertList(List<String> dataStrings) {
			//csvの各行を取得
			for (int line = 0 ; line < dataStrings.size() ; line++) {
				//カンマ区切りで文字列の分割
				String[] strings = dataStrings.get(line).split(",");
				//ヘッダー行を読み飛ばす
				if (line != 0) {
					try {
						//要素数チェック
						if (strings.length == 5) {
							//データをStock型でstocksに追加
							stocks.add(new Stock(
									Integer.parseInt(strings[0]),
									strings[1], 
									Integer.parseInt(strings[2]),
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
			List<String> file = loadFile();
			if (file != null) {
				convertList(file);
			} else {
				//ファイルが読み込めないうちに新しくデータを作成してファイルが壊れないようにするため　
				System.out.println("データ保護のためプログラムを終了します");
				System.exit(0);
				System.out.println("プログラムを終了できませんでした");
			}
		}
		
		//オブジェクトを保存のためにlistに変換する
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
			stocks.add(new Stock(
					increasesID(), 
					InputUtil.inputName(), 
					InputUtil.inputQuantity(), 
					InputUtil.inputPurchaseDate(), 
					InputUtil.inputExpirationDate()
					));
		}
		
		//商品データのIDを自動で加算
		public int increasesID() {
			try {
				int nextid = Integer.parseInt(Files.readString(nextidtext)) +1;
				Files.writeString(nextidtext, String.valueOf(nextid));
				return nextid;
			} catch (IOException e) {
				System.out.println("IDの読み込みに失敗しました");
				System.exit(0);
				return -1;
			}

		}
		
		//一覧表示
		public void showStocks() {
			for (Stock stock : stocks) {
				System.out.println(stock);
			}
		}
		
		//IDからオブジェクトを検索
		public Stock findId() {
			int inputId = InputUtil.InputInt();
			for (Stock stockData : stocks) {
				if (stockData.getId() == inputId) {
					System.out.println(inputId);
					return stockData;
				}
			}
			System.out.println("存在しないIDです");
			return null;
		}
		
		public void updateStock() {
			System.out.println("編集したいデータのIDを入力してください");
			Stock editedData = findId();
			if (editedData != null) {
				System.out.println(editedData);
				System.out.println("編集したいデータを選択してください");
				System.out.println("1:商品名 2:在庫数 3:購入日 4:消費期限 5:キャンセル");
				int datanum = InputUtil.InputInt();
				if (datanum == 1) {
					System.out.println("商品名を変更します");
					editedData.setName(InputUtil.inputName());
				}  else if (datanum == 2) {
					System.out.println("在庫数を変更します");
					editedData.setStock(InputUtil.inputQuantity());
				} else if (datanum == 3) {
					System.out.println("購入日を変更します");
					editedData.setPurchaseDate(InputUtil.inputPurchaseDate());
				} else if (datanum == 4) {
					System.out.println("消費期限を変更します");
					editedData.setExpirationDate(InputUtil.inputExpirationDate());
				} else if (datanum == 5) {
					System.out.println("キャンセル");
				}
			}
			
		}
		
		public void deleteData() {
			System.out.println("削除するデータのIDを選択してください");
			Stock deletstockID = findId();
			if (deletstockID != null) {
				System.out.println("以下のデータを削除します");
				System.out.println(deletstockID);
				System.out.println("1:はい 2:いいえ");
				int yesno = InputUtil.InputInt();
				if (yesno == 1) {
					stocks.remove(deletstockID);
					System.out.println("正常に削除されました");
				}
			}
		}
	
}

package util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Scanner;

public class InputUtil {
	//入力受付
	static Scanner inputScanner = new Scanner(System.in);
	
	public static String InputString() {
		String inputString = inputScanner.nextLine();
		return inputString;
	}
	
	public static int  InputInt() {
		while (true) {
			String inputInt = inputScanner.nextLine();
			try {
				return Integer.parseInt(inputInt);
			} catch (NumberFormatException e) {
				System.out.println("数字を入力してください");
			}
		}
	}
	
	public  static String inputName() {
		while (true) {
			System.out.println("商品名を入力してください");
			String inputName = InputString();
			if (!inputName.matches("^[\\p{IsHan}\\p{IsHiragana}\\p{IsKatakana}ー]+$")) {
				System.out.println("記号や数字は使用できません");
	            continue;
			}
			return inputName;
		}
		
	}
	
	public static int inputamount() {
		while (true) {
			System.out.println("在庫数を入力してください");
			int inputQuantity = InputInt();
			if (inputQuantity >= 0 && inputQuantity <= 2000) {
				return inputQuantity;
			} else {
				System.out.println("0~2000の間で入力してください");
			}
		}
	}
	
	public static int inputreduceamount() {
		while (true) {
			System.out.println("数量を入力してください");
			int inputQuantity = InputInt();
			if (inputQuantity >= 0 ) {
				return inputQuantity;
			} else {
				System.out.println("0以下は入力できません");
			}
		}
	}
	
	public static LocalDate inputPurchaseDate() {
		System.out.println("購入日を入力します");
		while (true) {
			try {
				return LocalDate.of(inputYear(), inputMonth(), inputDay());
			} catch (Exception e) {
				System.out.println("もう一度お試しください");
			} 
		}
		
	}
	
	public static LocalDate inputExpirationDate() {
		System.out.println("消費期限を設定します");
		while (true) {
			try {
				return LocalDate.of(inputYear(), inputMonth(), inputDay());
			} catch (Exception e) {
				System.out.println("もう一度お試しください");
			} 
		}
		
	}
	
	public static int inputYear() {
		while (true) {
			System.out.println("年を入力してください　入力しない場合は現在の年が入力されます");
			String inputYear = inputScanner.nextLine();
			if (inputYear.isEmpty()) {
				System.out.println(LocalDate.now().getYear());
				return LocalDate.now().getYear();
			} else {
				try {
					int yearint = Integer.parseInt(inputYear);
					if (yearint >= LocalDate.now().getYear() && yearint <= LocalDate.now().getYear() +5 ) {
						return yearint;
					} else {
						System.out.println("無効な数値です");
					}
				} catch (NumberFormatException e) {
					System.out.println("数字を入力してください");
				}
				
			}
			
		}
	}
	
	public static int inputMonth() {
		while (true) {
			System.out.println("月を入力してください　入力しない場合は現在の月が入力されます");
			String inputMonth = inputScanner.nextLine();
			if (inputMonth.isEmpty()) {
				System.out.println(LocalDate.now().getMonthValue());
				return LocalDate.now().getMonthValue();
			} else {
				try {
					int monthint = Integer.parseInt(inputMonth);
					if (monthint >= 1 && monthint <= 12 ) {
						return monthint;
					} else {
						System.out.println("無効な数値です");
					}
				} catch (NumberFormatException e) {
					System.out.println("数字を入力してください");
				}
				
			}
			
		}
	}
	
	public static int inputDay() {
		while (true) {
			System.out.println("日を入力してください　入力しない場合は現在の日が入力されます");
			String inputDay = inputScanner.nextLine();
			if (inputDay.isEmpty()) {
				System.out.println(LocalDate.now().getDayOfMonth());
				return LocalDate.now().getDayOfMonth();
			} else {
				try {
					int dayint = Integer.parseInt(inputDay);
					if (YearMonth.now().isValidDay(dayint)) {
						return dayint;
					}else {
						System.out.println("無効な数値です");
					}
				} catch (NumberFormatException e) {
					System.out.println("数字を入力してください");
				}
				
			}
			
		} 
		
	}

}

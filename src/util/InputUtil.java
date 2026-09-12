package util;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {
	//入力受付
	static Scanner inputScanner = new Scanner(System.in);
	
	public static String InputString() {
		String inputString = inputScanner.next();
		return inputString;
	}
	
	/*public static int  InputInt() {
		while (true) {
			try {
				System.out.println("数字を入力");
				int inputInt = inputScanner.nextInt();
				return inputInt;
			} catch (InputMismatchException e) {
				System.out.println("数字を入力してください");
				inputScanner.next();
			}
		}
		
	}*/
	
	public static int  InputInt() {
		while (true) {
			String inputInt = inputScanner.next();
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
	
	public static int inputQuantity() {
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
	
	public static LocalDate inputLocalDate() {
		while (true) {
			try {
				return LocalDate.of(inputYear(), inputMonth(), inputDay());
			} catch (Exception e) {
				System.out.println("エラー");
			} 
		}
		
	}
	
	public static int inputYear() {
		while (true) {
			System.out.println("年を入力してください");
			int inputYear = InputInt();
			if (inputYear >= LocalDate.now().getYear() && inputYear <= LocalDate.now().getYear() +5 ) {
				return inputYear;
			} else {
				System.out.println("無効な数値です");
			}
		}
	}
	
	public static int inputMonth() {
		while (true) {
			System.out.println("月を入力してください");
			int inputMonth = InputInt();
			if (inputMonth >= 1 && inputMonth <= 12 ) {
				return inputMonth;
			} else {
				System.out.println("無効な数値です");
			}
		}
	}
	
	public static int inputDay() {
		while (true) {
			System.out.println("日を入力してください");
			int inputDay = InputInt();
			if (YearMonth.now().isValidDay(inputDay)) {
				return inputDay;
			}else {
				System.out.println("無効な数値です");
			}
		} 
		
	}
	
	public static int CSVloadInt(String intdata) throws NumberFormatException{
		return Integer.parseInt(intdata);
	}
	
	
	public static LocalDate CSVloadLocalDate(String localdate) throws DateTimeParseException{
		return LocalDate.parse(localdate, DateTimeFormatter.BASIC_ISO_DATE);
	}
}

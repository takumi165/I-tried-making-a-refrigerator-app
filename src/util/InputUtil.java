package util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
	//入力受付
	static Scanner inputScanner = new Scanner(System.in);
	
	//
	public static int Inputcommand(){
		System.out.println("実行する処理の番号を入力してください\n");
		try {
			int inputcommand = inputScanner.nextInt();
			if (inputcommand >= 1 && inputcommand <= 5) {
				return inputcommand;
			}
			return 0;
		} catch (InputMismatchException e) {
			inputScanner.nextLine();
			return -1;
		}
		
	}
}

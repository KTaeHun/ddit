package Study;

import java.util.Scanner;

public class Study01 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int[] unit = {50000, 10000, 1000, 500, 100, 50, 10, 1};
		
		System.out.print("금액을 입력하시오 >> ");
		int money = scanner.nextInt();
				
		for (int i = 0; i < unit.length; i++) {
			if (i == 0) {
			int moneyCount = (int) money / unit[i];	
			System.out.println(unit[i] + "원 짜리 : " + moneyCount);				
			} else {
			int moneyCount = (int) ((money % unit[i-1])  / unit[i]);
			System.out.println(unit[i] + "원 짜리 : " + moneyCount);
			}
		}
		scanner.close();
	}
}
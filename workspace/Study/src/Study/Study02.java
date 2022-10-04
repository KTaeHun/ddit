package Study;

import java.util.Scanner;

public class Study02 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
//		int[] monthThirty = {4, 6, 9, 11};
//		int[] monthThirtyOne = {1, 3, 5, 7, 8, 10};
//		int[] monthTwo = {2};
		
		while (true) {
			System.out.print("연도 : ");
			int year = scanner.nextInt();
			if ((0 <= year && year <= 2022) && year % 4 != 0 || (year % 100 == 0 && year % 400 != 0)) {
				System.out.print("월 : ");
				int month = scanner.nextInt();
				if (month == 1 || month == 3 || month == 5 || month == 7 || 
						month == 8 || month == 10) {
					System.out.println("입력하신 달의 날수는 31일 입니다.");
				} else if (month == 4 || month == 6 || month == 9 
						|| month == 11) {
					System.out.println("입력하신 달의 날수는 30일 입니다.");
				} else if (month == 2) {
					System.out.println("입력하신 달의 날수는 28일 입니다.");
				} else if (month == 0) {
					break;
				} else {
					System.out.println("잘못 입력하였습니다");
				}
			} else if (0 <= year && year <= 2022 && year % 4 == 0 || (year % 100 != 0 && year % 400 == 0)) {
				System.out.print("월 : ");
				int month = scanner.nextInt();
				if (month == 1 || month == 3 || month == 5 || month == 7 || 
						month == 8 || month == 10) {
					System.out.println("입력하신 달의 날수는 31일 입니다.");
				} else if (month == 4 || month == 6 || month == 9 
						|| month == 11) {
					System.out.println("입력하신 달의 날수는 30일 입니다.");
				} else if (month == 2) {
					System.out.println("입력하신 달의 날수는 29일 입니다.");
				} else if (month == 0) {
					break;
				} else {
					System.out.println("잘못 입력하였습니다");
				}
			} else {
				System.out.println("연도를 잘못 입력하였습니다.");
			}
		}
		scanner.close();
	}
}

package ArrayListTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		List<String> names = new ArrayList<>();
		List<String> tels = new ArrayList<>();

		Loop1 :
		while (true) {
			System.out.print("1. 명함추가  2. 명함삭제 3. 명함수정 4. 명함보기 5. 종료 : ");
			int choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				System.out.print("이름을 입력하세요. : ");
				String name = scan.next();
				names.add(name);
				System.out.print("전화번호 입력하세요. : ");
				scan.nextLine();
				String tel = scan.nextLine();
				tels.add(tel);
				continue;
			case 2:
				System.out.print("이름을 입력하세요. : ");
				name = scan.next();
				names.remove(name);
				System.out.print("전화번호 입력하세요. : ");
				System.out.println(name + "의 명함이 삭제 되었습니다.");
				continue;
			case 3:
				System.out.print("이름을 입력하세요. : ");
				name = scan.next();
				names.remove(name);
				names.add(name);
				System.out.print("전화번호 입력하세요. : ");
				scan.nextLine();
				tel = scan.nextLine();
				tels.add(tel);
				continue;
			case 4:
				for (int i = 0; i < names.size(); i++) {
					if (i == 0) {
						System.out.print("[Card [name=" + names.get(i) + ", tel = " + tels.get(i) + "]");
					} else {
						System.out.print(" , [Card [name=" + names.get(i) + ", tel = " + tels.get(i) + "]");
					}
				}
				System.out.println();
				continue;
			case 5:
				break Loop1;
			}
		}
	}
}

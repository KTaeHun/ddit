package ArrayListTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest03 {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		List<Integer> arr = new ArrayList<>();
		List<Integer> arrReturn = new ArrayList<>();
		
		System.out.print("값의 개수를 정해주세요 : ");
		int size = scan.nextInt();

		System.out.print("배열에 넣을 수를 입력하세요 : ");
		int num = scan.nextInt();
		arr.add(num);
		for (int i = 1; i < size; i++) {
			boolean isExist = false;
			System.out.print("배열에 넣을 수 입력하세요 : ");
			num = scan.nextInt();
			// for (int j = 0; j < arr.size(); j++)
			for (int j = 0; j < i; j++) {
				if (arr.get(j) == num) {
					System.out.println("중복된 수입니다.");
					isExist = true;
					i--;
					break;
				}
			}
			if (!isExist) {
				arr.add(num);
			} 
		}
		
		System.out.print("나눌 자연수를 입력하세요 : ");
		int divisor = scan.nextInt();

		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) % divisor == 0) {
				arrReturn.add(arr.get(i));
			} 
		}

		if (arrReturn.size() == 0) {
			arrReturn.add(-1);
		}
		Collections.sort(arrReturn);

		System.out.print("[");
		for (int i = 0; i < arrReturn.size(); i++) {
			if (i == 0) {
				System.out.print(arrReturn.get(i));
			} else {
				System.out.print(", " + arrReturn.get(i));
			}
		}
		System.out.println("]");
	}
}
package ArrayListTest;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListTest02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> names = new ArrayList<>();
		
		for(int i = 0; i < 6; i++) {
			System.out.print("이름을 입력하세요. ");
			String name = sc.nextLine();
			names.add(name);
		}
		
		for(String name : names) {
		   if(name.contains("김")) 
			System.out.print(name + " ");
		}
	}
}

package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class T06TreeSetTest {
   public static void main(String[] args) {
	
	   TreeSet<String> ts = new TreeSet<String>();
	   
	   List<String> abcList = new ArrayList<String>();
	   
	   //영어 대문자를 문자열로 변환하여 List에 저장하기
	   for (char ch = 'A'; ch <= 'Z'; ch++) {
		   String temp = String.valueOf(ch);
		   abcList.add(temp);
		   }
	   
	   System.out.println("abcList 자료(섞기전) : " + abcList);
	   
	   Collections.shuffle(abcList);
	   
	   System.out.println("abcList 자료(섞은후) : " + abcList);
	   
	   for (String str : abcList) {
		   ts.add(str);
       } //정렬이 되면서 들어가고 중복된 데이터는 들어가지 않는다.
	   
	   System.out.println("TreeSet 자료 : " + ts);
	   
	   // TreeSet에 저장된 자료중 특정한 자료보다 작은 자료를 찾아서 SortedSet으로
	   // 반환하는 메서드가 있다. 
	   // => headSet(기준값) : 기본적으로 '기준값'은 포함시키지 않는다. 
	   // => headSet(기준값, 논리값) : 논리값이 true이면 '기준값'을 포함시킨다.
	   SortedSet<String> ss1 = ts.headSet("K");
	   System.out.println("K 이전 자료 : " + ss1); // 기준값 미포함
	   System.out.println("K 이전 자료(기준값 포함) : " 
	           + ts.headSet("K", true));
	   
	   // '기준값'보다 큰 자료를 찾아 SortedSet으로 반환하는 메서드
	   // => tailSet(기준값) : 기본적으로 '기준값'을 포함시킨다.
	   // => tailSet(기준값, 논리값) : 논리값이 false이면 '기준값'을 포함시키지 않는다. 
	   SortedSet<String> ss2 = ts.tailSet("K");
	   System.out.println("K 이후 자료 : " + ss2);
	   System.out.println("K 이후 자료(기준값 미포함) : "
	           + ts.tailSet("K", false));
	   
	   // subSet(기준값1, 기준값2) : 기준값1~기준값2 사이의 값을 가져온다. 
	   //                        ('기준값1' 포함, '기준값2' 미포함)
       // subSet(기준값1, 논리값1, 기준값2, 논리값2) : 각 값을 기준으로 포함여부 설정	
	   System.out.println("K(포함)부터 N(미포함)까지 : "
			   + ts.subSet("K", "N"));
	   System.out.println("K(포함)부터 N(포함)까지 : "
			   + ts.subSet("K", true, "N", true));
	   System.out.println("K(미포함)부터 N(미포함)까지 : "
			   + ts.subSet("K", false, "N", false));
	   System.out.println("K(미포함)부터 N(포함)까지 : "
			   + ts.subSet("K", false, "N", true));
  }
}
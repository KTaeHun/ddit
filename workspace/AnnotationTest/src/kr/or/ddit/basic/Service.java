package kr.or.ddit.basic;

public class Service {
   
   @PrintAnnotation
   public void method1() {
	   System.out.println("메서드1에서 출력되었습니다.");
   }
   
   @PrintAnnotation(value = "%") // value만 단독으로 사용할 때 value를 생략해줘도 가능하다.
   public void method2() {
	   System.out.println("메서드2에서 출력되었습니다.");
   }
   
   @PrintAnnotation(value = "#", count = 25)
   public void method3() {
	   System.out.println("메서드3에서 출력되었습니다.");
   }
}

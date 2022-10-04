package kr.or.ddit.basic;

import java.util.ArrayList;
import java.util.List;

public class T06WildCardTest {

	/* 
	    와일드 카드에 대하여...
	    
	    와일드카드(?) 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의 
	    인수(Argument)로서, 함수선언, 객체생성 및 메서드 정의할 때 사용된다.
	    
	    <? extends T> => 와일드카드의 상한제한, T와 그 자손들만 가능
        <? super T>   => 와일드카드의 하한제한, T와 그 조상들만 가능 
        <?>           => 모든타입이 가능<? extends Object>와 동일
	 */
	
	public static void main(String[] args) {
	   //List<?> list = new ArrayList<String>();
	   //  T는 사용불가      // 객체 생성에서는 와일드카드 사용불가 
	   //  선언된 타입을 알고 싶은데 T를 쓰면 안됨. 제너릭이라는 것을 알 수있는 위치에 선언했을 때만 <T>가 가능하다.
	   //  하나의 타입을 정해두고 싶지 않을때 와일드카드(?)를 써야 한다. 
	
		FruitBox<Fruit> fruitBox = new FruitBox<>();
		FruitBox<Apple> appleBox = new FruitBox<>();
		FruitBox<Gabage> gabageBox = new FruitBox<>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		appleBox.add(new Apple());
//	    appleBox.add(new Grape());

		gabageBox.add(new Gabage());
		gabageBox.add(new Gabage());
		gabageBox.add(new Gabage());
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
//		Juicer.makeJuice(gabageBox);
	}
}

class Juicer {
//	static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	static void makeJuice(FruitBox<? extends Fruit> box) {	
		String fruitListStr = ""; //과일목록
		
		int cnt = 0;
		
		for(Object f : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += f;
			} else {
				fruitListStr += "," + f;
			}
			cnt++;
		}
		System.out.println(fruitListStr + " => 쥬스 완성!");
	}
}

class Fruit {
	private String name;  // 과일이름

	public Fruit(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
}

class Apple extends Fruit {

	public Apple() {
		super("사과");
	}
}

class Grape extends Fruit {

	public Grape() {
		super("포도");
	}
}

class Gabage {

	@Override
	public String toString() {
		return "쓰레기";
	}
}

class FruitBox<T> {
	
	private List<T> fruitList = new ArrayList<>();

	public List<T> getFruitList() {
		return fruitList;
	}

	public void add(T fruit) {
		fruitList.add(fruit);
	}
}


package ch04.dao;

import java.util.ArrayList;
import java.util.List;

import ch04.vo.BookVO;
import ch04.vo.ProductVO;

public class BookRepository {

	private static BookRepository instance = new BookRepository();
		
	// 객체 변수 instance에 대한 Getter() 메소드
	public static BookRepository getInstance() {
		return instance;
	}
	
	private List<BookVO> listOfBooks =
			new ArrayList<BookVO>();
	
	public BookRepository() {
		
		BookVO book1 = new BookVO("B001", "HTML5+CSS3", 15000);
		book1.setAuthor("황재호");
		book1.setDescription("워드나 PPT 문서를 만들 수 있나요? 그러면 문제 없습니다. 지금 바로 "
				+ "웹페이지 제작에 도전해보세요. 지금 당장 컴퓨터가 없어도 괜찮습니다. 코드와 실행 화면이"
				+ "바로 보여서 눈으...");
		book1.setPublisher("한빛미디어");
		book1.setCategory("Hello coding");
		
		book1.setFilename("B001.png");
		
		listOfBooks.add(book1);
		
		BookVO book2 = new BookVO("B002", "쉽게 배우는 자바 프로그래밍", 27000);
		book2.setAuthor("우종종");
		book2.setDescription("객체 지향의 핵심과 자바의 현대적 기능을 충실히 다루면서도 "
				+ "초보자가 쉽게 학습할 수 있게 구성했습니다. 시각화 도구를 활용한 개념 설명과"
				+ "군더더기 없는 핵심 코드를 통해 개념과 구현...");
		book2.setPublisher("한빛아카데미");
		book2.setCategory("IT모바일");
		
		book2.setFilename("B002.png");
		
		listOfBooks.add(book2);
		
		BookVO book3 = new BookVO("B003", "스프링4 입문", 27000);
		book3.setAuthor("하세가와 유이치,오오노 와타루,토키 코헤이(권은철, 전민수)");
		book3.setDescription("스프링은 단순히 사용 방법만 익히는 것보다 아키텍쳐를 어떻게 "
				+ "이해하고 설계하는지가 더 중요합니다. 예제를 복사해 붙여넣는 식으로는"
				+ "실제 개발에서 스프링을 제대로 활용할 수 없습니다...");
		book3.setPublisher("한빛미디어");
		book3.setCategory("IT모바일");
	
		book3.setFilename("B003.png");	
		
		listOfBooks.add(book3);
	}
	
	public List<BookVO> getAllProducts() {
		return listOfBooks;
	}
	
	public void addBook(BookVO bookVO) {
		
		listOfBooks.add(bookVO);
	}
	
	public BookVO getBookById(String bookId) {
		// 자바빈객체 선언
		BookVO bookById = null;
	
		for (int i = 0; i < listOfBooks.size(); i++) {
			
			BookVO vo = listOfBooks.get(i);
			
			if (vo != null && vo.getBookId() != null && vo.getBookId().equals(bookId)) {
				bookById = vo;
				break;
			}
		}
		return bookById;
	}
}

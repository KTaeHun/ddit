package Book;

public class Book {
	private int number;
	private String title;
	private String author;
	private static int countOfBooks = 1;
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
		this.number = countOfBooks;
		countOfBooks++;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	public int getLateFee(int lateDays) {
		return lateDays;
	}


//	@Override
//	public String toString() {
//		return "관리번호" + number + "번, 제목: " + title + ", 작가: " + author + "(일주일 연체료: " + getLateFee() + "원)";
//	}

	@Override
	public String toString() {
		return String.format("관리번호 %d번, 제목: %s, 작가: %s", number, title, author);
	}
}	

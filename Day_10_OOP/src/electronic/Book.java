package electronic;

public class Book {
	
	// 개발자가 예상해서 값을 미리 세팅 해놓을 수 있음
	// 개발자가 개발단계 초기에 세팅해 놓는 값
	private int id = 1001;
	private String title = "로미오와 줄리엣";
	private int price = 14000;
	
	// 오버로딩
	public Book() {
		
	}
	
	// 생성자 메서드
	public Book(int id, String title, int price){
		 //super();
		 this.id = id;
		 this.title = title;
		 this.price = price;
	}
	



	public int getterId() {
		return id;
	}
	public void setterId(int id) {
		this.id = id;
		

	}

	public String getterTitle() {
		return title;
	}
	public void setterTitle(String title) {
		this.title = title;

	}
	
	public int getterPrice() {
		return price;
	}
	
	public void setterPrice(int price) {
		this.price = price;
		
	}



}

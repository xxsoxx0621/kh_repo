package grades;

public class Gold extends Grade {
	// Grade 클래스를 상속 받음
	
	public Gold(int id, String name, int point) {
		
		
		super(id,name,point); // 자신의 상위 생성자를 부를 때 사용 // 생략해도 존재
		
//		this.setId(id);
//		this.setName(name);
//		this.setPoint(point);
	}
	
	public Gold() {
		
	}
	
	public double getBonus() { // Method Overriding
		return this.getPoint() * 0.03;
	}
	
	
	
	
	//  - 골드등급 회원의 정보를 저장하기 위한 클래스
	
	// - 멤버필드
	//  고유 아이디는 1001번 부터 시작
//	
//	private int id;
//	private String name;
//	private int point;
//	
//	// - 멤버 메서드
//	public Gold() {
//		super();
//	}
//	public Gold(int id, String name, int point) {
//		this.id = id;
//		this.name = name;
//		this.point = point;
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getPoint() {
//		return point;
//	}
//
//	public void setPoint(int point) {
//		this.point = point;
//	}
//	
//	public double getBonus() {
//		return this.point * 0.03;
//		
//	}
	

}

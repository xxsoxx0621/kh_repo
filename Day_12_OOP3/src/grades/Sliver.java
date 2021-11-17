package grades;

public class Sliver extends Grade {
	
	public Sliver() {
		
	}
	
	public Sliver(int id, String name, int point) {
		super(id,name,point);
	}
	
	@Override
	public double getBonus() {
		return this.getPoint()*0.04;
	}


	//  - 실버등급 회원의 정보를 저장하기 위한 클래스
	
	// - 멤버필드
	//  고유 아이디는 1001번 부터 시작
	
//	private int id;
//	private String name;
//	private int point;
//	
//	// - 멤버 메서드
//	public Silver() {
//		super();
//	}
//	public Sliver(int id, String name, int point) {
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
//	
	

}

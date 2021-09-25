package grades;

public abstract class Grade {
	
	// Grade = Super class = 부모 클래스 = 상위 클래스
	// Gold, Sliver = Derived class = 자식 클래스 = 하위 클래스
	
	private int id;
	private String name;
	private int point;
	
	public Grade() {
		
	}
	
	public Grade(int id, String name, int point) {
		
		this.id = id;
		this.name = name;
		this.point = point;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
	
	//추상화
	abstract public double getBonus();
		// return this.point * 0.02;
		// 내용을 지울 수 있음
		
	
}

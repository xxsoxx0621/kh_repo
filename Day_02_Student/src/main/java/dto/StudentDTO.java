package dto;

public class StudentDTO {
	
	
	private String name;
	private int id;
	private int kor;
	private int eng;
	
	public StudentDTO( int id, String name, int kor, int eng) {
		super();
		this.name = name;
		this.id = id;
		this.kor = kor;
		this.eng = eng;
		
	}
	public StudentDTO() {
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
}
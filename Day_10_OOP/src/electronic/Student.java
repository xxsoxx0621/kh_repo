package electronic;

public class Student {
	
	private int id; // 학번
	private String name; //학생 이름
	private int kor; // 국어점수
	private int eng; // 영어점수
	private int	math; // 수학점수

	public Student(int id, String name, int kor, int eng, int math) {
		this.id = id;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		
		
		
	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//	
//	public int getId() {
//		return id;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getName() {
//		return name;
//	}
//	
//	public void setKor(int kor) {
//		this.kor = kor;
//	}
//	
//	public int getKor() {
//		return kor;
//	}
//	public void setEng(int eng) {
//		this.eng = eng;
//	}
//	
//	public int getEng() {
//		return eng;
//	}
//	public void setMath(int math) {
//		this.math = math;
//	}
//	
//	public int getMath() {
//		return math;
//	}
//	
//	public int getSum() {
//		int sum = kor + eng + math;
//		return sum;
//	}
	
//	public double getAvg() {
//		double avg = (getSum())/3.0;
//		return avg;
//	}
	
}

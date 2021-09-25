package student;



public class Student  {
	
	// Data 클래스 ( 학생 한명의 정보를 저장) 
	private int stdNum = 1001;
	private String stdName;
	private	int korNum;
	private	int engNum;
	private	int mathNum;
 
	// 기본 생성자
	public Student(){
		super();
	}
	
	public Student(int stdNum,String stdName,int korNum,int engNum,int mathNum) {
		this.stdNum = stdNum;
		this.stdName = stdName;
		this.korNum = korNum;
		this.engNum = engNum;
		this.mathNum = mathNum;
	}

	public int getStdNum() {
		return stdNum;
	}

	public void setStdNum(int stdNum) {
		this.stdNum = stdNum;
	}

	public String getStdName() {
		return stdName;
	}

	public void setStdName(String stdName) {
		this.stdName = stdName;
	}

	public int getKorNum() {
		return korNum;
	}

	public void setKorNum(int korNum) {
		this.korNum = korNum;
	}

	public int getEngNum() {
		return engNum;
	}

	public void setEngNum(int engNum) {
		this.engNum = engNum;
	}

	public int getMathNum() {
		return mathNum;
	}

	public void setMathNum(int mathNum) {
		this.mathNum = mathNum;
	}
	public int getSum() {
		return this.mathNum+this.korNum+this.engNum;
	}
	public double getAvg() {
		return (double)((mathNum + korNum + engNum)/3);
	}
}

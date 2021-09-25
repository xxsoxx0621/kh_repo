package exam;


public class Exam_04_Overload {
	
	
	// 메서드는 동일한 이름 사용 불가 마치 변수 이름 처럼
	// 그러나,  메서드이름이 동일해도 매개변수가 다르면 다른 메서드로 볼 수 있음
	// 메서드 오버로딩 
	
	public static void func(int a) {
		System.out.println("func1() 입니다.");
	}
	
	public static void func(String a ) {
		System.out.println("func2() 입니다.");
	}
	
	public static void func() {
		System.out.println("func3() 입니다.");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		func();

	}

}

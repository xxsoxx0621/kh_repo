package exams;


class A{
	// 자바는 한개의 클래스에 한개만 만들 수 있음 
	
	public void funcA() {
		System.out.println("funcA 입니다.");
	}
}

class B extends A{
	//참조 자료형 
	public void funcB() {
		System.out.println("funcB 입니다.");
	}
}
class C extends A{
	
}
public class Exam_01_Polymorph {
	public static void main(String[] args) {
		//다형성이 무엇인지? ->  클래스간 상속관꼐에서만 발현되는 서로 다른 타입의 값을 가질 수 있는 성질
		// 상위클래스 참조변수는 자신을 상속받는 하위클래스 인스턴스의 주소를 저장 할 수 있다.
		
		//  다 = 많을 다
		//  형 = 형상 형
		//  성 = 성품 성 
		
//		String b = "Hello";
//		
//		int a = b;
//		b = a;
		
//		byte = double;
		
		A a = new B(); // up casting
		a.funcA();
		((B)a).funcB(); // 다운 캐스팅 down casting
//		a = new A();
//		a = new C();
//		
//		B b = new A();
	}
}

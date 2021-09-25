package main;
import electronic.Book;
import electronic.Calc;
import electronic.Student;
import electronic.Tv;

public class Main {
	public static void main(String[] args) throws Exception {
		// 프로그램 시작점 목적으로 만들어짐
//		Scanner sc = new Scanner(System.in);
//
//		Monitor m1 = new Monitor();
//		Monitor m2 = new Monitor();
//		// 변수 m에는 Monitor의 주소 값이 들어가 있음.
//
//		// '.'을 참조 연산자
//		m1.powerOn();
//
//		String str1 ="ABC";
//		String str2 = new String("ABC");
//
//		// ctrl + shift + O -> import
//
//		Robot r = new Robot();
//		
//		for(int i=0; i< 100; i++) {
//			r.mouseMove(1200+i,100);
//			Thread.sleep(10);
//		}
//		
//		Light l1 = new Light();
//		l1.turnOn();
		
//		Tv lg = new Tv();
//		lg.setChannel(10);
//		System.out.println(lg.getChannel());
		
		Book b1 = new Book(1000,"로미오와 줄리엣",14000);
		
//		book.setterId(1001);
//		book.setterTitle("로미오와 줄리엣");
//		book.setterPrice(14000);
		
		
		Book b2 = new Book(1002,"아프니까 청춘이다", 15000);
		
//		book1.setterId(1002);
//		book1.setterTitle("아프니까 청춘이다");
//		book1.setterPrice(15000);
		
		//b1,b2 와 코드의 상태는 다르지만 목적은 같다.
		Book b3 = new Book();
		
		b3.setterId(1003);
		b3.setterTitle("주홍글씨");
		b3.setterPrice(20000);
		
				
		System.out.println("책 3권의 전체 가격은 " + b1.getterPrice()+b2.getterPrice()+b3.getterPrice());
		
		Student st = new Student(1001,"Jack",90,60,80);
		
//		st.setId(1001);
//		st.setName("Jack");
//		st.setEng(90);
//		st.setKor(60);
//		st.setMath(80);
//		
//		Student st1 = new Student();
//		
//		st1.setId(1002);
//		st1.setName("Jane");
//		st1.setEng(80);
//		st1.setKor(90);
//		st1.setMath(70);
//		
//		System.out.println("Jack 학생의 총점 : " + st.getSum()); // 총점
//		System.out.println("Jack 학생의 총점 : " + st.getAvg()); // 평균
//		
//		System.out.println("Jane 학생의 총점 : " + st1.getSum()); // 총점
//		System.out.println("Jane 학생의 총점 : " + st1.getAvg()); // 평균
	
		Calc c = new Calc();
		
		System.out.println(c.plus(10,5));
		System.out.println(Calc.minus(10,5));
	}

}

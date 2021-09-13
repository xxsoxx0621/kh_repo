import java.util.Scanner;

public class Exam_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// 같은 주소값에 저장되어 있음
		// 참조형은 가변적이기기 때문에 
//		String a = "Hello"; // 참조형 - 힙메모리에 저장
//		String b = "Hello"; // a,b는 주소값이 담겨있음
		
		// 하기 내용 처럼 쓰면 다른 주소값을 가짐
		
//		String a = "Hello";
//		String b = new String("Hello");
//		
//		
//		
//		System.out.println( a == b );
//		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("메세지를 입력하세요. ");
		String msg = sc.nextLine();
		// sc.nextLine() -> new String 처럼 사용 된다.
		
		if(msg.equals ("Apple")) {
		// msg == "Apple" 
		// 자바에서 문자열 간 비교는  == 사용 하지 않는다.
		// 자바에서 문자열 간 비교는  .equals 기능을 사용해야 한다.
			
		// why? -> 주소값이 달라지기 때문에
			
			System.out.println("입력된 단어는 사과 입니다.");
		}
	}

}

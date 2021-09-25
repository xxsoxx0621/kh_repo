package exam;


public class Exam_01 { // Startup 기업 Exam_01 이라고 가정
	// return 데이터 타입

	public static int plus (int num1, int num2){ // -> 메서드 정의
		int result = num1 + num2;
		return result; 

		//1. 메서드를 종료한다.
		//2. 값을 Caller 에게 전달한다.
	}

	// 두 정수를 인자값으로 전달 받아, 뺄셈한 결과를 int로 return 하는 minus 메서드 만들기

	public static int minus (int num1, int num2) {
		int result = num1 - num2;
		return result;
	}
	// 두 정수를 인자로 전달 받아, 곱셈한 결과를 int로 return 하는 mply 메서드 만들기

	public static int mply(int num1, int num2) {
		int result = num1 * num2;
		return result;
	}
	// 두 정수를 인자로 전달 받아, 나눗셈한 결과를 double로 return 하는 divide 메서드 만들기

	public static double divide (int num1, int num2) {
		return (double)  num1 / num2;
	}

	// 두 정수를 인자로 전달 받아, 더 큰 수를  int로 return 하는 bigger 메서드 만들기 
	// 단, 두 수가 같을 경우 0을 return.

	public static int bigger(int num1, int num2) {
		if(num1 > num2) {
			return num1;
		}else if(num1 < num2) {
			return num2;
		}else {
			return 0;
		}
	}

	// 인자값이 없고, return 값도 없는 hello메서드를 만들기
	// 메서드가 실행되면 "Hello Java"라고 출력

	public static void hello(){
		System.out.println("Hello Java");
		System.out.println("2021-09-14(TUE)");
		System.out.println("날씨맑음");

	}

	// 장점 : 유지보수 유리, 에러검출 용이, 팀플레이 유리, 재활용성 좋고, 가독성이 좋다

	public static void main(String[] args) { // main 사장
		// TODO Auto-generated method stub

		//System.out.println(10 + 5);

		System.out.println(plus(10,5)); // -> 메서드 호출부

		// 인수 or 인자 , parameter or argument.
		//Parameter : 메서드를 call 하면서 전달하는 값
		// 매개변수 (Arguments) : 


		System.out.println(minus(10,5));
		System.out.println(mply(10,5));
		System.out.println(divide(10,5));
		System.out.println(bigger(10,5));
		hello();

	}

}

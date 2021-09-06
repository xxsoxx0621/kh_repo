
public class Quiz_03 {
	public static void main(String[] args) {
		int i1 =10;
		int i2 = 20;
		float f1 = 3.14f;
		char c1 = 'A';
		char c2 = 'B';
		
		System.out.println("결과 : " + i1 + i2);
		System.out.println("결과 : " + (i1 + i2));
		System.out.println("결과 : " + i1 + f1);
		System.out.println("결과 : " + (i1 + f1));
		System.out.println("결과 : " + f1 + c1);
		System.out.println("결과 : " + (f1 + c1));
		System.out.println("결과 : " +  c1 + c2);
		// 덧셈이 두개 있으면 왼쪽에 있는 c1부터가 먼저 덧셈이 된다.
		// "결과 : "라는 값이 String 이기 때문에 맞춰짐
		// String은 기본형에서 가장 큰걸로 취급된다. 
		System.out.println("결과 : " + (c1 + c2));
		// '' 싱글쿼테이션 사용했을 때는 정수로 계산 
	}
}

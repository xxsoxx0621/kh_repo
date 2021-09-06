import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 여러자리 숫자 두 개를 입력받아
		// 덧셈한 결과를 출력하는 프로그램을 작성하세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자1을 입력해주세요. ");
		int num1 = sc.nextInt();
		
		System.out.println("숫자2을 입력해주세요. ");
		int num2 = sc.nextInt();
		
		int result = num1 + num2; 
		
		System.out.println("덧셈한 결과는 : "  + result);
		
	}

}

import java.util.Scanner;

public class Quiz_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("1~100 사이 입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		System.out.println("====결 과 =====");
		
		// 사용자가 입력한 수가 1 ~ 100 사이의 수인 경우
		if(num <= 100 && num >= 1 ) {
			 if(num % 2 == 0 ) {
				 System.out.println("짝수 입니다.");
			 }else {
				 System.out.println("홀수 입니다.");
			 }
		 }
		
		// 아닌 경우
		else {
			System.out.println("숫자 범위를 다시 확인해주세요.");
		}
		
		
		
//		
//		System.out.println("====결 과 =====");
//		
//		if(num % 2 == 0 && (num <= 100 && num >= 1)){
//			System.out.println("입력한 수는 짝수 입니다.");
//		}else if( num % 2 == 1 && (num <= 100 && num >= 1)) {
//			System.out.println("입력한 수는 홀수 입니다.");
//		}else  {
//			System.out.println("1~100 사이로 입력해주세요.");
//		}

	}
}

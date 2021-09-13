import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int num = 0;
		// 예외 처리 - try ~ catch

		System.out.print("숫자를 입력하세요 : ");

		try {
			num = Integer.parseInt(sc.nextLine());
			System.out.println("정상 입력 확인");
		
		}catch(Exception e){
			System.out.println("입력한 값은 숫자가 아닙니다.");
		}
		
//		System.out.println("프로그램 종료");
		System.out.println("입력한 숫자는 " + num + "입니다. ");



	}

}

import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요 : ");
		
		
		String num = sc.nextLine();
		
		//1번째 방법
		int result = Integer.parseInt(num); //숫자로 바꾸고 싶은 문자열 넣기
		
		
		//2번째 방법
		
		//int result = sc.nextInt();
		System.out.println(result + 10);
		
	}

}



import java.util.Scanner;

public class Exam_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		// System.in.read(); // 한글자만 int형으로 입력받는다.
		// 미래에 정해질 아직 정해지지 않은 숫자 하나
		
		System.out.println("남길 메세지를 입력해주세요 . ");
		String str = sc.nextLine(); // 한 라인을 String형으로 입력받는다. 
		// 미래에 정해질 아직 정해지지 않은 문자열 
		System.out.println("입력한 메세지는 : " + str);

	}

}

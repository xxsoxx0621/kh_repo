import java.util.Scanner;

public class Exam_01_IF {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("당신이 좋아하는 과일을 선택하세요.");
		System.out.println("1. 사과  2. 바나나  3. 포도 ");
		System.out.print(">>");
		int menu = Integer.parseInt(sc.nextLine());
		
		if(menu == 1) {
			System.out.println("사과는 영어로 Apple 입니다.");
		}else if(menu == 2) {
			System.out.println("바나나는 영어로 Banana 입니다. ");
		}else if(menu == 3) {
			System.out.println("포도는 영어로 Grape 입니다. ");
		}else {
			System.out.println("메뉴를 다시 확인해주세요.");
		}
		
		

	}

}

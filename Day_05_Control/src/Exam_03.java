import java.util.Scanner;

public class Exam_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			Scanner sc = new Scanner(System.in);
		
			System.out.println("과일을 선택하세요.");
			System.out.println("1. 망고 2. 포도 3. 바나나");
			System.out.print(">> ");
			
			int menu = sc.nextInt();
			
			String str = "A";
			
			switch(str) {
			case "A":
				System.out.println("망고는 영어로 Mango");
				break;
			case "B":
				System.out.println("포도는 영어로 Grape");
				break;
			case "C":
				System.out.println("바나나 영어로 Banana");
				break;
			default:
				System.out.println("메뉴를 다시 확인해주세요.");
			
			}
	}
}



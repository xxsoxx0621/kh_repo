import java.util.Scanner;

public class Exam_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		
		
		//double coin = Math.random();
		//1 또는 2
		// 최대값 : Y, 최소값 : X
		// ((int)(Math.random()* (Y - X + 1)))+ X
		
		int result = ((int)(Math.random()*(2 - 1 +1))) + 1;

		while(true) {
			System.out.println("=== 동전 앞 뒤 맞추기 ===");
			System.out.print("숫자를 입력해주세요. (1.앞면 / 2. 뒷면 ) : ");
			int num = Integer.parseInt(sc.nextLine());
			
			if( num == 1 && result == 1 ) {
				System.out.println("맞췄습니다.");
				continue;
			}else if(num == 2 && result ==2) {
				System.out.println("맞췄습니다.");
				continue;
			}else {
				System.out.println("땡! 틀렸습니다!");
				continue;
				
			}
		}
	}
}

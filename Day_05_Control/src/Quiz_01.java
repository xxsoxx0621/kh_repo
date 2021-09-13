import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		
//		Scanner sc = new Scanner(System.in);
//	
//		int sum = 0;
//		
//		while (true) {
//			System.out.print("숫자 입력 : ");
//			int num = Integer.parseInt(sc.nextLine());
//			sum += num;
//			
//			if(num == 0) {
//				System.out.println("입력한 숫자의 총 합은 : " + sum);
//				break;
//				
//			}else {
//				continue;
//			}
//		}
//	}

		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		
		for(;;) {
			System.out.print("숫자 입력 : ");
			int num = Integer.parseInt(sc.nextLine());
			sum += num;
			if(num == 0) {
				System.out.println("입력한 숫자의 총 합은 : " + sum);
				break;
				
			}else {
				continue;
			}
		}
		
	}
}

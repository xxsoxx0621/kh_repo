import java.util.Scanner;

public class Quiz_04_upNDown1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// UP & DOWN 게임 다시 만들기
		
		Scanner sc = new Scanner(System.in);
		int menu = 0;
		while(true) {
			try {
				while(true) {
					System.out.println("== Up & Down Game ==");
					System.out.println("1. Game Start");
					System.out.println("2. Game Score");
					System.out.println("3. End Game");
					System.out.print(">> ");

					menu = Integer.parseInt(sc.nextLine());

					if(menu > 0 && menu <4) {break;}
				}
			}catch(Exception e) {
				System.out.println("다시 입력하세요.");
			}


			if(menu == 1) {
				// 랜덤 값 부여하기
				int num = (int) (Math.random()*(100)+1);
				System.out.println("<< Game Start >>");
				System.out.println("정답은 : " + num);
				while(true) {

					System.out.print("Input Number : ");
					int inputNum = Integer.parseInt(sc.nextLine());
					if(num > inputNum ) {
						System.out.println("<< up >>");
					}else if(num < inputNum) {
						System.out.println("<< down >>");
					}else {
						System.out.println("정답입니다.");
						break;
					}


				}
			}else if(menu == 2) {
				
				// 게임 스코어 : 최소로 진행 한 값 저장
				
				
			}else {
				System.out.println("시스템을 종료합니다.");
				System.exit(0);
			}


		}
	}

}

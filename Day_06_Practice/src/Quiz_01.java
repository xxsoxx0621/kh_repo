import java.util.Scanner;

public class Quiz_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		System.out.println("***ATM 시뮬레이터***");

		int checkMoney = 0;
		int cost =0;
		int backCost = 0;
		int num = 0;

		while(true) {

			System.out.println("*****************");
			System.out.println("1. 잔액조회");
			System.out.println("2. 입금하기");
			System.out.println("3. 출금하기");
			System.out.println("4. 종료하기");
			System.out.printf(">> ");
			while(true) {
				try {
					num = Integer.parseInt(sc.nextLine());
					break;
				}
				catch(Exception e){
					System.out.println("숫자만 입력 가능합니다.");
					break;
				}
				
			}
			//try catch 사용해서 

			switch(num) {


			case 1 :
				System.out.println("현재 보유 잔액은 : " + checkMoney + " 입니다.");
				break;

			case 2 :

				System.out.println("얼마를 입금 하시겠습니까?");
				System.out.printf(">> ");

				while(true) {
					try {
						cost = Integer.parseInt(sc.nextLine());
						break;
					}
					catch(Exception e) {
						System.out.println("숫자만 입력 가능합니다.");
						break;
					}


				}
				if(cost > 0) {
					checkMoney += cost;
					System.out.println(cost + "원이 입금 되었습니다.");


				}else if(cost <= 0){
					System.out.println("0원 미만은 입금 불가합니다.");

				}

				break;

			case 3 :	
				System.out.println("얼마를 출금 하시겠습니까?");
				System.out.printf(">> ");

				while(true) {
					try {
						backCost = Integer.parseInt(sc.nextLine());
						break;
					}catch(Exception e) {
						System.out.println("숫자만 입력 가능합니다.");
						break;
					}
				}
					if(checkMoney >= backCost) {
						checkMoney -= backCost;
						System.out.println(backCost + " 출금되었습니다.");


					}else if(checkMoney < backCost){
						System.out.println("잔액이 부족하여 출금이 불가합니다.");

					}
					break;

				case 4 :
					System.out.println("ATM을 종료합니다.");
					System.exit(0);

				default: 


				}



			}


		}

	}

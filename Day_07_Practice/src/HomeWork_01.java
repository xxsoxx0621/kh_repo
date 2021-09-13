import java.util.Scanner;

public class HomeWork_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 경마 게임
		// 배당은 2배

		System.out.println("경마 게임에 오신 것을 환영합니다.");
		Scanner sc = new Scanner(System.in);

		int menu = 0;
		int money = 0;
		int choiceHorse = 0;
		int battingMoney = 0;

		while(true) {

			try {
				while(true) {
					System.out.println("1. 게임 시작");
					System.out.println("2. 잔액 충전");
					System.out.println("3. 잔액 조회");
					System.out.println("4. 종료");
					System.out.println("메뉴를 선택해주세요 : " );
					System.out.print(">> ");
					menu = Integer.parseInt(sc.nextLine());
					if(menu > 0 && menu < 5 ) {break;}
				}

			}
			catch(Exception e) {
				System.out.println("다시 입력해 주세요.");
			}

			if(menu == 1) {
				int horse =  (int) (((Math.random()*3)+1));


				try{
					while(true) {
						
						System.out.println("1. 우승 경력이 많지만 은퇴를 앞둔 말");
						System.out.println("2. 이번달 성적이 제일 좋은 말");
						System.out.println("3. 최근 떠오르는 신예인 말 ");
						//배팅 할 말 선택
						System.out.print("배팅 하고 싶은 말을 선택해주세요 >> ");
						choiceHorse = Integer.parseInt(sc.nextLine());

						if(choiceHorse >= 1 && choiceHorse < 4) {break;}
					}
				}
				catch(Exception e) {
					System.out.println("다시 입력해주세요.");
				}

				
				//배팅 금액 설정
				System.out.print("얼마를 배팅하시겠습니까? >>");
				battingMoney = Integer.parseInt(sc.nextLine());

				while(true) {
					if( choiceHorse == horse && money >= battingMoney) {
						money  *= 2 ;
						System.out.println("배팅에 성공했습니다!");
						break;
					}else {
						// 보유 잔액보다 배팅금액이 더 많으면 다시 금액 입력

						if( battingMoney > money ) {
							System.out.println("잔액을 충전해 주세요.");
							break;

							// 보유 잔액보다 배팅금액이 적거나 같으면 
						}else  if (battingMoney <= money){
							money -= battingMoney;
							System.out.println("배팅한 금액인 " + battingMoney + "를 모두 잃으셨습니다.");
							break;
						}

					}
				}
			}
			else if(menu == 2) {
				System.out.println("얼마를 충전하시겠습니까? >> " );
				int getMoney = Integer.parseInt(sc.nextLine());
				money += getMoney;
			}
			else if(menu == 3) {
				System.out.println("현재 잔액은 : " + money + " 입니다.");
			}
			else {
				System.exit(0);
			}


		}
	}

}

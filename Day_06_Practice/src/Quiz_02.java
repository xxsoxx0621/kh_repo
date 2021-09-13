import java.util.Scanner;



public class Quiz_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int money = 3000;
		int coke = 0;
		int sprite = 0;
		int maesil = 0;
		int cPrice = 1000;
		int sPrice = 800;
		int mPrice = 1500;
		int drink = 5;


		while(true) {

			System.out.println("===자판기 시뮬레이터===");
			System.out.println("음료수를 선택하세요.");
			System.out.println("1.콜라(1000) 2.사이다(800) 3.매실차(1500) [0. 소지품 확인]");
			System.out.println(">> ");

			while(true) {
				try {
					drink = Integer.parseInt(sc.nextLine());
					break;
				}catch(Exception e) {
					System.out.println("숫자만 입력 가능합니다.");
					break;
				}

			}

			if(drink  ==  0) {
				System.out.println("=========소지품 목록=========");
				System.out.println("소지금 : " + money);
				System.out.println("콜라 : " + coke + " 개 ");
				System.out.println("사이다 : " + sprite + " 개 ");
				System.out.println("매실차 : " + maesil + " 개 ");

			}else if(drink == 1) {
				if(money >= cPrice) {
					coke += 1; 
					money -= cPrice;
					System.out.println("콜라를 구매했습니다.");
					System.out.println("콜라 + 1 ");
				}else {
					System.out.println("잔액이 부족합니다.");

				}
			}else if(drink == 2) {
				if(money >= sPrice) {
					sprite += 1; 
					money -= sPrice;
					System.out.println("사이다를 구매했습니다.");
					System.out.println("사이다 + 1 ");
				}else {
					System.out.println("잔액이 부족합니다.");

				}
			}else if(drink ==3) {
				if(money >= mPrice) {
					maesil += 1; 
					money -=  mPrice;
					System.out.println("매실차를 구매했습니다.");
					System.out.println("매실차 + 1 " );
				}else {
					System.out.println("잔액이 부족합니다.");

				}
			}else {
				System.out.println("다시 선택해주세요.");
			}
		}

	}
}

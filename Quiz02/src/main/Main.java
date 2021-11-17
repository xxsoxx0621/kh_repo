package main;


import java.util.ArrayList;
import java.util.Scanner;

import manager.Manager;
import menu.Menu;

public class Main {
	public static void main(String[] args) {
		
		int count = 1;
		Manager manager = new Manager();
		
		while(true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("== 카페 메뉴 관리 ==");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 목록 출력");
			System.out.println("3. 메뉴 정보 삭제");
			System.out.println("4. 시스템 종료");
			System.out.print(">> ");
			String num = sc.nextLine();

			if(num.equals("1")) {
				
				System.out.print("메뉴 이름을 입력해주세요 >> ");
				String name = sc.nextLine();
				
				System.out.println("메뉴 가격을 입력해주세요 >> ");
				int price = Integer.parseInt(sc.nextLine());
				
				Menu menu = new Menu(count++,name,price);
				manager.addMenu(menu);
			

			}else if(num.equals("2")) {
				// 메뉴 목록 출력
				
				ArrayList<Menu> am = manager.getMenu();
				
				System.out.println("메뉴번호\t메뉴이름\t메뉴가격");
				for(Menu menu :  am) {
					System.out.println(menu.getId() +"\t"+ menu.getMenuName()+ "\t" +menu.getMenuPrice());
				}

			}else if(num.equals("3")) {
				// 메뉴 목록 출력
				
				ArrayList<Menu> am = manager.getMenu();
			
				System.out.println("메뉴번호\t메뉴이름\t메뉴가격");
				for(Menu menu :  am) {
					System.out.println(menu.getId() +"\t"+ menu.getMenuName()+ "\t" +menu.getMenuPrice());
				}
				// 메뉴 정보 삭제 -  ID로 삭제
				
				System.out.print("삭제할 ID 를 입력해주세요 >> ");
				int delmenu = Integer.parseInt(sc.nextLine());
				
				manager.deleteMenu(delmenu);
				System.out.println(delmenu +"의 "+ + "이 삭제되었습니다.");
			
			}else if(num.equals("4")) {
				 System.out.println("시스템을 종료합니다.");
				 System.exit(0);
				
			}else {
				System.out.println("숫자를 정확히 입력해주세요.");
			}
		}
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import CafeMenuDAO.CafeMenuDAO;
import classes.MenuDTO;

public class Quiz_01 {
	public static void main(String[] args) {

		CafeMenuDAO dao = new CafeMenuDAO();
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.println(" == 메뉴 관리 시스템 == ");
			System.out.println("1. 신규 메뉴 등록");
			System.out.println("2. 메뉴 목록 출력");
			System.out.println("3. 메뉴 정보 수정");
			System.out.println("4. 메뉴 정보 삭제");
			System.out.println("5. 시스템 종료");
			System.out.print(">> ");
			String menu = sc.nextLine();

			try {
				if(menu.equals("1")) {
					System.out.print("메뉴 이름 : ");
					String name = sc.nextLine();

					System.out.print("메뉴 가격 : ");
					int price = Integer.parseInt(sc.nextLine());

					int result = dao.insert(name,price);
					if(result > 0) {
						System.out.println("입력 완료.");
					}


				}else if(menu.equals("2")) {
					
				ArrayList<MenuDTO> list = dao.selectAll();
				for(MenuDTO m : list) {
					System.out.println(m.getId() + " : " + m.getName() + " : " + m.getPrice()+ " : "  + m.getDateString());
				}
					
					
				}else if(menu.equals("3")) {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}

					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String userName = "kh";
					String password = "kh";

					Connection con = DriverManager.getConnection(url,userName,password);
					Statement stat = con.createStatement();

					String sql = "select * from cafe_menu order by 1";
					ResultSet rs = stat.executeQuery(sql);

					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int price = rs.getInt("price");
						System.out.println(id + " : " + name + " : " + price);
					}
					con.close();


					// ID를 기준으로 메뉴이름과 가격 동시에 수정하기
					System.out.print("수정할 메뉴의 ID : ");
					int id = Integer.parseInt(sc.nextLine());

					//               con = DriverManager.getConnection(url,userName,password);
					//               stat = con.createStatement();
					//               
					//               rs = stat.executeQuery("select * from cafe_menu where id = " + id);
					//               if(!rs.next()) {
					//                  System.out.println("대상을 찾을 수 없습니다.");
					//                  con.close();
					//                  continue;
					//               }

					System.out.print("메뉴의 새 이름 : ");
					String name = sc.nextLine();

					System.out.print("메뉴의 새 가격 : ");
					int price = Integer.parseInt(sc.nextLine());
					
					System.out.println("메뉴의 새 등록일 (yyyy/MM/dd): ");
					String reg_date = sc.nextLine();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
					Date utilDate = sdf.parse(reg_date);
					
					// 같은 이름의 라이브러리를 2개 이상 import 할 때
					java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
					
					int result = dao.update(new MenuDTO(id,name,price,sqlDate));
					
					if(result > 0) {
						System.out.println("변경 성공");
					}
				}else if(menu.equals("4")) {
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
					} catch (Exception e) {
						e.printStackTrace();
						System.exit(0);
					}

					String url = "jdbc:oracle:thin:@localhost:1521:xe";
					String userName = "kh";
					String password = "kh";
					
					// ID를 기준으로 데이터 삭제하기.
					Connection con = DriverManager.getConnection(url,userName,password);
					Statement stat = con.createStatement();

					String sql = "select * from cafe_menu order by 1";
					ResultSet rs = stat.executeQuery(sql);

					while(rs.next()) {
						int id = rs.getInt("id");
						String name = rs.getString("name");
						int price = rs.getInt("price");
						System.out.println(id + " : " + name + " : " + price);
					}
					con.close();

					System.out.print("삭제 할 ID 입력 : ");
					int id = Integer.parseInt(sc.nextLine());

					int result = dao.delete(id);
					if(result > 0) {
						System.out.println("삭제  성공");
					}
				}else if(menu.equals("5")) {
					System.out.println("시스템을 종료합니다.");
					System.exit(0);
				}else {
					System.out.println("메뉴를 다시 확인하세요.");
				}
			}catch(Exception e) {
				e.printStackTrace(); // 개발자가 에러 확인
				System.out.println("요청하신 기능을 수행하는 중 오류가 발생했습니다.");
				System.out.println("같은 오류가 반복될 시, 관리자에게 문의해주세요.");
				System.out.println("E-mail : admin@company.com");
			}
		}

	}
}
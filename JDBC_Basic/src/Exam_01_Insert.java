import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam_01_Insert {
	public static void main(String[] args) {
		
		// OJDBC : Oracle Java DataBase Connection
		
		// 1.OJBC 드라이버 로딩
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println("OJDBC 드라이버를 발견 하지 못함.");
			System.exit(0);
		}
		
		// 2. DBMS 에 CONNECTION 접속
		String url ="jdbc:oracle:thin:@localhost:1521:xe";
		String username ="kh";
		String password ="kh";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			
			// 3. Query를 전달할 수 있는 인스턴스를 생성
			Statement stat = con.createStatement();
			
			String sql = "insert into cafe_menu values(cafe_menu_seq.nextval,'cafe Latte',2500)";
			int result = stat.executeUpdate(sql);
			
			System.out.println("결과 : " + result);
			
			if(result > 0) {
				System.out.println("성공적으로 입력되었습니다.");
			}else {
				System.out.println("입력에 실패했습니다.");
			}
			
			// 버전 8은 autocommition 
			//con.commit();
			
			// 커넥션을 닫아라. -> 반드시
			con.close();
			
			// executeQuery : select
			// ececuteUpdate : insert, update,delete
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			System.out.println("접속에 실패");
			System.exit(0);
			
		}
	}
}

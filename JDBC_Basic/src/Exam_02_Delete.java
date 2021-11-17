import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam_02_Delete {

	public static void main(String[] args) {

		// 1.OJBC 드라이버 로딩

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e){
			System.out.println("OracleDriver를 발견하지 못함");
			System.exit(0);
		}

		// 2. DBMS 에 CONNECTION 접속
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username ="kh";
		String password ="kh";
		
		try {
			Connection con = DriverManager.getConnection(url,username,password);
			
			// 쿼리에 넣을 수 있는 인스턴스 생성
			
			Statement stat = con.createStatement();
			String sql = "delete from cafe_menu";
			int result = stat.executeUpdate(sql);
			
			System.out.println("결과 " + result);
			
			if(result > 0 ) {
				System.out.println("성공적으로 입력되었습니다.");
			}else {
				System.out.println("실패하였습니다.");
			}
	
			con.close();
			
			
		}catch(Exception e){
			e.printStackTrace();
			// TODO Auto-generated catch block
			System.out.println("접속에 실패");
			System.exit(0);
		}
	}
}
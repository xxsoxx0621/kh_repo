import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Exam_03_Update {


	public static void main(String[] args) {


		//1. 드라이버 로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(0);
		}

		try {

			//2. connection 생성
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String userName ="kh";
			String password="kh";
			Connection con = DriverManager.getConnection(url,userName,password);

			//3. Statment 객체 생성
			Statement stat = con.createStatement();

			//4.Query 전달
			String sql = "update cafe_menu set price=2000 where name ='Amerciano'";
			int result = stat.executeUpdate(sql);

			//5.return 값에 따른 결과 출력

			if(result > 0 ) {
				System.out.println("변경 성공");
			}else {
				System.out.println("변경 실패");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
}

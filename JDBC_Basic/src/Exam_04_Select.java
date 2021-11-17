import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Exam_04_Select {

	public static void main(String[] args) {


		// 1. 드라이버 로딩

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		try {

			//2.Connection 객체 생성

			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			String userName = "kh";
			String password = "kh";
			Connection con = DriverManager.getConnection(url,userName,password);

			// 3. Statement 객체 생성
			Statement stat = con.createStatement();

			String sql = "select * from cafe_menu";
			ResultSet rs = stat.executeQuery(sql);

			if(rs.next()) {
				int id = rs.getInt("id"); // rs.getInt(1);
				String name = rs.getString("name"); // rs.getString(2);
				int price = rs.getInt("price"); // rs.getInt(3);
				System.out.println(id +  " : " + name + " : " + price);
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}


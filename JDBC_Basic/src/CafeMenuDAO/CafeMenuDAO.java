package CafeMenuDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import classes.MenuDTO;

public class CafeMenuDAO {

	private Connection getConnection() throws Exception {
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
		return con;
	}

	public int insert(String name, int price) throws Exception {


		// try - catch
		// try - catch - catch - catch -- 멀티캐치
		// try - catch - finally
		// try - finally
		// try with resource

		String sql ="insert into cafe_menu values(cafe_menu_seq.nextval, ?, ?, default)";
		// try 구문을 쓰면 반드시 close가 된다 -> 데이터베이스가 꺼져버리는 현상이 생기지 않음
		try (Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){

			// 다른 버전 
			//		Statement stat = con.createStatement();
			//		String sql = "insert into cafe_menu values(cafe_menu_seq.nextval,'"+name+"',"+price+")";
			//		int result = stat.executeUpdate(sql);

			// query를 날릴 때, 씀 


			pstat.setString(1, name); // 1번 물음표에 name 값을 할당 
			pstat.setInt(2, price); // 2번 물음표에 price 값을 할당 
			int result = pstat.executeUpdate();

			// con.close();
			return result;
		}

	}

	public int update(MenuDTO dto) throws Exception {


		String sql = "update cafe_menu set name= ?, price= ? reg_date = ? where id=?";

		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

			//Statement stat = con.createStatement();


			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setDate(3, dto.getReg_date());
			pstmt.setInt(4, dto.getId());

			int result = pstmt.executeUpdate();

			con.commit();
			return result;
		}
	}

	public int delete(int id) throws Exception {


		String sql = "delete from cafe_menu where id = ?";

		try(	Connection con = getConnection();
				PreparedStatement ptmt = con.prepareStatement(sql);
				) {


			ptmt.setInt(1, id);
			int result = ptmt.executeUpdate(sql);

			con.commit();

			return result;
		}
	}

	public ArrayList<MenuDTO> selectAll() throws Exception{

		

		String sql = "select * from cafe_menu order by 1";
		
		try(Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			ResultSet rs = pstmt.executeQuery(sql);

			ArrayList<MenuDTO> result = new ArrayList<>();

			while(rs.next()) {

				int id = rs.getInt("id");
				String name = rs.getString("name");
				int price = rs.getInt("price");
				Date reg_date = rs.getDate("reg_date");

				MenuDTO m = new MenuDTO(id,name,price,reg_date);
				result.add(m);
			}
			return result;
		}
	}

}

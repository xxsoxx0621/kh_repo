package dao;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.MemberDTO;


public class MemberDAO {
		//1.DAO 에 사용되는 Connection DBCP로 변경하세요.
		
		//2. 삭제/ 검색 기능 만들기
	
		private	static BasicDataSource bds = new BasicDataSource();
		
		private static MemberDAO instance = null;
		
		public static MemberDAO getInstance() {
			if(instance == null) {
				instance = new MemberDAO();
			}
			return instance;
		}
		public MemberDAO() {
			
			bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
			bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
			bds.setUsername("practice");
			bds.setPassword("practice");
		
			bds.setInitialSize(30);
		}
		public Connection getConnection() throws Exception {
		
		
		return bds.getConnection();
	}

	public int insert(String id, String pw, String name) throws Exception {

		Connection con = getConnection();
		String sql ="insert into members values(?,?,?,default)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, id);
		pstmt.setString(2, pw);
		pstmt.setString(3, name);

		int result = pstmt.executeUpdate();
		return result;
	}

	public boolean isIdExist (String id) throws Exception{

		String sql = "select * from members where id = ? ";
		try(Connection con = this.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1,id);
			try(ResultSet rs = pstmt.executeQuery()){
				return rs.next();
			}
		}
	}

	public MemberDTO login(String id, String pw) throws Exception{


		String sql ="select * from members where id =? and pw =?";
		try(Connection con = this.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, id);
			pstmt.setString(2, pw);

			try(ResultSet rs = pstmt.executeQuery()){
				MemberDTO dto = null;

				if(rs.next()) {
					dto  = new MemberDTO();
					dto.setId(rs.getString("id"));
					dto.setName(rs.getString("name"));
					dto.setSignup_date(rs.getDate("signup_date"));
					return dto;
				}

			}
			return null;

		}
	}
}


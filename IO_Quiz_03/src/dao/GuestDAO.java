package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.GuestDTO;

public class GuestDAO {


	private static BasicDataSource bds = new BasicDataSource();

	private static GuestDAO instance = null;

	public static GuestDAO getInstance() {
		if(instance == null) {
			instance = new GuestDAO();
		}
		return instance;
	}

	public GuestDAO () {
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("practice");
		bds.setPassword("practice");
		bds.setInitialSize(30);
	}


	public Connection getConnection() throws Exception {

		return bds.getConnection();

	}

	public int insert(String name, String msg) throws Exception{

		String sql = "insert into GuestBook values(GuestBook_seq.nextval, ?, ? , default)";
		Connection con = getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1, name);
		pstmt.setString(2, msg);

		int result = pstmt.executeUpdate();

		return result;


	}

	public ArrayList<GuestDTO> selectAll() throws Exception {

		String sql = "select * from GuestBook order by 1 ";
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){

			ResultSet rs = pstmt.executeQuery();
			ArrayList<GuestDTO> result = new ArrayList<GuestDTO>();

			while(rs.next()) {
				int seq = rs.getInt("seq");
				String writer = rs.getString("writer");
				String msg = rs.getString("message");
				Date write_date = rs.getDate("write_date");

				GuestDTO dto = new GuestDTO(seq,writer,msg,write_date);
				result.add(dto);	
			}

			return result;
		}
	}

	public int delete(int id) throws Exception{

		String sql ="delete from GuestBook where seq = ?";
		try(
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){

			pstmt.setInt(1, id);

			int result = pstmt.executeUpdate();

			return result;
		}

	}
	
	public List<GuestDTO> searchSeq(int seq) throws Exception{
		
		String sql ="select * from GuestBook where seq =? ";
		
		try( Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)){
			
			
			ArrayList<GuestDTO> result = new ArrayList<GuestDTO>();
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int id = rs.getInt("seq");
				String writer = rs.getString("writer");
				String msg = rs.getString("message");
				Date write_date = rs.getDate("write_date");

				GuestDTO dto = new GuestDTO(seq,writer,msg,write_date);
				result.add(dto);	
			}

			return result;
		}
		
	}
}

package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.dbcp2.BasicDataSource;

import dto.MessageDTO;


public class MessageDAO {

//	//getConnection() 안에 넣으면 커넥션 풀을 계속 만듦
//	// static은 메인이 시작될 떄 한번만 시작된다.
	
	
	//Singleton Design Pattern
	//클래스의 인스턴스가 한개 이상 생성되지 않게 통제하는 기법
	
	
	private static BasicDataSource bds = new BasicDataSource(); // Connection pool
	
	private static MessageDAO instance = null;
	
	
	public static MessageDAO getInstance() {
		if(instance == null) {
			instance = new MessageDAO();
		}
		return instance;
	}
	
	//getConnection()이 아니라 생성자에 넣어주면 한 번만 실행
	public MessageDAO() {
		
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		bds.setUsername("practice");
		bds.setPassword("practice");
		bds.setInitialSize(30);
	}
	
	private Connection getConnection () throws Exception{
		
		// 1.  DBCP 라이브러리 가져오기.
			return bds.getConnection();
	
//		//1.OJBC 드라이버 로딩 
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.exit(0);
//		}
//
//		//2. DBMS 에 Connection 접속
//
//		String url ="jdbc:oracle:thin:@localhost:1521:xe";
//		String userName ="practice";
//		String passWord ="practice";
//
//		Connection con = DriverManager.getConnection(url,userName,passWord);
//		return con;

	}

	public int insert(String writer,String message, Date date) throws Exception {

		Connection con = getConnection();
		//stat = con.createStatement();

		String sql ="insert into message values(sequence_seq.nextval,?,?,?)";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setString(1, writer);
		pstat.setString(2, message);
		pstat.setDate(3, date);

		int result = pstat.executeUpdate();

		con.close();

		return result;

	}

	public ArrayList<MessageDTO> selectAll() throws Exception {

		Connection con = getConnection();
		Statement stat = con.createStatement();

		String sql ="select * from message order by 1";
		ResultSet rs = stat.executeQuery(sql);

		ArrayList<MessageDTO> result = new ArrayList<MessageDTO>();

		while(rs.next()) {

			int id = rs.getInt("seq");
			String writer = rs.getString("writer");
			String message = rs.getString("message");
			Date reg_date = rs.getDate("reg_date");

			MessageDTO m = new MessageDTO(id,writer,message,reg_date);
			result.add(m);
		}
		con.close();
		return result;

	}

	public int delete(int delNum) throws Exception{
		Connection con = getConnection();
		//Statement stat = con.createStatement();

		String sql = "delete from message where seq =  ? ";
		PreparedStatement pstat = con.prepareStatement(sql);
		pstat.setInt(1, delNum);
		int result = pstat.executeUpdate();

		con.close();
		return result;

	}

	public int update( int upNum, String message, Date reg_date)throws Exception {

		Connection con = getConnection();
		//Statement stat = con.createStatement();


		String sql =" update message set message = ? ,reg_date =? where seq = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, message);
		pstmt.setDate(2, reg_date);
		pstmt.setInt(3, upNum);
		int result = pstmt.executeUpdate();

		con.close();
		return result;
	}

	public MessageDTO searchId(int searchId) throws Exception {


		String sql = " select * from message where seq = ?";

		try (	Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);){

			pstmt.setInt(1, searchId);

			try (	ResultSet rs = pstmt.executeQuery();){
				MessageDTO dto = null;

				if(rs.next()) {
					int id = rs.getInt("seq");
					String writer = rs.getString("writer");
					String message = rs.getString("message");
					Date reg_date = rs.getDate("reg_date");

					dto = new MessageDTO(id,writer,message,reg_date);
				}	

				return dto;		
			}

		}
	}

	public ArrayList<MessageDTO> searchName(String searchName) throws Exception{


		String sql = "select * from message where writer = ? order by 1";


		// try 문 안에는 close를 해야하는 변수 또는 인스턴스를 초기화 하는 코드만 올 수 있음 
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				) {

			pstmt.setString(1,searchName);

			try(ResultSet rs = pstmt.executeQuery()){
				ArrayList<MessageDTO> result = new ArrayList<>();

				while(rs.next()) {
					int id = rs.getInt("seq");
					String name = rs.getString("writer");
					String message = rs.getString("message");
					Date reg_date = rs.getDate("reg_date");


					MessageDTO m = new MessageDTO(id,name,message,reg_date);
					result.add(m);		
				}

				return result;

			}

		}

	}
}

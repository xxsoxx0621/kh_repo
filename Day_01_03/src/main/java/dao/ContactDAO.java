package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import dto.ContactDTO;
import servlets.Servlet01;

public class ContactDAO {
	
//	private BasicDataSource bds = new BasicDataSource();
	
	private static ContactDAO instance = null;
	public  static ContactDAO getInstance() {
		if(instance == null) {
			instance = new ContactDAO();
		}
		return instance;
	}
	public ContactDAO() {
//		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		bds.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		bds.setUsername("kh");
//		bds.setPassword("kh");
//		bds.setInitialSize(30);
	}
	
	// singleton 관련 코드 
	
	private Connection getConnection() throws Exception{
		
		//JNDI 관련코드
		Context ctx = new InitialContext();
		
		DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
		return ds.getConnection();
//		return bds.getConnection();
		
		
//		// 데이터베이스 접속
//		String userName = "kh";
//		String passWord = "kh";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			
//		// db dao 부분
//
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			Connection con =  DriverManager.getConnection(url,userName,passWord);
//			return con;
	}
		
		public int insert(String name, String contact) throws Exception {
		
			String sql = "insert into contact values(contact_seq.nextval,?,?)";
			
			try(Connection con = this.getConnection(); 
				PreparedStatement pstat = con.prepareStatement(sql);){
					pstat.setString(1, name);
					pstat.setString(2, contact);
					int result = pstat.executeUpdate();
					return result;
			} 
		}
		
		public List<ContactDTO>  selectAll() throws Exception{
			
			String sql = "select * from contact order by 1";
			
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql);
					ResultSet rs = pstat.executeQuery();){
			
			// 동적배열
			List<ContactDTO> list = new ArrayList<ContactDTO>();
			
				while(rs.next()) {
					int seq = rs.getInt("seq");
					String name = rs.getString("name");
					String contact = rs.getString("contact");
					
					ContactDTO dto= new ContactDTO(seq,name,contact);
					list.add(dto);
				}
				return list;
				
				
				
			}
		}
		
		public int delete(int delID) throws Exception{
			
			String sql = "delete from contact where seq= ?";
			
			try(Connection con = this.getConnection();
					PreparedStatement pstat = con.prepareStatement(sql)){
				pstat.setInt(1, delID);
				int result = pstat.executeUpdate();
				return result;
			}
			
			
		}
		
		public int update(String name, String contact, int id) throws Exception{
			String sql = "update contact set name = ?, contact = ?  where seq = ? ";
			
			
			try(Connection con = this.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
					){
				
				pstat.setString(1, name);
				pstat.setString(2, contact);
				pstat.setInt(3, id);
				
				int result = pstat.executeUpdate();
				
				return result;
			}
				
				
					
		
		
			
		}
		
	}


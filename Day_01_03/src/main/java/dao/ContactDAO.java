package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.ContactDTO;
import servlets.Servlet01;

public class ContactDAO {
	
	private Connection getConnection() throws Exception{
		
		// 데이터베이스 접속
		String userName = "kh";
		String passWord = "kh";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
		// db dao 부분

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con =  DriverManager.getConnection(url,userName,passWord);
			return con;
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


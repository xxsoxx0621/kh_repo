package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import dto.StudentDTO;

public class StudentDAO {
	
	private Connection getConnection() throws Exception {
		
		
			String id = "Study";
			String pw = "Study";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(url,id,pw);
			
			return con;
		
				
	}
	
 	public int insert(String name, int kor, int eng ) throws Exception {
 		
 		String sql = "insert into student values(student_seq.nextval,?,?,?) ";
 		
 		try(Connection con = this.getConnection();
 				PreparedStatement pstat = con.prepareStatement(sql);){
 			
 			pstat.setString(1, name);
 			pstat.setInt(2, kor);
 			pstat.setInt(3, eng);
 			int result = pstat.executeUpdate();
 			return result;
 		
 		}
		
	}
 	
 	public List<StudentDTO> selectAll() throws Exception{
 		
 		String sql = "select * from student order by 1";
 		
 		try(Connection con = this.getConnection();
 				PreparedStatement pstat = con.prepareStatement(sql);
				ResultSet rs = pstat.executeQuery();){
 		// 동적배열
 					List<StudentDTO> list = new ArrayList<StudentDTO>();
 					
 						while(rs.next()) {
 							int seq = rs.getInt("id");
 							String name = rs.getString("name");
 							int kor = rs.getInt("kor");
 							int eng = rs.getInt("eng");
 							
 							StudentDTO dto= new StudentDTO(seq,name,kor,eng);
 							list.add(dto);
 						}
 						return list;
 						
 			
 		}
 		
 	}
 	
 	public int delete(int delId) throws Exception {
 		
 		String sql = "delete from student where id = ? ";
 		
 		try(Connection con = this.getConnection();
 				PreparedStatement pstat = con.prepareStatement(sql)){
 			pstat.setInt(1, delId);
 			int result = pstat.executeUpdate();
 			return result;
 		}
 	}
}

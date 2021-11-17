package movieDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import movieDTO.MovieDTO;

public class MovieDAO {

	MovieDTO mDto = new MovieDTO();

	private Connection getConnection() throws Exception{
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("연결이 불가능 합니다.");
		}
	

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "practice";
		String pw = "practice";

		Connection con = DriverManager.getConnection(url,id,pw);
		return con;

	}
	public int insert(String title,String dec, Date date) throws Exception {



		Connection con = getConnection();

		String sql = "insert into movies values(movie_seq.nextval,?,?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setString(1,title);
		pstmt.setString(2,dec);
		pstmt.setDate(3,date);
		
		
		int result = pstmt.executeUpdate();
		con.close();
		return result;


	}
	public List<MovieDTO> selectAll() throws Exception{
		
		Connection con = getConnection();
		
		String sql = "select * from movies order by 1";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		ArrayList<MovieDTO> result = new ArrayList<MovieDTO>();
		while(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String dsc = rs.getString("description");
			Date rel_date = rs.getDate("rel_date");
			
			MovieDTO mDto = new MovieDTO(id,title,dsc,rel_date);
			result.add(mDto);
		}
		con.close();
		return result;
	}
	
	public int delete (String delId) throws Exception {
		
		Connection con = getConnection();
		
		String sql = "delete from movies where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, delId);
		
		int result = pstmt.executeUpdate();
		
		return result;
		
		
	}
	
	public int update (String Id, String title, String dec, Date date) throws Exception{
		Connection con = getConnection();
		
		String sql = "update movies set title =? ,description = ?,rel_date =? where id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, title );
		pstmt.setString(2, dec );
		pstmt.setDate(3, date );
		pstmt.setString(4, Id );
		
		int result = pstmt.executeUpdate();
		con.close();
		return result;
		
		
	}
	
	public MovieDTO selectById(int searchId) throws Exception{
		
		Connection con = getConnection();
		
		String sql = "select * from movies where id = ? order by 1";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, searchId);
		
		ResultSet rs = pstmt.executeQuery();
		
		MovieDTO mDto = null;
		
		if(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String dsc = rs.getString("description");
			Date rel_date = rs.getDate("rel_date");
			
			mDto = new MovieDTO(id,title,dsc,rel_date);
			
		}
		con.close();
		return mDto;
	}
	
	public MovieDTO selectByTitle(String searchTitle ) throws Exception{
		
		Connection con = getConnection();
		String sql = "select * from movies where title = ?  order by 1";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		pstmt.setString(1, searchTitle);
		
		MovieDTO mDto = new MovieDTO();
		
		mDto = null;
		
		if(rs.next()) {
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String dsc = rs.getString("description");
			Date rel_date = rs.getDate("rel_date");
			
			
			mDto = new MovieDTO(id,title,dsc,rel_date);
			
		}
		con.close();
		return	mDto;
	}
}

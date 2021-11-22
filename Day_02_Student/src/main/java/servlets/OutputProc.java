package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.StudentDTO;


@WebServlet("/OutputProc")
public class OutputProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		StudentDAO dao = new StudentDAO();
		try {
			
			List<StudentDTO> list = dao.selectAll();
			pw.append("<html>");
			pw.append("<head>");
			pw.append("</head>");
			pw.append("<body>");
			pw.append("<table border=1 text-align=center>");
			pw.append("<tr>");
			pw.append("<th colspan = 6> Contents");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td> ID");
			pw.append("<td> NAME");
			pw.append("<td> KOR");
			pw.append("<td> ENG");
			pw.append("<td> SUM");
			pw.append("<td> AVG");
			pw.append("</tr>");
			pw.append("<tr>");
			for(StudentDTO dto : list) {
				pw.append("<tr>");
				pw.append("<td>" + dto.getId());
				pw.append("<td>" + dto.getName());
				pw.append("<td>" + dto.getKor());
				pw.append("<td>" + dto.getEng());
				pw.append("<td>" + (dto.getEng()+dto.getKor()));
				pw.append("<td>" + ((dto.getEng()+dto.getKor())/2));
				pw.append("</tr>");
			}
			
			pw.append("</tr>");
			pw.append("<form action='DeleteProc'>");
			pw.append("<tr>");
			pw.append("<td colspan=4><input type='text' name='delID' placeholder='Input delete ID' >");
			pw.append("<td colspan=2 align=center><button>delete</button>");
			pw.append("</tr>");
			pw.append("</form>");
			pw.append("<tr>");
			pw.append("<td colspan=4><input type='text' name='delID' placeholder='Input name to change' >");
			pw.append("</tr>");
			pw.append("<tr>");
			pw.append("<td colspan=6 align=center><a href='index.html'>BACK</a>");
			pw.append("</tr>");
			pw.append("</table>");
			pw.append("</body>");
			pw.append("</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

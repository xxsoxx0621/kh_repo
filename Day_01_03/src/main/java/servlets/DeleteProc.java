package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;


@WebServlet("/DeleteProc")
public class DeleteProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int delID = Integer.parseInt(request.getParameter("delID"));
		
		ContactDAO dao = new ContactDAO();
		
		try {
			int result = dao.delete(delID);
			response.sendRedirect("OutputProc");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

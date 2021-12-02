package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.StudentDAO;

@WebServlet("/DeleteProc")
public class DeleteProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int delID = Integer.parseInt(request.getParameter("delID"));
		
		StudentDAO dao = StudentDAO.getInstance();
		
		try {
			int result = dao.delete(delID);
			response.sendRedirect("OutputProc");
		}catch(Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;


@WebServlet("/UpdateProc")
public class UpdateProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("updateName");
		String contact = request.getParameter("updateContact");
		int seq = Integer.parseInt(request.getParameter("target"));
		
		ContactDAO dao = new ContactDAO();
		
		try {
			dao.update(name, contact, seq);
			response.sendRedirect("OutputProc");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

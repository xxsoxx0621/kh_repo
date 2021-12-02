package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;


@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ContactDAO dao = ContactDAO.getInstance();
		
		// index.html에서 입력값 받아오기
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		
		try {
			int result = dao.insert(name,contact);
			request.getRequestDispatcher("InputView.jsp").forward(request, response);
			
//			response.sendRedirect("InputView.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.sendRedirect("error.html");
		}
		
		
	
		
//		System.out.println(name+"님의 연락처 : " + contact);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}

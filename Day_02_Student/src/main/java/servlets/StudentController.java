package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDAO;
import dto.StudentDTO;


@WebServlet("*.con")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		// 요청한 주소를 받고
		String uri = request.getRequestURI();
		
		// 경로를 받아온다.
		String ctxPath = request.getContextPath();
		
		//경로의 길이 값을 받아온다.
		String cmd = uri.substring(ctxPath.length());
		
		StudentDAO dao = StudentDAO.getInstance();
		try {
			
			if(cmd.equals("/input.con")) {
				String name = request.getParameter("name");
				int korScore = Integer.parseInt(request.getParameter("kor"));
				int engScore =  Integer.parseInt(request.getParameter("eng"));
				dao.insert(name, korScore, engScore);
				response.sendRedirect("index.html");
				
			}else if(cmd.equals("/output.con")) {
				
				List<StudentDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);

			}else if(cmd.equals("/delete.con")) {
				int delID = Integer.parseInt(request.getParameter("delID"));
					int result = dao.delete(delID);
					response.sendRedirect("output.con");
			
			
			}
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

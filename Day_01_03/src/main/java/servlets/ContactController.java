package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ContactDAO;
import dto.ContactDTO;


@WebServlet("*.con")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(".con 요청이 도착했습니다.");
		
		String uri = request.getRequestURI();
		System.out.println("사용자가 요청한 주소 : " + uri);
		
		String ctxPath = request.getContextPath();
		System.out.println("프로젝트명 : " + ctxPath);
		
		String cmd = uri.substring(ctxPath.length());
		System.out.println("사용자가 요청한 기능 : " + cmd);
		
		ContactDAO dao = ContactDAO.getInstance();
		
		try {
			
			if(cmd.equals("/output.con")) {

				List<ContactDTO> list = dao.selectAll();
				request.setAttribute("list", list);
				request.getRequestDispatcher("outputView.jsp").forward(request, response);

			
			}else if(cmd.equals("/input.con")) {
				
				String name = request.getParameter("name");
				String contact = request.getParameter("contact");
				int result = dao.insert(name,contact);
				response.sendRedirect("index.html");
				
			}else if(cmd.equals("/modify.con")) {
				
				String name = request.getParameter("updateName");
				String contact = request.getParameter("updateContact");
				int seq = Integer.parseInt(request.getParameter("target"));
				dao.update(name, contact, seq);
				
			}else if(cmd.equals("/delete.con")) {

				int delID = Integer.parseInt(request.getParameter("delID"));
				int result = dao.delete(delID);
				response.sendRedirect("output.con");
				
			}else if(cmd.equals("/contact.con")) {
				response.sendRedirect("contact.html");
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

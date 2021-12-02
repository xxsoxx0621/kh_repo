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

import dao.ContactDAO;
import dto.ContactDTO;


@WebServlet("/OutputProc")
public class OutputProc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		String [] arr = new String[] {"Apple","Mango","Orange"};
//		ContactDTO dto = new ContactDTO(100,"ABC","DEF");
//		
//		List<ContactDTO> list = new ArrayList<>();
//		list.add(new ContactDTO(1,"ABC","DEF"));
//		list.add(new ContactDTO(2,"GHI","JKL"));
//		list.add(new ContactDTO(3,"MNO","PQR"));
//		
//		request.setAttribute("simple1", 15);
//		request.setAttribute("simple2", "Hello");
//		request.setAttribute("array", arr);
//		request.setAttribute("contact", dto);
//		request.setAttribute("list", list);
		
		
		//RequestDispatcher 메소드는 요청 재지정에 사용된다.
		
		//forward(ServletRequest req, ServletResponse resp)
		//forward() 메소드는 클라이언트의 요청으로 생성되는 HttpServletRequest HttpServletResponse 객체를
		// 다른 자원에 전달하고 수행 제어를 완전히 넘겨서 다른 자원의 수행 결과를 클라이언트로 응답하도록 하는 기능의 메소드
		ContactDAO dao = ContactDAO.getInstance();
		try {
			List<ContactDTO> list = dao.selectAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("outputView.jsp").forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
//		request.getRequestDispatcher("outputView.jsp").forward(request, response);
		
		
		//		
//		PrintWriter pw = response.getWriter();
//		ContactDAO dao = ContactDAO.getInstance();
//		
//		try{
//			
//			List<ContactDTO> list = dao.selectAll();
//			
//			pw.append("<html>");
//			pw.append("<head>");
//			pw.append("<style>");
//			pw.append("table{text-align:center}");
//			pw.append("</style>");
//			pw.append("</head>");
//			pw.append("<body>");
//			pw.append("<table border=1 align=center>");
//			pw.append("<tr>");
//			pw.append("<th colspan=3>Contacts");
//			pw.append("</tr>");
//			pw.append("<tr>");
//			pw.append("<th>Num");
//			pw.append("<th>Name");
//			pw.append("<th>Contacts");
//			pw.append("</tr>");
//			
//			for(ContactDTO  dto : list) {
//			
////				response.getWriter().append("dto.getSeq()+":"+dto.getName()+":"+ dto.getContact()+"<br>");
//				
//				pw.append("<tr>");
//				pw.append("<td>"+dto.getSeq());
//				pw.append("<td>"+dto.getName());
//				pw.append("<td>"+dto.getContact());
//				pw.append("</tr>");
//			}
//			pw.append("<form action='DeleteProc'>");
//			pw.append("<tr>");
//			pw.append("<td colspan=3> <input type=text name=delID placeholder='Input id to delete'>");
//			pw.append("<button>Delete</button>");
//			pw.append("</tr>");
//			pw.append("</form>");
//		
//			pw.append("<form action='UpdateProc'>");
//			pw.append("<tr>");
//			pw.append("<td colspan=2><input type=text name=updateName placeholder='Input name to change'>");
//			pw.append("<td rowspan=3>");
//			pw.append("<button>Modify</button>");
//			pw.append("</tr>");
//			
//			pw.append("<tr>");
//			pw.append("<td colspan=2><input type=text  name=updateContact  placeholder='Input contact to change'>");
//			pw.append("</tr>");
//			
//			pw.append("<tr>");
//			pw.append("<td colspan=2><input type=text name=target placeholder='Input target to modify'>");
//			pw.append("</tr>");
//			
//			pw.append("<tr>");
//			pw.append("<th colspan=3 align=center><a href='index.html'>BACK</a>");
//			pw.append("</tr>");
//			pw.append("</form>");
//			pw.append("</table>");
//			pw.append("</body>");
//			
//			pw.append("</html>");
//		}catch(Exception e) {
//			e.printStackTrace();
//			response.sendRedirect("error.html");
//		}
//		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

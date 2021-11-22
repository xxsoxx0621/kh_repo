package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 중복 안됌 - 하나의 서블릿에는 하나의 이름만 가능
@WebServlet("/Exam_01")
public class Exam_01 extends HttpServlet {
	
//	서블렛이 하는 역할
//	 1. 클라이언트의 요청을 처리한다.
//	 2. 처리된 요청에 대한 결과를 알려준다.

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 작업의 처리
		String currentTime = new Date().toString();
		
		// Response 를 작성하는 작업
		PrintWriter pw = response.getWriter();
		pw.append(currentTime);
		
		System.out.println("클라이언트가 Get방식으로 Request를 발송했음");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("클라이언트가 Get방식으로 Post를 발송했음");
	}

}

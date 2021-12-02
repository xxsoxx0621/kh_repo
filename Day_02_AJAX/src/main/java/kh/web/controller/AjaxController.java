package kh.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import kh.web.dto.ContactDTO;


@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {

  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		// 더 편한 방법 // 다양하게 쓰이기 때문에 메서드 지역변수로 올려놓기
		Gson g = new Gson();
		
		String requestURI = request.getRequestURI();
		String ctxPath = request.getContextPath();
		
		String cmd = requestURI.substring(ctxPath.length());
		
		System.out.println(cmd);
		
		if(cmd.equals("/exam01.ajax")) {
			
			System.out.println("exam01 : 비동기 요청 확인");
			
		}else if(cmd.equals("/exam02.ajax")) {
			
			String key1 = request.getParameter("key1");
			String key2 = request.getParameter("key2");
		
			
			System.out.println(key1 +" : " + key2);
		}else if(cmd.equals("/exam03.ajax")){
			System.out.println("exam03 : 비동기 요청 확인");
			response.getWriter().append("Ajax Response!!");
			
		}else if(cmd.equals("/exam04.ajax")){
			String[] arr = new String[] {"Apple","Orange","Mango"};
//			
//			String result = arr[0]+":"+arr[1]+":"+arr[2];
			
			// 자바스크립트의 배열 형태로 바뀌어서 나오게 된다.
			JsonArray jsonArr = new JsonArray();
		
			
			String result = g.toJson(arr);
			
			response.getWriter().append(result);
			
			//	덜 편한 방법
//			jsonArr.add(arr[0]);
//			jsonArr.add(arr[1]);
//			jsonArr.add(arr[2]);
//			System.out.println(jsonArr.toString());
			
			
		}else if(cmd.equals("/exam05.ajax")) {
			
			ContactDTO dto = new ContactDTO(1001,"Tom","01012344321");
			
			 String result = g.toJson(dto);
			 System.out.println(result); //	 해당 쿼리의 결과값으로 -> {id:1001,name:"Tom",contact:"01043211234"}
			 response.getWriter().append(result);
			
		}else if(cmd.equals("/exam06.ajax")) {
			
			List<ContactDTO> list = new ArrayList<>();
			list.add(new ContactDTO(1001,"Tom","01012344321"));
			list.add(new ContactDTO(1002,"Jane","01011111111"));
			list.add(new ContactDTO(1003,"Mike","01013231321"));
			
			
			String result = g.toJson(list);
			System.out.println(result);
			response.getWriter().append(result);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}

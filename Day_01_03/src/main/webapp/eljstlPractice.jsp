<%@page import="dto.ContactDTO"%>
<%@page import="java.util.List"%>
<%@page import="dao.ContactDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Index </title>
</head>
<body>
	
	EL( Expression Language) <br>
	
	
	<!-- EL -->
	${ simple1} : ${simple2 } : ${array}  <br>
	
	${array[0] }<br>
	${array[1] }<br>
	${array[2] }<br>
	
	<!-- = contact.getSeq() -->
	${contact.seq } : ${contact.name } : ${contact.contact } <br>
	
	${list[0].seq } : ${list[0].name } : ${list[0].contact } <br>
	${list[1].seq } : ${list[1].name } : ${list[1].contact } <br>
	${list[2].seq } : ${list[2].name } : ${list[2].contact } <br>
	
	<hr>
	/ JSTL (Java Standard Tag Library) <br>
	
	${simple1==10}<br>
	<c:if test="${simple1==10}">
		Simple1 안에 저장된 값은 10 입니다.<br>
	</c:if>
	
	<c:choose>
		<c:when test="${simple==10 }">
		simple1 안에 저장된 값은 10 입니다.
		</c:when>
		<c:when test="${simple1==11 }" >
		simple1안에 저장된 값은 11 입니다.
		</c:when>
		<c:otherwise>
		simple1 안에 저장된 값은 10도 11도 아닙니다.
		</c:otherwise>
	</c:choose>
	
	<c:forEach var="dto" items="${list}">
	${dto.seq } : ${dto.name } : $ {dto.contact} <br>
	</c:forEach>
	
	

<%-- <%
	ContactDAO dao = ContactDAO.getInstance();
	List<ContactDTO> list = dao.selectAll();
	
%>

	<table border=1 align=center>
	<tr>
		<th colspan=3> Contacts
	</tr>
	<tr>
		<th>
		<th>Name
		<th>Contact
	</tr>
	<%
		for(ContactDTO dto : list){
			%>
			<tr>
				<td><%=dto.getSeq()%>
				<td><%=dto.getName()%>
				<td><%=dto.getContact()%>
		 </tr>
		 <% 
		}
	%>

	</table>
 --%>
</body>
</html>
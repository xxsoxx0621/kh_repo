<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>output page</title>
</head>
<body>
	
	<table border=1 align=center>
	<tr>
		<th colspan=6>Contents
	</tr>
	<tr>
		<th>Id
		<th>Name
		<th>Kor
		<th>Eng
		<th>Sum
		<th>Avg
	</tr>

	<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.id }
			<td>${dto.name }
			<td>${dto.kor }
			<td>${dto.eng }
			<td>${dto.kor + dto.eng }
			<td>${(dto.kor + dto.eng)/2}
		</tr>
	</c:forEach>
	
	
	<tr>
		<td> <a href="index.html">Back</a>
	</tr>
	
	
	
	</table>
</body>
</html>
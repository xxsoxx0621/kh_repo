<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>

	<!-- AJAX : Asynchronous Javascript And XML -->
	<!-- "화면 전환 없는" 요청 및 응답을 처리하는 메소드 -->
	
	<fieldset>
		<legend>1.단순 요청</legend>
		<button id="ajax01">Simple AJAX</button>
	</fieldset>
	
	<fieldset>
		<legend>2.데이터를 담아서 요청</legend>
		<button id="ajax02">AJAX with data</button>
	</fieldset>
	
	<fieldset>
		<legend>3.비동기 요청에 대한 응답 수신</legend>
		<button id="ajax03">AJAX with response</button>
	</fieldset>
	
	<fieldset>
		<legend>4.비동기 요청에 대한 다량 데이터 응답</legend>
		<button id="ajax04">AJAX response with array data</button>
	</fieldset>
	
	<fieldset>
		<legend>5.비동기 요청에 대한 객체 데이터 응답</legend>
		<button id="ajax05">AJAX response with object data</button>
	</fieldset>
	
	<fieldset>
		<legend>6.비동기 요청에 대한 객체배열 데이터 응답</legend>
		<button id="ajax06">AJAX response with object array data</button>
	</fieldset>
	
	
	
	<script>
	
		// [] -> 배열
		// {} -> 객체
		
		// 자바스크립트에서 객체를 만드는 3가지 방법
		// 1. new Object : 자바 스크립트 기본 객체 -> 잘 안쓰임
		// 2. function Constructor() // 생성자 함수
		// 3. {} // 객체 Literal -> Javascript Object Notation = JSON
		// {key:value}
		
		$("#ajax01").on("click",function(){
			
			$.ajax({ // 파라미터, 즉 인자 값으로 json값을 하나 받아와야 함
				
				url : "/exam01.ajax" // 필수 키 값 -> 어디로 보낼지
			}); 
		})
		
		$("#ajax02").on("click",function(){
			
			$.ajax({ // 파라미터, 즉 인자 값으로 json값을 하나 받아와야 함
				
				url : "/exam02.ajax", // 필수 키 값 -> 어디로 보낼지
				type : "post",
				data : {
						key1:"apple",
						key2:"orange"
					}
			}); 
		})
		
			
		$("#ajax03").on("click",function(){
			
			$.ajax({ // 파라미터, 즉 인자 값으로 json값을 하나 받아와야 함
				
				url : "/exam03.ajax" // 필수 키 값 -> 어디로 보낼지
				
			}).done(function(resp){
				console.log(resp);
			}); 
		})
		
		
		$("#ajax04").on("click",function(){
			
			$.ajax({ // 파라미터, 즉 인자 값으로 json값을 하나 받아와야 함
				
				url : "/exam04.ajax",// 필수 키 값 -> 어디로 보낼지
				dataType : "json" // JSON.parse을 안써도 dataType 설정을 통해서 자동 변환 시킬 수 있음
				
			}).done(function(resp){
				
				/* let result = JSON.parse(resp); // JSON.parse()를 사용하면 진짜 배열로 변환해서 쓸 수 있음 */
		
				console.log(resp[0]);
				console.log(resp[1]);
				console.log(resp[2]);
			}); 
		})
		
		$("#ajax05").on("click",function(){
			
			$.ajax({ // 파라미터, 즉 인자 값으로 json값을 하나 받아와야 함
				
				url : "/exam05.ajax" ,// 필수 키 값 -> 어디로 보낼지
				dataType : "json"
				
			}).done(function(resp){

				console.log(resp);
				console.log(resp.id);
			}); 
		})
		
		$("#ajax06").on("click",function(){
			
			$.ajax({ // 파라미터, 즉 인자 값으로 json값을 하나 받아와야 함
				
				url : "/exam06.ajax", // 필수 키 값 -> 어디로 보낼지
				dataType : "json"
				
			}).done(function(resp){
				/* let result = JSON.parse(resp);
				for(let i=0; i < result.length; i++){
					console.log(result[i].id + " : " + result[i].name + " : " + result[i].contact);
				} */
				
				for(let i=0; i < resp.length; i++){
					console.log(resp[i].id + " : " + resp[i].name + " : " + resp[i].contact);
				}
				
			}); 
		})

	</script>
</body>
</html>
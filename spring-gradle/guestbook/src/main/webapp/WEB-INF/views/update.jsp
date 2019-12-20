<%@ page import="com.nhn.guestbook.dto.BoardDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
	<meta charset="UTF-8"> 
	<title>Insert title here</title> 
</head> 
<body> 
	<h1>방명록</h1> 
	<% BoardDto board = (BoardDto) request.getAttribute("boards"); %>
	<form id="insertForm" action="/" method="POST" >
		<p>이메일 : <span id="email"><%= board.getEmail() %></span> 비밀번호 : <input type="password" id="password"/></p>
		<p>본문 : <textarea id="content" cols="100" rows="5"><%= board.getContent() %></textarea></p>
	</form>
	<input type="button" onclick="updateBoard(<%=board.getId() %>)" value="방명록 수정하기"/>
	
</body>
<script src='/resources/js/jquery-3.4.1.min.js' charset="utf-8"></script>
<script src='/resources/js/board.js' charset="utf-8"></script> 
</html>
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
	<form id="insertForm" action="/" method="POST" >
		<p>이메일 : <input type="text" id="email"/> 비밀번호 : <input type="password" id="password"/></p>
		<p>본문 : <textarea id="content" cols="100" rows="5"></textarea></p>
	</form>
	<input type="button" onclick="insertBoard()" value="방명록 남기기"/>
	
	<h4> 목록 </h4>
	<table>
		<thead>
			<tr>
				<th>본문</th>
				<th>이메일</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
			<% 
				List<BoardDto> boards = (List<BoardDto>) request.getAttribute("boards");
				for(BoardDto board : boards) {
			%>
			<tr>
				<td><%= board.getContent() %></td>
				<td><%= board.getEmail() %></td>
				<td><input type="button" onClick="update(<%= board.getId() %>)"  value="수정"></td>
				<td><input type="button" onClick="deleteBoard(<%= board.getId() %>)" value="삭제"></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body>
<script src='resources/js/jquery-3.4.1.min.js' charset="utf-8"></script>
<script src='resources/js/board.js' charset="utf-8"></script> 
</html>
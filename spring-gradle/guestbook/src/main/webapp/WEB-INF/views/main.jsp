<%@ page import="com.nhn.guestbook.model.Board" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
	<meta charset="EUC-KR"> 
	<title>Insert title here</title> 
</head> 
<body> 
	<h1>방명록</h1> 
	<form action="/" method="POST">
		<p>이메일 : <input type="text" name="email"/></p>
		<p>비밀번호 : <input type="password" name="password"/></p>
		<p>본문 : <textarea name="content" cols="30" row="5"></textarea></p>
		<input type="submit" value="메시지 남기기"/>
	</form>
	
	<h4> 목록 </h4>
	<table>
		<thead>
			<tr>
				<th>본문</th>
				<th>이메일</th>
			</tr>
		</thead>
		<tbody>
			<% 
				List<Map<String, Object>> boards = (List<Map<String, Object>>) request.getAttribute("boards");
				for(Map<String, Object> board : boards) {
			%>
			<tr>
				<td><%= board.get("content") %></td>
				<td><%= board.get("email") %></td>
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
</body> 
</html>
<%@ page import="com.nhn.guestbook.dto.BoardDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<!DOCTYPE html> 
<html> 
<head> 
	<meta charset="UTF-8"> 
	<title>Insert title here</title> 
	<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="/resources/css/board.css">
</head> 
<body> 
<div class="container">
	</br>
	<h1>방명록</h1>
	</br> 
	<% BoardDto board = (BoardDto) request.getAttribute("boards"); %>
	<form id="insertForm" action="/" method="POST" >
			<div class="row">
				<label class="col-md-2 control-label">이메일</label>
				<div class="col-md-4">
					<%= board.getEmail() %>
				</div>
				<label class="col-md-2 control-label">비밀번호</label>
				<div class="col-md-4">
					<input type="password" class="form-control" id="password"/>
				</div>
			</div>
			<div class="form-group">
				<label >본문</label>
				<textarea class="form-control" id="content" rows="5"><%= board.getContent() %></textarea>
			</div>
		</form>
		<button class="btn btn-primary" onclick="updateBoard(<%=board.getId() %>)">방명록 수정하기</button>
	</div>
</body>
<script src='/resources/js/jquery-3.4.1.min.js' charset="utf-8"></script>
<script src='/resources/js/board.js' charset="utf-8"></script> 
</html>
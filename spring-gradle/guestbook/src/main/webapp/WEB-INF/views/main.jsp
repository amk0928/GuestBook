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
	<div class="col-md-12">
		</br>
		<h1>방명록</h1>
		</br> 
		<form id="insertForm" action="/" method="POST" >
			<div class="row">
				<label class="col-md-2 control-label">이메일</label>
				<div class="col-md-4">
					<input type="text" class="form-control" id="email"/>
				</div>
				<label class="col-md-2 control-label">비밀번호</label>
				<div class="col-md-4">
					<input type="password" class="form-control" id="password"/>
				</div>
			</div>
			<div class="form-group">
				<label >본문</label>
				<textarea class="form-control" id="content" rows="5"></textarea>
			</div>
		</form>
		<button class="btn btn-primary w-auto" onclick="insertBoard()">방명록 남기기</button>
		</br>
		</br>
		<h4> 목록 </h4>
		<table id="baordList" class="table table-striped table-condensed">
			<thead id="boardListHead">
				<tr>
					<th style="width: 60%;">본문</th>
					<th style="width: 20%;">이메일</th>
					<th style="width: 10%;">수정</th>
					<th style="width: 10%;">삭제</th>
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
					<td><button class="btn btn-default" onClick="update(<%= board.getId() %>)">수정</button></td>
					<td><button class="btn btn-danger" onClick="deleteBoard(<%= board.getId() %>)">삭제</button></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
	</div>
</div>
</body>
<script src='/resources/js/jquery-3.4.1.min.js' charset="utf-8"></script>
<script src='/resources/js/board.js' charset="utf-8"></script> 
</html>
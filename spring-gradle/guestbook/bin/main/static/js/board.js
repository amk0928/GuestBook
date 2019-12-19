function deleteBoard(id) {
	var board = {
			id: Number(id)
	};
	console.log(JSON.stringify(board));
	$.ajax({
		url: '/delete',
		type: "post",
		data : JSON.stringify(board),
		contentType: 'application/json; charset=UTF-8',
		success: function(data) {
			alert('삭제되었습니다.');
			location.reload();
		},
		error : function(data) {
			console.log(data);
			alert("삭제에 실패했습니다.")
		}
	})
}

function insertBoard() {
	var email = $("#email").val();
	var password = $("#password").val();
	var content = $("#content").val();
	var board = {
			email: email,
			password: password,
			content: content
	};
	console.log(board);
	$.ajax({
		url: '/',
		type: 'post',
		data: JSON.stringify(board),
		contentType: 'application/json; charset=UTF-8',
		success: function(data) {
			alert('방명록이 작성되었습니다.');
			location.reload();
		},
		error : function(data) {
			console.log(data);
			alert("작성에 실패했습니다.")
		}
	})
	
	
}

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
	if(checkEmail(email)) {
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
	} else {
		alert("이메일 형식이 올바르지 않습니다.")
	}
}

function update(id) {
	$(location).attr('href', '/update/'+id);
}

function updateBoard(id) {
	var email = $("#email").val();
	var password = $("#password").val();
	var content = $("#content").val();
	var board = {
			id: id,
			email: email,
			password: password,
			content: content
	};
	console.log(board);
	$.ajax({
		url: '/update',
		type: 'post',
		data: JSON.stringify(board),
		contentType: 'application/json; charset=UTF-8',
		success: function(data) {
			alert('방명록이 수정되었습니다.');
			$(location).attr('href', '/');
		},
		error : function(data) {
			if(data.status == 401) {
				alert("비밀번호가 틀렸습니다.")
			} else {
				alert("수정에 실패했습니다.")
			}
			console.log(data.status);
			
		}
	})
}

function checkEmail(email) {
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;

    if (regExp.test(email)) return true;

    else return false;

}
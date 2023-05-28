<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
	<h1>회원 탈퇴</h1>
	<form action="delete" method="POST">
		아이디 : <input type="text" name="memberId" value="${sessionScope.memberId }" readonly><br>
		비밀번호 : <input type="password" name="memberPw"><br>
		<input type="submit" value="탈퇴하기">
	</form>
</body>
</html>
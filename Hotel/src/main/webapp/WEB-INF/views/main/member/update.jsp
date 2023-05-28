<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 수정</title>
<!-- 부트스트랩 CDN 링크 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<style>
.container {
	padding-left: 200px;
	padding-right: 200px;
}
</style>
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">내 정보 수정</h2>
		<form action="update" method="POST">
			<div class="form-group">
				<label for="memberId">아이디</label> <input type="text"
					class="form-control" id="memberId" name="memberId"
					readonly value="${sessionScope.memberId }"> <span id="message"></span>
			</div>
			<div class="form-group">
				<label for="memberPw">비밀번호</label> <input type="password"
					class="form-control" id="memberPw" name="memberPw"
					placeholder="비밀번호 입력" required>
			</div>
			<div class="form-group">
				<label for="memberName">이름</label> <input type="text"
					class="form-control" id="memberName" name="memberName"
					placeholder="이름 입력" required>
			</div>
			<div class="form-group">
				<label for="memberPhone">휴대폰 번호</label> <input type="text"
					class="form-control" id="memberPhone" name="memberPhone"
					placeholder="휴대폰 번호 입력" required>
			</div>
			<div class="form-group">
				<label for="memberEmail">이메일</label> <input type="text"
					class="form-control" id="memberEmail" name="memberEmail"
					placeholder="이메일 입력" required>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary btn-block" value="수정하기">
			</div>
		</form>
	</div>
	
</body>
</html>
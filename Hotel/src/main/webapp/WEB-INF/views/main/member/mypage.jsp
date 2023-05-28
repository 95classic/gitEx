<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>${sessionScope.memberId } 님 마이페이지</h1>
	<a href="main">메인으로</a>
	<a href="myReservation">내 예약 목록</a>
	<a href="myWanted">내 찜 목록</a>
	<a href="update">내 정보 수정</a>
	<a href="delete">회원 탈퇴</a>
	
	<input type="hidden" id="alert" value="${result }">
	
	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'updateSuccess') {
			alert('내 정보 수정 완료!');
		}
	</script>
	
</body>
</html>
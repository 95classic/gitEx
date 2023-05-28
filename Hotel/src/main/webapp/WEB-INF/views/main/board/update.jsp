<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.boardTitle}</title>
<!-- 부트스트랩 링크 추가 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>글 수정 페이지</h2>
		<form action="update" method="POST">
			<input type="hidden" name="page" value="${page}">
			<div class="form-group">
				<label for="boardId">글 번호:</label>
				<p class="form-control-static">${vo.boardId}</p>
				<input type="hidden" name="boardId" value="${vo.boardId}">
			</div>
			<div class="form-group">
				<label for="boardTitle">제목:</label>
				<input type="text" class="form-control" id="boardTitle" name="boardTitle" placeholder="제목 입력" required value="${vo.boardTitle}">
			</div>
			<div class="form-group">
				<label for="memberId">작성자:</label>
				<p class="form-control-static">${vo.memberId}</p>
			</div>
			<div class="form-group">
				<label for="boardDateCreated">작성일:</label>
				<p class="form-control-static">
					<fmt:formatDate value="${vo.boardDateCreated}" pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated" />
					${boardDateCreated}
				</p>
			</div>
			<div class="form-group">
				<label for="boardContent">내용:</label>
				<textarea class="form-control" id="boardContent" rows="20" name="boardContent" placeholder="내용 입력" required>${vo.boardContent}</textarea>
			</div>
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="등록">
			</div>
		</form>
	</div>

<!-- 부트스트랩 자바스크립트 파일 추가 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
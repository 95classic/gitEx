<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>글 작성 페이지</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
        crossorigin="anonymous">
    <style>
        body {
            padding-top: 3rem;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>글 작성 페이지</h1>
        <form action="register" method="POST">
            <div class="form-group">
                <label for="boardTitle">제목 :</label>
                <input type="text" id="boardTitle" name="boardTitle" class="form-control"
                    placeholder="제목 입력" required>
            </div>
            <div class="form-group">
                <label for="memberId">작성자 :</label>
                <input type="text" id="memberId" name="memberId" class="form-control"
                    placeholder="작성자 입력" value="${sessionScope.memberId }" readonly>
            </div>
            <div class="form-group">
                <label for="boardContent">내용 :</label>
                <textarea id="boardContent" rows="10" name="boardContent" class="form-control"
                    placeholder="내용 입력" required></textarea>
            </div>
            <div class="form-group">
                <input type="submit" value="등록" class="btn btn-primary">
            </div>
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
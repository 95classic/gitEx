<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   <title>QnA 게시판</title>
   <!-- 부트스트랩 링크 추가 -->
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
   <!-- jQuery 링크 추가 -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
   <!-- 부트스트랩 자바스크립트 링크 추가 -->
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<body>
   <div class="container">
      <h1 class="text-center mt-5 mb-4">QnA 게시판</h1>
      <a href="register"><button type="button" class="btn btn-primary mb-3">글 작성</button></a>
      <table class="table table-striped">
         <thead>
            <tr>
               <th style="width : 60px">번호</th>
               <th style="width : 500px">제목</th>
               <th style="width : 120px">작성자</th>
               <th style="width : 100px">작성일</th>
               <th style="width : 60px">댓글수</th>
            </tr>
         </thead>
         <tbody>
            <c:forEach var="vo" items="${list }">
               <tr>
                  <td>${vo.boardId }</td>
                  <td><a href="detail?boardId=${vo.boardId }&page=${pageMaker.criteria.page}" class="text-dark">${vo.boardTitle }</a></td>
                  <td>${vo.memberId }</td>
                  <fmt:formatDate value="${vo.boardDateCreated }"
                  pattern="yyyy-MM-dd HH:mm:ss" var="boardDateCreated" />
                  <td>${boardDateCreated }</td>
                  <td>${vo.replyCnt }</td>
               </tr>
            </c:forEach>
         </tbody>
      </table>
      <ul class="pagination justify-content-center">
         <c:if test="${pageMaker.hasPrev }">
            <li class="page-item"><a href="list?page=${pageMaker.startPageNo - 1 }" class="page-link">이전</a></li>
         </c:if>
         <c:forEach begin="${pageMaker.startPageNo }" end="${pageMaker.endPageNo }" var="num">
            <li class="page-item"><a href="list?page=${num }" class="page-link">${num }</a></li>
         </c:forEach>
         <c:if test="${pageMaker.hasNext }">
            <li class="page-item"><a href="list?page=${pageMaker.endPageNo + 1 }" class="page-link">다음</a></li>
         </c:if>
      </ul>
   </div>
   <!-- BoardController -> registerPOST()에서 보낸 데이터 저장 -->
   <input type="hidden" id="alert" value="${result }">

   <script type="text/javascript">
      var result = $('#alert').val();
      if (result == 'registerSuccess') {
         alert('게시글 작성 성공!');
      } else if (result == 'deleteSuccess') {
         alert('게시글 삭제 성공!');
      } else if (result == 'updateSuccess') {
         alert('게시글 수정 성공!');
      }
   </script>

</body>
</html>
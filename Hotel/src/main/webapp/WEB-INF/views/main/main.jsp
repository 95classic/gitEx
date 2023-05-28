<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>호텔</title>
<body>
	<a href="main">메인</a>
	<a href="board/list">게시판</a>

	<c:if test="${not empty sessionScope.memberId }">
		<p>${sessionScope.memberId }님,반갑습니다!</p>
		<a href="member/logout">로그아웃</a>
		<a href="member/mypage">마이페이지</a>
	</c:if>
	<c:if test="${empty sessionScope.memberId }">
		<a href="member/login">로그인</a>
	</c:if>

	<a href="member/register">회원가입</a>

	<input type="hidden" id="alert" value="${result }">

	<script type="text/javascript">
		var result = $('#alert').val();
		if (result == 'registerSuccess') {
			alert('회원가입 완료!');
		} else if (result == 'deleteSuccess') {
			alert('회원탈퇴 완료!');
		} else if (result == 'loginSuccess') {
			alert('로그인 완료!');
		} else if (result == 'logoutSuccess') {
			alert('로그아웃 완료!');
		}
	</script>

<%-- 	<div style="text-align: right;">
		<c:if test="${empty heart }">
			<button type="button" id="heart">&#x2661;</button>
		</c:if>
		<c:if test="${not empty heart }">
			<button type="button" id="heart">&#x2764;</button>
		</c:if>
	</div> --%>
	<!-- 호텔 -->
	<div class="container" style="text-align: center">
		<h1 class="text-center mt-5 mb-4">호텔</h1>
		<table class="table table-striped text-center">
			<thead>
				<tr>
					<th style="width: 60px">번호</th>
					<th style="width: 500px">이름</th>
					<th style="width: 120px">내용</th>
					<th style="width: 100px">가격</th>
					<th style="width: 60px">리뷰 수</th>
					<th style="width: 60px">좋아요</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="vs">
					<tr>
						<td class="text-center mt-5 mb-4" id="hotelId" > ${vo.hotelId }</td>
						<td><a
							href="detail?hotelId=${vo.hotelId }&page=${pageMaker.criteria.page}"
							class="text-dark">${vo.hotelName }</a></td>
						<td>${vo.hotelContent }</td>
						<td>${vo.hotelPrice }</td>
						<td>${vo.reviewCnt }</td>
						<td><button id="heartNo_${vo.hotelId}" value="${vo.hotelId }">&#x2661;</button></td>
						
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<ul class="pagination justify-content-center">
			<c:if test="${pageMaker.hasPrev }">
				<li class="page-item"><a
					href="main?page=${pageMaker.startPageNo - 1 }" class="page-link">이전</a></li>
			</c:if>
			<c:forEach begin="${pageMaker.startPageNo }"
				end="${pageMaker.endPageNo }" var="num">
				<li class="page-item"><a href="main?page=${num }"
					class="page-link">${num }</a></li>
			</c:forEach>
			<c:if test="${pageMaker.hasNext }">
				<li class="page-item"><a
					href="main?page=${pageMaker.endPageNo + 1 }" class="page-link">다음</a></li>
			</c:if>
		</ul>
	</div>



<c:if test="${not empty sessionScope.memberId }">
<div>
	<input type="hidden" id="memberId" value="${sessionScope.memberId }" readonly>
</div>
</c:if>


<script type="text/javascript">
$(document).ready(function () {
	console.log("ssss");
    // 하트 클릭 이벤트;
  // $("#heartNo").click( function () { 
	   $("button[id^='heartNo_']").click( function () {  
		 
		  //console.log(('#heartNo').val());
        var heartNo = $('#heartNo').val();
        var hotelId = $(this).val();
        var memberId = $('#memberId').val();
        var obj = {
        		'heartNo': heartNo,
        		'hotelId': hotelId,
        		'memberId': memberId
        };
        
            $.ajax({
                url: 'heart',
                type: 'POST',
                data: JSON.stringify(obj),
                contentType: 'application/json', // 안쓰면 415오류 이유는 아직 모르겠음
                headers : {
                'contentType' : 'application/json'
                },
                success: function (result) {
                	console.log('들어와라제바룹1231231231ㄹ');
                	if(result == 1) {
                		$("#heartNo_"+hotelId).html("&#x2764;"); // 빨간 하트
               		
                		console.log('빨간하트 들어오시나연');
                		
                	} else {
                		$("#heartNo_"+hotelId).html("&#x2661;"); // 빈 하트
                		

                		console.log('빈하트 들어오시나연');
                	}
                }
                
            });
    });
});
</script>


</body>
</html>
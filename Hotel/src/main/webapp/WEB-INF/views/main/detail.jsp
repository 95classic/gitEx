<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${vo.hotelName}</title>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>

		<h1>호텔 보기</h1>
				<p>호텔 번호 : ${vo.hotelId}</p>
				<p>호텔 이름 : ${vo.hotelName}</p>
				<p>호텔 내용 : ${vo.hotelContent}</p>
				<p>호텔 가격 : ${vo.hotelPrice}</p>
			<div>
				<textarea readonly>${vo.hotelContent}</textarea>
			</div>
			<a href="main?page=${page}"><button>호텔 목록</button></a>
		
	
	
	<input type="hidden" id="hotelId" value="${vo.hotelId }">

	<c:if test="${not empty sessionScope.memberId }">
	<div>
		<input type="text" id="memberId" value="${sessionScope.memberId }" readonly>
		<input type="text" id="reviewContent">
		<button id="btn_add">작성</button>
	</div>

	</c:if>
	
	<c:if test="${empty sessionScope.memberId }">
		<p>리뷰는 로그인이 필요한 기능입니다.<a href="./member/login">로그인하기</a></p>
	</c:if>

	<hr>
	<div style="text-align: center;">
		<div id="reviews"></div>
	</div>

	<script type="text/javascript">
		$(document).ready(function(){
			getAllReviews();
			
			$('#btn_add').click(function(){
				var hotelId = $('#hotelId').val(); // 호텔 번호 데이터
				var memberId = $('#memberId').val(); // 작성자 데이터
				var reviewContent = $('#reviewContent').val(); // 리뷰 내용
				var obj = {
						'hotelId' : hotelId,
						'memberId' : memberId,
						'reviewContent' : reviewContent
				}
				console.log(obj);
				
				// $.ajax로 송수신
				$.ajax({
					type : 'POST', 
					url : 'reviews',
					headers : {
						'Content-Type' : 'application/json'
					}, 
					data : JSON.stringify(obj), // JSON으로 변환
					success : function(result) {
						console.log(result);
						if(result == 1) {
							alert('리뷰 입력 성공');
							getAllReviews();
						}
					}
				});
			}); // end btn_add.click()
			
			// 호텔 리뷰 전체 가져오기
			function getAllReviews() {
				var hotelId = $('#hotelId').val();
				
				var url = 'reviews/all/' + hotelId;
				$.getJSON(
					url,
					function(data){
						// data : 서버에서 전송받은 list 데이터가 저장되어 있음
						// getJSON()에서 json 데이터는
						// javascript object로 자동 parsing됨
					
						console.log(data);
						var memberId = $('#memberId').val();
						var list = ''; // 리뷰 데이터를 HTML에 표현할 문자열 변수
					
						// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수
						$(data).each(function(){
							// this : 컬렉션의 각 인덱스 데이터를 의미
							console.log(this);
						
							var hidden = 'hidden';
							var readonly = 'readonly';
							var reviewDate = moment(this.reviewDateCreated).format('YYYY-MM-DD HH:mm:ss'); 
							// moment = 시간 날짜를 파싱 해주는 객체 (라이브러리 추가)
							
							if(memberId == this.memberId) { 
								hidden = '';
								readonly = '';
							}
							
							list += '<div class="review_item">'
								+ '<pre>'
								+ '<input type="hidden" id="reviewId" value="'+ this.reviewId +'">'
								+ this.memberId
								+ '&nbsp;&nbsp;' // 공백
								+ '<input type="text" ' + readonly + ' id="reviewContent" value="'+ this.reviewContent +'">'
								+ '&nbsp;&nbsp;'
								+ reviewDate
								+ '&nbsp;&nbsp;'
								+ '<button class="btn_update" ' + hidden + '>수정</button>'
								+ '<button class="btn_delete" ' + hidden + '>삭제</button>'
								+ '</pre>'
								+ '</div>';
						}); // end each()
						$('#reviews').html(list);
					} // end function()
				);// end getJSON()
			} // end getAllReplies()
			
			// 수정 버튼을 클릭하면 선택된 리뷰 수정
			$('#reviews').on('click', '.review_item .btn_update', function(){
				console.log(this);
				
				// 선택된 리뷰의 reviewId, reviewContent 값을 저장
				// preAll() : 선택된 노드 이전에 있는 모든 형제 노드를 접근
				var reviewId = $(this).prevAll('#reviewId').val();
				var reviewContent = $(this).prevAll('#reviewContent').val();
				console.log("선택된 리뷰 번호 : " + reviewId + ", 리뷰 내용 : " + reviewContent);
				
				// ajax요청
				$.ajax({
					type : 'PUT',
					url : 'reviews/' + reviewId,
					headers : {
						'Content-Type' : 'application/json'
					},
					data : JSON.stringify({
						reviewId : reviewId,
						reviewContent : reviewContent
						}),
					success : function(result) {
						console.log(result);
						if(result == 1) {
							alert('댓글 수정 성공!');
						getAllReviews();
						}
					}
					
				}); // end ajax()
			});// end replies.on()
			
			// 삭제 버튼을 클릭하면 선택된 리뷰 삭제
			$('#reviews').on('click', '.review_item .btn_delete', function(){
				console.log(this);
				var hotelId = $('#hotelId').val();
				var reviewId = $(this).prevAll('#reviewId').val();
				
				// ajax 요청
				$.ajax({
					type : 'DELETE',
					url : 'reviews/' + reviewId,
					headers : {
						'Content-Type' : 'application/json'
					},
					data : hotelId,
					success : function(result) {
						console.log(result);
						if(result == 1) {
							alert('리뷰 삭제 성공!');
							getAllReviews();
						}
					}
				});
			});
		}); // end document
	</script>


</body>
</html>


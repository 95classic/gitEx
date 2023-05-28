<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</head>
<body>
	<h2>회원 가입</h2>
	<form action="register" method="POST">
		<div>
			<p>아이디 : </p>
			<input type="text" name="memberId" id="memberId" placeholder="아이디 입력" autofocus required>
			<span id="messageId"></span>
		</div>
		<div>
			<p>비밀번호 : </p>
			<input type="text" name="memberPw" id="memberPw" placeholder="비밀번호 입력" required>
			<span id="messagePw"></span>
		</div>
		
		<div>
			<p>비밀번호 확인 : </p>
			<input type="text" name="memberPwCk" id="memberPwCk" placeholder="비밀번호 입력확인" required>
			<span id="messagePwCk"></span>
		</div>
		
		
		<div>
			<p>이름 : </p>
			<input type="text" name="memberName" placeholder="이름 입력" required>
		</div>
		<div>
			<p>휴대폰 번호 : </p>
			<input type="text" name="memberPhone" placeholder="휴대폰 번호 입력" required>
		</div>
		<div>
			<p>이메일 : </p>
			<input type="text" name="memberEmail" placeholder="이메일 입력" required>
		</div>
		<div>
			<input type="submit" value="회원 가입">
		</div>
	</form>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#memberId").blur(function(){
			var memberId = $(this).val(); // 아이디 입력값 가져오기
			if(memberId != "") { // 아이디 입력했을때
				$.ajax({
					type : 'post',
					url : '/hotel/main/member/idCheck', // controller의 idcheck로 보냄
					data : {memberId: memberId},
					success: function(data){
						
						if(data >= 1) {// 중복된 아이디가 있을때
							$("#messageId").html("이미 사용중이 아이디입니다");
						} else { // 중복된 아이디 없을때
							$("#messageId").html("사용 가능한 아이디입니다.");
						}
					},
					error:function(){
						$("#messageId").html("서버에서 오류가 발생하였습니다.");	
					//console.log(data);
					}
				});
			}
		});
	});

	// 비밀번호 확인 이벤트
	$(document).ready(function(){
	    $("#memberPwCk").blur(function(){
	        var memberPwCk = $(this).val();
	        var memberPw = $("#memberPw").val();
	        if(memberPwCk == memberPw){
	        	$("#messagePwCk").html("비밀번호가 같습니다");
	           
	        } else {
	        	$("#messagePwCk").html("비밀번호가 틀립니다.");

	        }
	    });
	});
	
	
	// 정규 표현식
	$(document).ready(function(){
	    $("#memberPwCk").blur(function(){
	        var memberPw = $("#memberPw").val();
	        var exp = /[a-z0-9]$/;
	        if(!exp.test(memberPw)){
	        	$("#messagePw").html("비밀번호는 영문과 숫자만 넣어주세요");
	        	$("#memberPw").focus();
	    } else {
        	$("#messagePw").html("비밀번호는 .");

        }
	    
	    });
	});
	
	</script>
</body>
</html>
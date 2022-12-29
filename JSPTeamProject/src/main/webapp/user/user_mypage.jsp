<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<style>
		.button{
		border:none;
		color: white;
		padding: 15px 15px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		cursor: pointer;
	}
	.button1 {background-color: #4CAF50;}
	

	a{
		width: 300px;
  		height: 32px;
		font-size: 15px;
		border: 0;
		border-radius: 15px;
		outline: none;
		padding-left: 10px;
		background-color: #4CAF50;
	}
	

</style>
<body>
	<section>
	<div id="s_left">
	<h1 align="center">게시판목록</h1>
		<div>
		<a href="${pageContext.request.contextPath}/shareboard/shareboard_list.sb" title="중앙정보회원 전체 사용가능합니다.">[공용게시판]</a><hr>
		<a href="${pageContext.request.contextPath}/classboard/classboard_list.classboard" title="같은반 회원만 사용가능합니다.">[반전용게시판]</a><hr>
		<a href="${pageContext.request.contextPath}/JobBoard/JobBoard_list.jobboard" title="선생님이 작성한 취업관련게시글 확인가능합니다.">[취업게시판]</a><hr>
		<a href="${pageContext.request.contextPath}/reqBoard/reqBoard_list.reqBoard" title="학생들의 고충&불편사항">[건의사항]</a><hr>
		<a href="${pageContext.request.contextPath}/user/user_mypage.user">[HOME]</a>
		</div>
	</div>
			
		
	<div id="content" align="center">
		<h2>
		${sessionScope.user_id }님 환영합니다.<hr>
		</h2>
		<h3>나의 정보</h3>
	<div align="left" style="width: 794px; height: 500px; background-color: white">	
		<h3>
		<p style="width: 400px;">이름: ${sessionScope.user_name}</p>
		<p style="width: 400px;">나이: ${sessionScope.user_age}</p>
		<p style="width: 400px;">성별: ${sessionScope.user_gender}</p>
		<p style="width: 400px;">클래스: ${sessionScope.user_classNo}</p>
		<p style="width: 400px;">담당 선생님 : ${sessionScope.user_teacher}</p>
		</h3>
	</div>	
	<p style="width: 700px;">
		<div>
		<a href="user_login.user">[로그아웃]</a>
		<a href="user_info.user">[정보수정]</a>
		</div>
	</p>	
		</div>
		
	<div id="s_right" align="center"
		style="overflow: hidden; display: flex; align-items: center;  justify-content: center;"><img src="../img/logo_new.png"></div>	
		
		
		
</section>
</body>
</html>
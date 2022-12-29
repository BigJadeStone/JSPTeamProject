<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<body>
	<div class="container" id="s_left">
		<h3 align="center">건의 게시판</h3>
		<a href="${pageContext.request.contextPath}/shareboard/shareboard_list.sb" title="중앙정보회원 전체 사용가능합니다.">[공용게시판]</a><hr>
		<a href="${pageContext.request.contextPath}/classboard/classboard_list.classboard" title="같은반 회원만 사용가능합니다.">[반전용게시판]</a><hr>
		<a href="${pageContext.request.contextPath}/JobBoard/JobBoard_list.jobboard" title="선생님이 작성한 취업관련게시글 확인가능합니다.">[취업게시판]</a><hr>
		<a href="${pageContext.request.contextPath}/reqBoard/reqBoard_list.reqBoard" title="학생들의 고충&불편사항">[건의사항]</a><hr>
		<a href="${pageContext.request.contextPath}/user/user_mypage.user" title="HOME으로 돌아가기">[ HOME ]</a><hr>
	</div>
	
	<div id="content">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${list }" varStatus="num">
				<tr>
					<td>${vo.rbno }</td>
					<td>${vo.id }</td>
					<td>
					<a href="reqBoard_content.reqBoard?rbno=${vo.rbno}">${vo.title }</a>
					</td>
					<td><fmt:formatDate value ="${vo.regdate}" pattern="yyyy-MM-dd HH시mm분"/></td>
				</tr>
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="6" align="right">
						<form action="" class="form-inline" >
						  <div class="form-group">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='reqBoard_write.reqBoard'">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>	
</body>
</html>
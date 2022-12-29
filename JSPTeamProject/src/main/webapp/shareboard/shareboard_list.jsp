<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<body>

	<div id="s_left">
		<h3 align="center">공용 게시판</h3>
		<a href="${pageContext.request.contextPath}/user/user_mypage.jsp" title="HOME으로 돌아가기">[ HOME ]</a><hr>
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
					<td align="center">${vo.sbno }</td>
					<td>${vo.writer }</td>
					<td><a href="shareboard_content.sb?sbno=${vo.sbno }">${vo.title }</a></td>
					<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd HH시 mm분"></fmt:formatDate></td>
				</tr>
			</c:forEach>
		</tbody>
		<tbody>
			<tr>
				<td colspan="6" align="right">
					<form action="" class="form-inline">
						<div class="form-group">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='shareboard_write.sb'">
							<input type="button" value="메인" class="btn btn-default" onclick="location.href='/JSPTeamProject/user/user_mypage.user'">
						</div>
					</form>
				</td>
			</tr>
		</tbody>
	</table>
	</div>
</body>
</html>
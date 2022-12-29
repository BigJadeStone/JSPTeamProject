<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<!-- 우선 바디만 작업하기 -->
<body>
<!-- end header -->

	<div class="container" id="s_left">
		<h3 align="center">${sessionScope.user_classNo }반 게시판</h3>
		<a href="${pageContext.request.contextPath}/user/user_mypage.jsp" title="HOME으로 돌아가기">[ HOME ]</a><hr>
		<h3>${vo.cbno }</h3>
	</div>
		
	<div id="content">	
		<table class="table table-borderd">
			<thead>
				<tr>
					<th>글번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="vo" items="${list}" varStatus="num">
				<tr>
					<td>${vo.cbno }</td>
					<td>${vo.id }</td>
					<td>
						<a href="classboard_content.classboard?cbno=${vo.cbno}">${vo.title }</a>
					</td>
					<td><fmt:formatDate value="${vo.regdate}" pattern = "yyyy-MM-dd HH시mm분ss초"/></td>
				</tr>
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="6" align="right">
						<form action="" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="search" placeholder="제목검색" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-default">
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='classboard_write.classboard'">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
				
		</table>
	</div>

<!-- footer -->
<!-- /footer -->
</body>
</html>
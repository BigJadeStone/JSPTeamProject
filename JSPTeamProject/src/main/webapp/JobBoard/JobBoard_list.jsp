<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<!DOCTYPE html>
<%@ include file="../include/header.jsp" %>
<body>

	<div class="container" id="s_left">
		<h3 align="center">취업 게시판</h3>
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
				<c:forEach var="i" items="${joblist }" varStatus="num">
				<tr>
					<td>${i.jno }</td>
					<td>${i.id }</td>
					<td>
						<a href="JobBoard_content.jobboard?jno=${i.jno }">${i.title }</a>
					</td>
					<td><fmt:formatDate value="${i.regdate }" pattern="yyyy-MM-dd HH시 mm분 ss초"/></td>
					
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
							<input type="button" value="글 작성" class="btn btn-default" onclick="location.href='JobBoard_write.jobboard'">
						  </div>
						</form> 
					</td>
				</tr>

			</tbody>
		
		</table>
	</div>
</body>
</html>
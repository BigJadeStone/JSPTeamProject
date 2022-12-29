<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.cbno }</td>
			
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.id }</td>
			<td>작성일</td>
			<td ><fmt:formatDate value="${vo.regdate}" pattern = "yyyy-MM-dd HH시mm분ss초"/></td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.title }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.content }</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='classboard_list.classboard'">&nbsp;&nbsp;
				<c:if test="${sessionScope.user_id == vo.id}">
				<input type="button" value="수정" onclick="location.href='classboard_modify.classboard?cbno=${vo.cbno}&writer=${vo.id }'">&nbsp;&nbsp;
				<input type="button" value="삭제" onclick="location.href='classboard_delete.classboard?cbno=${vo.cbno}&writer=${vo.id }'">&nbsp;&nbsp;
				</c:if>
				<c:if test="${sessionScope.user_teacher == null }">
				<input type="button" value="삭제" onclick="location.href='classboard_delete.classboard?cbno=${vo.cbno}&writer=${vo.id }'">&nbsp;&nbsp;
				</c:if>
			</td>
		</tr>
	</table>
	<!--board/board_delete.board  -->
	
	

	

</div>


</body>
</html>
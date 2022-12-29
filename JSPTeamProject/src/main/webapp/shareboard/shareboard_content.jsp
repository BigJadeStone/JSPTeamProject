<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${contVo.writer } 님의 글</title>
</head>
<body>

<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500">
		<tr>
			<td width="20%">글 번호</td>
			<td width="30%">${contVo.sbno }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><b>${contVo.writer }</b></td>
			<td>작성일</td>
			<td><b><fmt:formatDate value="${contVo.regdate }" pattern="yyyy-MM-dd HH시 mm분"/></b></td>
		</tr>
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3"><b>${contVo.title }</b></td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px"><b>${contVo.content }</b></td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='shareboard_list.sb'">&nbsp;&nbsp;
				<c:choose>
				<c:when test="${sessionScope.user_id == contVo.writer}">
					<input type="button" value="수정" onclick="location.href='shareboard_modify.sb?sbno=${contVo.sbno }&writer=${contVo.writer }'">&nbsp;&nbsp;
					<input type="button" value="삭제" onclick="if(!confirm('정말 삭제하시겠습니까?')) {return false} else {location.href='shareboard_delete.sb?sbno=${contVo.sbno }&writer=${contVo.writer }'}">&nbsp;&nbsp;
				</c:when>
				<c:when test="${sessionScope.user_teacher == null }">
					<input type="button" value="삭제" onclick="if(!confirm('정말 삭제하시겠습니까?')) {return false} else {location.href='shareboard_delete.sb?sbno=${contVo.sbno }&writer=${contVo.writer }'}">&nbsp;&nbsp;
				</c:when>
				</c:choose>
			</td>
		</tr>
	</table>
		<table border="1">
 		<c:forEach var="comment" items="${comment }">
		<tr>
				<c:if test="${comment.comment_boardNum == contVo.sbno }">
			<td width="150">
				<div>
					${comment.comment_id }<br>
					<font size="2" color="lightgrey">${comment.comment_date }</font>
				</div>
				
			</td>
			<td width="550">
				<div class="text_wrapper">
					${comment.comment_content }
				</div>
			</td>
			<td width="100">
				<div id="btn" style="text-align:center;">
					<c:if test="${comment.comment_id == sessionScope.user_id }">
						<input type="button" value="삭제" onclick="if(!confirm('댓글을 삭제하시겠습니까?')) {return false} else {location.href='sharecomment_delete.cm?boardNum=${comment.comment_num}&sbno=${contVo.sbno }'}">
					</c:if>
				</div>
			</td>
				</c:if>
		</tr>
		</c:forEach>
	</table>
	<div>
		<form action="commentRegi.cm" method="post">
			<table> <!-- 댓글 등록창 -->
					<tr>
						<td><input type="hidden" name="sbno" value="${contVo.sbno }"></td>
						<td style="border-bottom:none;" valign="middle">작성자 : ${sessionScope.user_id }</td>
						<td><input type="text" style="height:40px; width:300px;" name="comment_content" placeholder="댓글을 입력해주세요"></td>
						<td><br><br><input type="submit" value="작성하기"></td>
					</tr>
			</table>
		</form>
	</div>
</div>	

	
</body>
</html>
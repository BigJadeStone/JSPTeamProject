<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공용 게시판 글 쓰기</title>
</head>
<body>
	<div align="center" class="div_center">
		<h3>공용 게시판 글 작성 테스트</h3>
		<hr>
		
		<form action="registForm.sb" method="post">
			<table border="1" width="500">
				<tr>
					<td>작성자</td>
					<td>
						<input type="text" name="writer" value="${sessionScope.user_id }" size="10" readonly>
					</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>
						<input type="text" name="title" required>
					</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>
						<textarea rows="10" style="width: 95%;" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="작성">
						&nbsp;&nbsp;
						<input type="button" value="목록" onclick="location.href='shareboard_list.sb'">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
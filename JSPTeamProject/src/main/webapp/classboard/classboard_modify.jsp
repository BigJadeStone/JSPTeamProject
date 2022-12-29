<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
<!-- end header -->

<div>
	<h3>게시판 글 수정 페이지</h3>
	<hr> <!-- hr은 선을 그어준다. -->
	
	<form action="updateForm.classboard" method="post">
		<table border="1" width="500"> <!-- width는 가로 너비 사이즈를 지정해줌 -->
			<tr>
				<td>글 번호</td>
				<td>
					<input type="hidden" name="cbno" value="${vo.cbno }">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${vo.id }" readonly></td>
			</tr>
		 	<tr>
		 		<td>글 제목</td>
		 		<td>
		 			<input type="text" name="title" value="${vo.title }">
		 		</td>
		 	</tr>
		 	<tr>
		 		<td>글 내용</td>
		 		<td>
		 			<textarea rows="10" style="width:  95%;" name="content">${vo.content }</textarea>
		 		</td>	
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" onclick="locationi.href='updateForm.classboard?writer=${vo.id}'">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='classboard_list.classboard'">
				</td>
			</tr>
		</table>
	</form>
	
</div>

<!-- footer -->
<!-- /footer -->
</body>

</html>
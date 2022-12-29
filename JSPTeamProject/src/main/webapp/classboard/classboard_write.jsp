<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>



<!-- 우선 바디만 작업하기 -->
<body>
	<!-- end header -->

	<div align="center" class="div_center">
		<h3>게시판 글 작성 페이지</h3>
		<hr>
		
		<!-- 해당 반이 어딘지 작성자에 해당반에대한 정보를 쿼리스트링으로 넘겨줌 -->
		<form action="registForm.classboard?classNo=${sessionScope.user_classNo}" method="post">
		
		
			<table border="1" width="500">
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer"
						value="${sessionScope.user_id}" size="10" readonly required>
					</td>
				</tr>
				<tr>
					<td>글 제목</td>
					<td><input type="text" name="title" required></td>
				</tr>
				<tr>
					<td>글 내용</td>
					<td><textarea rows="10" style="width: 95%;" name="content"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="작성 완료">
						&nbsp;&nbsp; <input type="button" value="목록"
						onclick="location.href='classboard_list.classboard'"></td>
				</tr>

			</table>
		</form>

	</div>



	<!-- footer -->
	<!-- /footer -->
</body>

</html>
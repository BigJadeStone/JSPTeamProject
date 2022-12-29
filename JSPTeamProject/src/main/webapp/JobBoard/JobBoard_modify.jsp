<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div align="center" class="div_center">
	<!-- 관리자만 글 수정 가능 teacher컬럼에 값이 null이라면 수정 가능하게끔 만들기 -->
	<h3>취업게시판 글 수정 페이지</h3>
	<hr>
	
	<form action="updateForm.jobboard" method="post">
		
		<table border="1" width="500">
			
			<tr>
				<td>글 번호</td>
				<td>${vo.jno }
					
					<!-- hidden은 눈에 안 보이는 input태그이다. 
					화면에 보일 필요는 없는데 데이터가 반드시 전송되어야할 때 사용한다. -->
					
					<input type="hidden" name="jno" value="${vo.jno }">
				</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="id" value="${vo.id }" readonly></td>
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
					<textarea rows="10" style="width: 95%;" name="content">${vo.content }</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='JobBoard_list.jobboard'">        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" class="div_center">
	<h3>게시판 글 수정 페이지</h3>
	<hr>
	
	<form action="reqBoard_Form.reqBoard" method="post">
		
		<table border="1" width="500">
			
			<tr>
				<td>글 번호</td>
				<td>${vo.rbno}
					<input  type="hidden" name="rbno" value="${vo.rbno}"> <!-- 화면에 보일필요는 없는데 데이터는 전달이 필요할때 사용하는 태그 -->
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
					<textarea rows="10" style="width: 95%;" name="content">${vo.content}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" onclick="location.href='reqBoard_content.reqBoard'">&nbsp;&nbsp;
					<input type="button" value="목록" onclick="location.href='reqBoard_list.reqBoard'">        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>
</body>
</html>
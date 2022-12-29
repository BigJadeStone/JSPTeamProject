<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중앙정보처리학원 인트라넷</title>
<style>
	body{background-image:url('../img/01_bg.png');
	}
	

	.button{
		border:none;
		color: white;
		padding: 15px 15px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		cursor: pointer;
	}
	.button1 {background-color: #4CAF50;}
	

	input[type=text]{
		width: 300px;
  		height: 32px;
		font-size: 15px;
		border: 0;
		border-radius: 15px;
		outline: none;
		padding-left: 10px;
		background-color: rgb(233, 233, 233);
	}
	
	input[type=password]{
		width: 300px;
  		height: Auto;
		font-size: 15px;
		border: 0;
		border-radius: 15px;
		outline: none;
		padding-left: 10px;
		background-color: rgb(233, 233, 233);
	}
	
		input[type=password]{
		width: 300px;
  		height: 32px;
		font-size: 15px;
		border: 0;
		border-radius: 15px;
		outline: none;
		padding-left: 10px;
		background-color: rgb(233, 233, 233);
	}
	
</style>
</head>
<body>
	<section>
		<div class="main" align="center">
			<form action="login_Form.user" method="post">
				<br><br><br>
				<img src="../img/logo_new.png"><br>
				<br>
				<input type="text" name="id" placeholder="아이디"><br><br>
				<input type="password" name="pw" placeholder="비밀번호"><br><br>
				${msg } 
				<input type="submit" value="로그인" class="button button1">
			</form>
		</div>
	</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인페이지</title>
</head>
<body>
	<h2>로그인</h2>
	<form method="POST" action="/login">
		ID : <input type="text" name="id">
		PW : <input type="password" name="pw">
		<input type="submit" value="login">
		<button>로그인</button>
	</form>
</body>
</html>
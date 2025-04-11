<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인</h2>
	<form method="POST" action="/login"> <!--/를 넣는 것을 권장-->
		ID:<input type="text" name="id">
		PW:<input type="password" name="pw">
		<input type="submit" value="로그인">
		<!-- <button>로그인</button>으로 작성해도 됨(input 방식이 submit인게 button이랑 같은 의미 -->
	</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="loginServlet?type=submit" method="post">
	用户名：<input type="text" name="username" id="username"><span></span><br>
	密码	：<input type="password" name="password"id="password"><br>
	<input type="submit" id="submit1" value="登录">
	<input type="button" id="submit2" value="注册">
	</form>
	
	<script src="./js/jquery-3.1.1.js"></script>
	<script >
	$(function() {
		$('#submit2').click(function() {
			location.href = "showAdd.jsp";
		})
	})
		
	</script>
</body>
</html>